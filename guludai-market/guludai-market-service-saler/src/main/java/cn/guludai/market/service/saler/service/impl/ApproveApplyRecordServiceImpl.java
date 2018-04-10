/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.service.saler.service.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.guludai.api.code.BaseCode;
import cn.guludai.api.data.Request;
import cn.guludai.app.api.ApplyShopApi;
import cn.guludai.app.web.request.ApplyShopRequest;
import cn.guludai.market.api.saler.code.SalerCode;
import cn.guludai.market.api.saler.request.SalerRequest;
import cn.guludai.market.api.saler.response.FlowNodeModel;
import cn.guludai.market.common.constants.BaseConstant;
import cn.guludai.market.common.model.ResultModel;
import cn.guludai.market.common.util.DateUtils;
import cn.guludai.market.common.util.MySortList;
import cn.guludai.market.domain.dao.ApproveApplyRecordEntityMapper;
import cn.guludai.market.domain.dao.ApproveFlowNodeEntityMapper;
import cn.guludai.market.domain.dao.ApproveSecurityUserMapper;
import cn.guludai.market.domain.entity.ApproveApplyRecordEntity;
import cn.guludai.market.domain.entity.ApproveFlowNodeEntity;
import cn.guludai.market.domain.entity.ApproveSecurityUser;
import cn.guludai.market.service.saler.service.ApproveApplyCommentService;
import cn.guludai.market.service.saler.service.ApproveApplyRecordService;
import cn.guludai.market.web.response.ApproveApplyCommentResponse;
/**
 * 
 * @ClassName: ApproveApplyRecordServiceImpl 
 * @Description: 流程节点记录服务类
 * @author: xiongshikang
 * @date: 2017年12月1日 上午10:23:46
 */
@Service
public class ApproveApplyRecordServiceImpl implements ApproveApplyRecordService{
	
	private static final Logger logger = LoggerFactory.getLogger(ApproveApplyRecordServiceImpl.class);
	
	@Autowired
	private ApproveApplyRecordEntityMapper approveApplyRecordEntityMapper;
	@Autowired
	private ApproveFlowNodeEntityMapper approveFlowNodeEntityMapper;
	@Autowired
	private ApplyShopApi applyShopApi;
	@Autowired
	private ApproveSecurityUserMapper approveSecurityUserMapper;
	@Autowired
	private ApproveApplyCommentService approveApplyCommentService;
	@Transactional
	public void add(ApproveApplyRecordEntity record) {
		record.setCreateTime(new Date());
		record.setUpdateTime(new Date());
		record.setVersion(1L);
		record.setDataStatus(BaseConstant.DATA_STATUS_Y);
		record.setDiskStatus(BaseConstant.DISK_STATUS_Y);
		approveApplyRecordEntityMapper.insert(record);
	}
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月30日 下午3:20:40
	 * @Title: updateApproveApplyRecordEntity 
	 * @Description: 添加进度节点
	 * @param flowNodeStatus 流程进度审批状态
	 * @param flowNodeResult 流程进度审批结果备注
	 * @param flowCode 流程编号
	 * @param applyCode 申请流水编号
	 * @param pid Activiti流程编号
	 * @param nodeCode 进度节点编号
	 * @param userCode 用户编号
	 */
	public void addApproveApplyRecordEntity(String flowNodeStatus,String flowNodeResult,
			String flowCode,String applyCode,String pid,String nodeCode,String userCode) {
		/**
		 * 添加申请审批进度记录
		 */
		ApproveApplyRecordEntity record = new ApproveApplyRecordEntity();
		/**
		 * 流程进度审批状态 同意
		 */
		record.setFlowNodeStatus(flowNodeStatus);
		record.setFlowNodeResult(flowNodeResult);
		/**
		 * 接受申请(插入审批进度记录)
		 */
		record.setNodeCode(nodeCode);
		record.setFlowCode(flowCode);
		record.setApplyCode(applyCode);
		record.setActivitiCode(pid);
		record.setUserCode(userCode);
		add(record);
	}
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月1日 下午1:51:13
	 * @Title: updateApplyShop 
	 * @Description: 
	 * @param applyCode 流水号
	 * @param approveResult 审批结果
	 * @param approveStatus 审批状态
	 *
	 */
	public void updateApplyShop(String applyCode,String approveResult,String approveStatus) {
		Request<ApplyShopRequest> request = new Request<ApplyShopRequest>();
		ApplyShopRequest applyShopReq = new ApplyShopRequest();
		applyShopReq.setApplyCode(applyCode);
		applyShopReq.setApproveResult(approveResult);
		applyShopReq.setApproveStatus(approveStatus);
		request.setData(applyShopReq);
		try {
			applyShopApi.updateApplyShopByKey(request);
			}catch(Exception e){
				logger.error("远程调用applyShopApi.updateApplyShopByKey错误", e.getMessage(), e);
			}
	}
	
	
	public ResultModel<FlowNodeModel> queryFlowListByApplycodeForBS(Request<SalerRequest> request) throws Exception {
		ResultModel<FlowNodeModel> result = new  ResultModel<FlowNodeModel> ();
		String applyCode=request.getData().getApplyCode();
		if(StringUtils.isBlank(applyCode)) {
			/**
			 * 流水号参数错误
			 */
			
			logger.error("[********"+SalerCode.APPLY_CODE_EMPTY.getMessage()+"*******]");
			result.setCode(SalerCode.APPLY_CODE_EMPTY.getCode());
			return result;
		}
		/**
		 * 获取任务批注
		 */
		List<ApproveApplyRecordEntity> recordLs = approveApplyRecordEntityMapper.selectApproveApplyRecordByApplyCode(applyCode);
		if(null==recordLs || recordLs.size()==0) {
			/**
			 * 没有流水数据
			 */
			logger.error("[********没有一条申请审批进度记录*******]");
			result.setCode(SalerCode.DATA_EMPTY.getCode());
			return result;
		}
		List<FlowNodeModel> flowNodeModels = new ArrayList<FlowNodeModel>();
		/**
		 * 展示批注到页面类体类
		 */
		for (int i = 0;i <recordLs.size();i++) { 
			ApproveApplyRecordEntity a = recordLs.get(i);
			FlowNodeModel m = new FlowNodeModel();
			m.setApproveTime( DateUtils.changeDateToStringTodd(a.getUpdateTime()));
			m.setFlowNodeStatus(a.getFlowNodeStatus());
			m.setNodeName(approveFlowNodeEntityMapper.selectApplyFlowNodeByNodeCode(a.getNodeCode()).getNodeName());
			m.setFlowNodeResult(a.getFlowNodeResult());
			if(!a.getUserCode().equals("NIL")) {
				ApproveSecurityUser user =approveSecurityUserMapper.selectUserByUserCode(a.getUserCode());
				m.setUserName(user.getUserName());
			}
			flowNodeModels.add(m);
		}
		/**
		 * 获取所有节点批注
		 */
		List<ApproveApplyCommentResponse> comments = approveApplyCommentService.list(applyCode);
		if(null!=comments && comments.size()>0) {
			for (ApproveApplyCommentResponse comment : comments) {
				FlowNodeModel m = new FlowNodeModel();
				m.setNodeName(comment.getNodeCode());
				m.setUserName(comment.getUserCode());
				m.setFlowNodeResult("<span style='color:#6864D4;'>"+comment.getComment()+"</span>");
				m.setFlowNodeStatus(BaseConstant.APPROVE_RESULT_O);
				m.setApproveTime(DateUtils.changeDateToStringTodd(comment.getCreateTime()));
				flowNodeModels.add(m);
			}
			/**
			 * 安日期排序输出完整的备注信息
			 */
			MySortList<FlowNodeModel> msList = new MySortList<FlowNodeModel>();
		    msList.sortByMethod(flowNodeModels, "getApproveTime", false);
		}
		result.setCode(BaseCode.SUCCESS.getCode());
		result.setLs(flowNodeModels);
		return result;
	}
 
}
