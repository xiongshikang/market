/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.service.saler.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.activiti.engine.task.Task;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.guludai.api.code.BaseCode;
import cn.guludai.framework.toolkit.id.GUID;
import cn.guludai.market.common.constants.BaseConstant;
import cn.guludai.market.common.constants.FlowNodeConstant;
import cn.guludai.market.common.model.ResultModel;
import cn.guludai.market.domain.dao.ApproveFlowNodeEntityMapper;
import cn.guludai.market.domain.dao.ApproveFlowUserEntityMapper;
import cn.guludai.market.domain.dao.ApproveSecurityUserMapper;
import cn.guludai.market.domain.entity.ApproveFlowNodeEntity;
import cn.guludai.market.domain.entity.ApproveFlowUserEntity;
import cn.guludai.market.domain.entity.ApproveSecurityUser;
import cn.guludai.market.service.saler.service.ApproveFlowNodeService;
import cn.guludai.market.service.saler.service.WorkflowTraceService;
import cn.guludai.market.web.request.ApproveFlowNodeReq;
import cn.guludai.market.web.response.ApproveFlowNodeResponse;
import cn.guludai.market.web.response.ApproveSecurityUserResponse;
import cn.guludai.market.web.response.TableResponse;
import cn.guludai.market.web.user.request.ZtreeRequest;
import cn.guludai.market.web.user.response.ZtreeResponse;

@Service
public class ApproveFlowNodeServiceImpl implements ApproveFlowNodeService{
	
	private static final String flowCode = "383207-509664-768000";
	
	@Autowired
	private ApproveFlowNodeEntityMapper approveFlowNodeEntityMapper;
	
	@Autowired
	private ApproveFlowUserEntityMapper approveFlowUserEntityMapper;
	
	@Autowired
	private ApproveSecurityUserMapper approveSecurityUserMapper;
	
	@Autowired
	private WorkflowTraceService workflowTraceService;
	 
	public TableResponse<ApproveFlowNodeResponse> seletFlowNodeByFlowCode(ApproveFlowNodeReq request) throws Exception{
		TableResponse<ApproveFlowNodeResponse> table = new TableResponse<ApproveFlowNodeResponse>();
		request.setFlowCode(flowCode);
		List<ApproveFlowNodeResponse> response = new ArrayList<ApproveFlowNodeResponse>();
		List<ApproveFlowNodeEntity> ls = approveFlowNodeEntityMapper.selectFlowNodeByFlowCode(request);
		Integer total = approveFlowNodeEntityMapper.selectFlowNodeByFlowCodeCount(request);
		for (ApproveFlowNodeEntity entity : ls) {
			ApproveFlowNodeResponse model = new ApproveFlowNodeResponse();
			BeanUtils.copyProperties(model, entity);
			response.add(model);
		}
		table.setRows(response);
		table.setTotal(total);
		return table;
	}
	
	
	@Override
	public ResultModel<ZtreeResponse> getzTreeForUserAndFlowNode(String nodeCode) {
		ResultModel<ZtreeResponse> result = new ResultModel<ZtreeResponse>();
		List<ApproveFlowUserEntity> flowUsers = approveFlowUserEntityMapper.selectFlowUserByNodeCode(nodeCode);
		List<ApproveSecurityUser> ls = approveSecurityUserMapper.selectAll();
		List<ZtreeResponse> reps = new ArrayList<ZtreeResponse>();
		for (ApproveSecurityUser a : ls) {
			boolean bl = true;
			for (ApproveFlowUserEntity r : flowUsers) {
				if(r.getUserCode().equals(a.getUserCode())) {
					/**
					 * 节点已有的人员,展示树节点为，选中状态
					 */
					ZtreeResponse rep = new ZtreeResponse();
					 rep.setId(a.getUserCode());
					 rep.setName(a.getUserName());
					 rep.setpId("-1");
					 rep.setChecked(true);
					 rep.setOpen(true);
					 reps.add(rep);
					 bl = false;
					 break;
				}
			}
			if(bl==true) {
				ZtreeResponse rep = new ZtreeResponse();
				rep.setId(a.getUserCode());
				 rep.setName(a.getUserName());
				 rep.setpId("-1");
				 rep.setChecked(false);
				 rep.setOpen(true);
				 reps.add(rep);
			}
		}
		result.setLs(reps);
		result.setCode(BaseCode.SUCCESS.getCode());
		return result;
	}
	
	
	@Override
	public ResultModel<String> setting(ZtreeRequest record) {
		ResultModel<String> result = new ResultModel<String>();
		String userCodes = record.getCodeStr();
		String nodeCode = record.getNodeCode();
		String[] users = userCodes.split(",");
		/**
		 * 在设置之前，先把之前的角色清空
		 */
		approveFlowUserEntityMapper.deleteFlowUserByNodeCode(nodeCode);
		/**
		 * 批量添加角色权限
		 */
		for (String s : users) {
			/**
			 * 是否存在
			 */
			int count = approveFlowUserEntityMapper.selectFlowUserByUserCodeAndNodeCode(s,nodeCode);
			if(count>0) {
				approveFlowUserEntityMapper.insertFlowUser(s,nodeCode);
			}else {
				ApproveFlowUserEntity entity = new ApproveFlowUserEntity();
				entity.setUserCode(s);
				entity.setNodeCode(nodeCode);
				entity.setFlowCode(flowCode);
				entity.setCode(GUID.randomGUID());
				entity.setCreateTime(new Date());
				entity.setUpdateTime(new Date());
				entity.setVersion(1L);
				entity.setDataStatus(BaseConstant.DATA_STATUS_Y);
				entity.setDiskStatus(BaseConstant.DISK_STATUS_Y);
				approveFlowUserEntityMapper.insert(entity);
			}
		}
		result.setCode(BaseCode.SUCCESS.getCode());
		return result;
	}


	@Override
	public ResultModel<ApproveSecurityUserResponse> selectUserByNodeCode(String id) throws Exception {
		/**
		 * 通过任务id获取节点编号
		 */
		String nodeCode = workflowTraceService.getNodeCodeByTaskId(id);
		ResultModel<ApproveSecurityUserResponse> result = new ResultModel<ApproveSecurityUserResponse>();
		List<ApproveSecurityUserResponse> response = new ArrayList<ApproveSecurityUserResponse>();
		/**
		 * 通过节点编号获取节点信息
		 */
		ApproveFlowNodeEntity m = approveFlowNodeEntityMapper.selectApplyFlowNodeByNodeParentCode(nodeCode);
		
		List<ApproveFlowUserEntity> ls = approveFlowUserEntityMapper.selectFlowUserByNodeCode(m.getNodeCode());
		for (ApproveFlowUserEntity entity : ls) {
			ApproveSecurityUserResponse p = new ApproveSecurityUserResponse();
			ApproveSecurityUser model = approveSecurityUserMapper.selectUserByUserCode(entity.getUserCode());
			BeanUtils.copyProperties(p, model);
			response.add(p);
		}
		result.setLs(response);
		result.setCode(BaseCode.SUCCESS.getCode());
		return result;
	}
	
}
