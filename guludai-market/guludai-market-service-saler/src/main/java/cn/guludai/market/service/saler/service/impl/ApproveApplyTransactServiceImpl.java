/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.service.saler.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.guludai.api.code.BaseCode;
import cn.guludai.api.data.Request;
import cn.guludai.api.data.Response;
import cn.guludai.app.api.ApplyShopApi;
import cn.guludai.app.api.response.ApiApplyShopResponse;
import cn.guludai.market.common.constants.BaseConstant;
import cn.guludai.market.common.constants.FlowNodeConstant;
import cn.guludai.market.domain.dao.ApproveApplyRecordEntityMapper;
import cn.guludai.market.domain.dao.ApproveApplyResultEntityMapper;
import cn.guludai.market.domain.dao.ApproveApplyTransactEntityMapper;
import cn.guludai.market.domain.dao.ApproveFlowNodeEntityMapper;
import cn.guludai.market.domain.dao.ApproveSecurityUserMapper;
import cn.guludai.market.domain.entity.ApproveApplyRecordEntity;
import cn.guludai.market.domain.entity.ApproveApplyResultEntity;
import cn.guludai.market.domain.entity.ApproveApplyTransactEntity;
import cn.guludai.market.domain.entity.ApproveSecurityUser;
import cn.guludai.market.service.saler.service.ApproveApplyTransactService;
import cn.guludai.market.web.code.MarketBaseCode;
import cn.guludai.market.web.request.ApproveApplyResultReq;
import cn.guludai.market.web.response.ApproveApplyResultResponse;
import cn.guludai.market.web.response.TableResponse;

@Service
public class ApproveApplyTransactServiceImpl implements ApproveApplyTransactService{
	
	private static final Logger logger = LoggerFactory.getLogger(ApproveApplyTransactServiceImpl.class);

	@Autowired
	private ApproveApplyTransactEntityMapper approveApplyTransactEntityMapper;
	
	@Autowired
	private ApproveApplyResultEntityMapper approveApplyResultEntityMapper;
	
	@Autowired
	private ApplyShopApi applyShopApi;
	
	@Autowired
	private ApproveSecurityUserMapper approveSecurityUserMapper;
	
	@Autowired
	private ApproveFlowNodeEntityMapper approveFlowNodeEntityMapper;
	
	@Autowired
	private ApproveApplyRecordEntityMapper approveApplyRecordEntityMapper;
	
	@Override
	public TableResponse<ApproveApplyResultResponse> findTaskListByTransactUser(
			ApproveApplyResultReq request) throws Exception {
		TableResponse<ApproveApplyResultResponse> result = new TableResponse<ApproveApplyResultResponse>();
		List<ApproveApplyTransactEntity> ls = approveApplyTransactEntityMapper.selectApplyTransacByUserCode(request);
		Integer total = approveApplyTransactEntityMapper.selectApplyTransacByUserCodeCount(request);
		List<ApproveApplyResultResponse> response = new ArrayList<ApproveApplyResultResponse>();
		for (ApproveApplyTransactEntity en : ls) {
			String applyCode = en.getApplyCode();
			ApproveApplyResultResponse p = new ApproveApplyResultResponse();
			ApproveApplyResultEntity entity = approveApplyResultEntityMapper.selectApproveApplyResultByApplyCode(applyCode);
			BeanUtils.copyProperties(p, entity);
			/*ApproveApplyRecordEntity resTwo = approveApplyRecordEntityMapper.selectApproveApplyRecordByNodeCodeAndActivitiCode(en.getNodeCode(),en.getActivitiCode());
			if(null!=resTwo) {
				String flowNodeResult = resTwo.getFlowNodeStatus();
				if (flowNodeResult.equals(BaseConstant.APPROVE_STATUS_Y)) {
					p.setFlowNodeStatus("同意通过");
				} else if (flowNodeResult.equals(BaseConstant.APPROVE_STATUS_N)) {
					p.setApproveStatus("拒绝通过");
				} else {
					p.setApproveStatus("审批中");
				}
			}
			if (p.getApproveResult().equals(BaseConstant.APPROVE_RESULT_Y)) {
				p.setApproveResult("同意（绑定）");
			} else if (p.getApproveResult().equals(BaseConstant.APPROVE_RESULT_N)) {
				p.setApproveResult("拒绝（解绑");
			} else {
				p.setApproveResult("待定（未绑）");
			}*/
			/**
			 * 获取流水信息
			 */
			Request<String> re = new Request<String>();
			re.setData(applyCode);
			Response<ApiApplyShopResponse> res = applyShopApi.select(re);
			if (res.getCode().equals(BaseCode.SUCCESS.getCode())) {
				p.setBossName(res.getData().getBossName());
				p.setShopName(res.getData().getShopName());
			}else {
				logger.error(MarketBaseCode.APP_USER_APPLY_SHOP_ERROR.getMessage());
			}
			/**
			 * 指派或转交人的上级
			 */
			if(StringUtils.isNotBlank(en.getTransactParentUser())) {
				ApproveApplyTransactEntity m = approveApplyTransactEntityMapper.selectApplyTransactByTransactCode(en.getTransactParentUser());
				ApproveSecurityUser transactParentUser = approveSecurityUserMapper.selectUserByUserCode(m.getTransactUser());
				if(m.getTransactType().equals(BaseConstant.TRANSACT_STATUS_Y)) {
					/**
					 * 指派
					 */
					p.setAssignUser("指派人->"+transactParentUser.getUserName());
				}else {
					p.setAssignUser("转交人=>"+transactParentUser.getUserName());
				}
				p.setAssignUerDate(m.getCreateTime());
			}
			
			/**
			 * 接受人
			 */
			ApproveSecurityUser transactAcceptorUser = approveSecurityUserMapper.selectUserByUserCode(en.getTransactAcceptor());
			if(en.getTransactType().equals(BaseConstant.TRANSACT_STATUS_Y)) {
				/**
				 * 指派
				 */
				p.setTransactUser("指派给->"+transactAcceptorUser.getUserName());
			}else {
				p.setTransactUser("转交给=>"+transactAcceptorUser.getUserName());
			}
			p.setNodeIndex(getNodeIndexByNodeCode(en.getNodeCode()));
			p.setName(approveFlowNodeEntityMapper.selectApplyFlowNodeByNodeCode(en.getNodeCode()).getNodeName());
			p.setApproveStartTime(en.getCreateTime());
			p.setFlowNodeResult(en.getTransactComment());
			response.add(p);
		}
		result.setRows(response);
		result.setTotal(total);
		return result;
	}
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月19日 上午10:14:17
	 * @Title: getNodeIndexByNodeCode 
	 * @Description:  通过节点编号，查询节点序号 
	 * @param nodeCode 节点编号
	 * @return
	 *
	 */
	private int getNodeIndexByNodeCode(String nodeCode) {
		int index =0;
		if (nodeCode.equals(FlowNodeConstant.ACCEPTAPPLICATION)) {
			index = 2;
		} else if (nodeCode.equals(FlowNodeConstant.CALL_BACK)) {
			/**
			 * 电话回访
			 */
			index = 3;
		} else if (nodeCode.equals(FlowNodeConstant.PRE_LOAN_REVIEW)) {
			/**
			 * 贷前审核
			 */
			index = 4;
		} else if (nodeCode.equals(FlowNodeConstant.CLOSE_TO_THE_DOOR)) {
			/**
			 * 上门尽调
			 */
			index = 5;
		} else if (nodeCode.equals(FlowNodeConstant.MATERIAL_APPROVAL)) {
			/**
			 * 材料审批
			 */
			index = 6;
		} else if (nodeCode.equals(FlowNodeConstant.BOTH_PARTIES_SIGNED_A_CONTRACT)) {
			/**
			 * 双方签约
			 */
			index = 7;
		} else if (nodeCode.equals(FlowNodeConstant.FUNDS_APPROPRIATION)) {
			/**
			 * 资金拨款
			 */
			index = 8;
		}
		return index;
	}
}
