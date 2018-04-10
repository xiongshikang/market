/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.service.saler.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.guludai.framework.toolkit.id.GUID;
import cn.guludai.market.common.constants.BaseConstant;
import cn.guludai.market.domain.dao.ApproveApplyCommentEntityMapper;
import cn.guludai.market.domain.dao.ApproveFlowNodeEntityMapper;
import cn.guludai.market.domain.dao.ApproveSecurityUserMapper;
import cn.guludai.market.domain.entity.ApproveApplyCommentEntity;
import cn.guludai.market.service.saler.service.ApproveApplyCommentService;
import cn.guludai.market.service.saler.service.WorkflowTraceService;
import cn.guludai.market.web.request.ApproveApplyCommentReq;
import cn.guludai.market.web.response.ApproveApplyCommentResponse;

@Service
public class ApproveApplyCommentServiceImpl implements ApproveApplyCommentService{

	@Autowired
	private  ApproveApplyCommentEntityMapper approveApplyCommentEntityMapper;
	
	@Autowired
	private WorkflowTraceService workflowTraceService;
	
	@Autowired
	private ApproveSecurityUserMapper approveSecurityUserMapper;
	
	@Autowired
	private ApproveFlowNodeEntityMapper approveFlowNodeEntityMapper;
	
	@Override
	public void addApproveApplyCommentEntity(ApproveApplyCommentReq recond) throws Exception {
		String nodeCode = workflowTraceService.getNodeCodeByTaskId(recond.getId());
		ApproveApplyCommentEntity entity = new ApproveApplyCommentEntity();
		BeanUtils.copyProperties(entity, recond);
		entity.setId(null);
		entity.setNodeCode(nodeCode);
		entity.setCommentCode(GUID.randomGUID());
		entity.setCreateTime(new Date());
		entity.setUpdateTime(new Date());
		entity.setVersion(1L);
		entity.setDataStatus(BaseConstant.DATA_STATUS_Y);
		entity.setDiskStatus(BaseConstant.DISK_STATUS_Y);
		approveApplyCommentEntityMapper.insert(entity);
	}

	@Override
	public List<ApproveApplyCommentResponse> list(String applyCode) throws Exception {
		List<ApproveApplyCommentResponse>  response = new ArrayList<ApproveApplyCommentResponse>();
		List<ApproveApplyCommentEntity> ls = approveApplyCommentEntityMapper.selectCommentsByApplyCode(applyCode);
		for (ApproveApplyCommentEntity entity : ls) {
			ApproveApplyCommentResponse model = new ApproveApplyCommentResponse();
			BeanUtils.copyProperties(model, entity);
			model.setUserCode(approveSecurityUserMapper.selectUserByUserCode(entity.getUserCode()).getUserName());
			model.setNodeCode(approveFlowNodeEntityMapper.selectApplyFlowNodeByNodeCode(entity.getNodeCode()).getNodeName());
			response.add(model);
		}
		return response;
	}
}
