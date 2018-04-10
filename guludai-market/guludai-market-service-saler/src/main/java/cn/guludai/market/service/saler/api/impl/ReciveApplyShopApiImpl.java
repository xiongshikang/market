/**
 * 
 */
package cn.guludai.market.service.saler.api.impl;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.guludai.api.code.BaseCode;
import cn.guludai.api.data.Request;
import cn.guludai.api.data.Response;
import cn.guludai.framework.toolkit.util.BeanUtil;
import cn.guludai.market.api.saler.code.SalerCode;
import cn.guludai.market.api.saler.request.SalerRequest;
import cn.guludai.market.api.saler.response.ApproveApplyLoanResp;
import cn.guludai.market.api.saler.response.ApproveApplyResultResp;
import cn.guludai.market.api.saler.response.FlowNodeModel;
import cn.guludai.market.api.saler.response.FlowNodeParentModel;
import cn.guludai.market.api.saler.response.SalerResponse;
import cn.guludai.market.common.constants.BaseConstant;
import cn.guludai.market.common.model.ResultModel;
import cn.guludai.market.common.util.DateUtils;
import cn.guludai.market.domain.dao.ApproveApplyCommentEntityMapper;
import cn.guludai.market.domain.dao.ApproveApplyCustomerEntityMapper;
import cn.guludai.market.domain.dao.ApproveApplyLoanEntityMapper;
import cn.guludai.market.domain.dao.ApproveApplyRecordEntityMapper;
import cn.guludai.market.domain.dao.ApproveApplyResultEntityMapper;
import cn.guludai.market.domain.dao.ApproveFlowNodeEntityMapper;
import cn.guludai.market.domain.entity.ApproveApplyCommentEntity;
import cn.guludai.market.domain.entity.ApproveApplyCustomerEntity;
import cn.guludai.market.domain.entity.ApproveApplyLoanEntity;
import cn.guludai.market.domain.entity.ApproveApplyRecordEntity;
import cn.guludai.market.domain.entity.ApproveApplyResultEntity;
import cn.guludai.market.domain.entity.ApproveFlowNodeEntity;
import cn.guludai.market.service.saler.api.ReciveApplyShopService;
@Service
public class ReciveApplyShopApiImpl implements ReciveApplyShopService {
	 private static final Logger logger = LoggerFactory.getLogger(ReciveApplyShopApiImpl.class);
	
	@Autowired
	private ApproveApplyResultEntityMapper approveApplyResultEntityMapper;
	
	@Autowired
	private ApproveFlowNodeEntityMapper approveFlowNodeEntityMapper;
	
	@Autowired
	private ApproveApplyRecordEntityMapper approveApplyRecordEntityMapper;
	
	@Autowired
	private ApproveApplyLoanEntityMapper approveApplyLoanEntityMapper;
	
	@Autowired
	private ApproveApplyCustomerEntityMapper approveApplyCustomerEntityMapper;
	
	@Autowired
	private ApproveApplyCommentEntityMapper approveApplyCommentEntityMapper;
	
	@Override
	public Response<SalerResponse> insertApplyShop(Request<SalerRequest> request) {
		
		
		
		// TODO Auto-generated method stub
		ApproveApplyResultEntity approveApplyResultEntity=new ApproveApplyResultEntity();

		SalerRequest salerRequest=request.getData();
		BeanUtil.copyProperties(salerRequest,approveApplyResultEntity);
		approveApplyResultEntity.setFlowCode("110");
		approveApplyResultEntity.setUpdateTime(new Date());
		approveApplyResultEntityMapper.insertSelective(approveApplyResultEntity);
		return Response.success(BaseCode.SUCCESS);
		
	}
	
	public ResultModel<FlowNodeParentModel> queryFlowListByApplycode(Request<SalerRequest> request) throws Exception {
		ResultModel<FlowNodeParentModel> result = new  ResultModel<FlowNodeParentModel> ();
		FlowNodeParentModel model = new FlowNodeParentModel();
		String applyCode=request.getData().getApplyCode();
		
		if(StringUtils.isBlank(applyCode)) {
			/**
			 * 流水号参数错误
			 */
			
			logger.error("[********"+SalerCode.APPLY_CODE_EMPTY.getMessage()+"*******]");
			result.setCode(SalerCode.APPLY_CODE_EMPTY.getCode());
			return result;
		}
		
		List<ApproveApplyRecordEntity> recordLs = approveApplyRecordEntityMapper.selectApproveApplyRecordByApplyCode(applyCode);
		if(null==recordLs || recordLs.size()==0) {
			/**
			 * 没有流水数据
			 */
			logger.error("[********没有一条申请审批进度记录*******]");
			result.setCode(SalerCode.DATA_EMPTY.getCode());
			return result;
		}
		
		List<ApproveFlowNodeEntity> list=approveFlowNodeEntityMapper.selectApproveFlowNodeByFlowCode(recordLs.get(0).getFlowCode());
		List<FlowNodeModel> flowNodeModels = new ArrayList<FlowNodeModel>();
		/**
		 * 合并两个集合，提取出需要的数据集返回给手机端
		 */
		for (ApproveFlowNodeEntity b : list) {
			boolean bl = true;
			for (int i = 0; i<recordLs.size();i++) {
				ApproveApplyRecordEntity a = recordLs.get(i);
				if(a.getNodeCode().equals(b.getNodeCode())) {
					FlowNodeModel m = new FlowNodeModel();
					m.setApproveTime( DateUtils.changeStringToDate(a.getUpdateTime()));
					m.setFlowNodeStatus(a.getFlowNodeStatus());
					m.setNodeName(b.getNodeName());
					m.setFlowNodeResult(a.getFlowNodeResult());
					//把最后节点的下标记录下来，给手机端提示最后了点
					if(recordLs.size()==(i+1)) {
						m.setIndexEnd(i);
					}
					flowNodeModels.add(m);
					 bl = false;
					break;
				}
			}
			if(bl==true) {
				FlowNodeModel m = new FlowNodeModel();
				m.setFlowNodeStatus("O");
				m.setNodeName(b.getNodeName());
				flowNodeModels.add(m);
			}
		}
		/**
		 * 是否拒绝 true为是 
		 */
		boolean bl = false;
		for (ApproveApplyRecordEntity entity : recordLs) {
			if(entity.getFlowNodeStatus().equals(BaseConstant.APPROVE_RESULT_N)) {
				bl = true;
				continue;
			}
		}
		/**
		 * 备注
		 */
		String remark= "";
		String nodeCode = "";
		if(recordLs.size()<list.size()) {
			/**
			 * 获取最新备注，在表approveApplyComment中存的备注数据为下一个nodecode节点上，所以要获取它下个nodecode的备注数据
			 */
			 nodeCode = list.get(recordLs.size()).getNodeCode();
		}else {
			/**
			 * 当完成全部流程，获取它的最后备注要做特殊处理，避免数据越界
			 */
			nodeCode = list.get(recordLs.size()-1).getNodeCode();
		}
		List<ApproveApplyCommentEntity> ls = approveApplyCommentEntityMapper.selectCommentByApplyCodeAndNodeCode(applyCode, nodeCode);
		if(bl==true) {
			/**
			 * 拒绝
			 */
			model.setStatus(BaseConstant.APPROVE_RESULT_N);
			if(null!=ls && ls.size()>0) {
				remark = ls.get(ls.size()-1).getComment();
				model.setRemark(remark);
				String time = DateUtils.changeDateToStringTodd(ls.get(ls.size()-1).getCreateTime());
				model.setApproveTime(time);
			}else {
				model.setApproveTime(DateUtils.changeDateToStringTodd(recordLs.get(recordLs.size()-1).getCreateTime()));
			}
		}else {
			model.setStatus(BaseConstant.APPROVE_RESULT_Y);
			if(null!=ls && ls.size()>0) {
				remark = ls.get(ls.size()-1).getComment();
				model.setRemark(remark);
				String time = DateUtils.changeDateToStringTodd(ls.get(ls.size()-1).getCreateTime());
				model.setApproveTime(time);
			}else {
			    model.setApproveTime(DateUtils.changeDateToStringTodd(recordLs.get(recordLs.size()-1).getCreateTime()));
			}
		}
		model.setLs(flowNodeModels);
		result.setCode(BaseCode.SUCCESS.getCode());
		result.setResult(model);
		return result;
	}
	
	@Override
	public ResultModel<ApproveApplyLoanResp> selectApplyLoanByApplyCode(String applyCode) {
		ResultModel<ApproveApplyLoanResp> result = new ResultModel<ApproveApplyLoanResp>();
		ApproveApplyLoanResp model = new ApproveApplyLoanResp();
		ApproveApplyLoanEntity entity = approveApplyLoanEntityMapper.selectApplyLoanApplyCode(applyCode);
		if(null!=entity) {
			BeanUtil.copyProperties(entity,model);
		}
		result.setCode(BaseCode.SUCCESS.getCode());
		result.setResult(model);
		return result;
	}
	
	@Override
	public ResultModel<ApproveApplyResultResp> selectApplyCustomerByCustomerIdcard(String customerIdcard) {
		ResultModel<ApproveApplyResultResp> result = new ResultModel<ApproveApplyResultResp>();
		List<ApproveApplyResultResp> arr = new ArrayList<>();
		List<ApproveApplyCustomerEntity> ls = approveApplyCustomerEntityMapper.selectApplyCustomerByCustomerIdcard(customerIdcard);
		if(null==ls || ls.size()==0) {
			result.setCode(BaseCode.SUCCESS.getCode());
			return result;
		}
		for (ApproveApplyCustomerEntity a : ls) {
			ApproveApplyResultResp model = new ApproveApplyResultResp();
			ApproveApplyResultEntity entity = approveApplyResultEntityMapper.selectApproveApplyResultByApplyCode(a.getApplyCode());
			BeanUtil.copyProperties(entity , model);
			arr.add(model);
		}
		result.setCode(BaseCode.SUCCESS.getCode());
		result.setLs(arr);
		return result;
	}

	@Override
	public ResultModel<FlowNodeModel> queryApplyRecordByApplyCode(Request<SalerRequest> request) {
		ResultModel<FlowNodeModel> result = new ResultModel<FlowNodeModel>();
		if (StringUtils.isBlank(request.getData().getApplyCode())){
			result.setCode(SalerCode.APPLY_CODE_EMPTY.getCode());
		}
		FlowNodeModel flowNodeModel =  approveApplyRecordEntityMapper.queryApplyRecordByApplyCode(request.getData().getApplyCode());
		result.setCode(BaseCode.SUCCESS.getCode());
		result.setResult(flowNodeModel);
		return result;
	}


}
