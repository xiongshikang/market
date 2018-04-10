/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.service.saler.service.impl;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.activiti.engine.HistoryService;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.history.HistoricVariableInstance;
import org.activiti.engine.impl.identity.Authentication;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;
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
import cn.guludai.framework.toolkit.id.GUID;
import cn.guludai.market.common.constants.BaseConstant;
import cn.guludai.market.common.constants.FlowNodeConstant;
import cn.guludai.market.common.model.ResultModel;
import cn.guludai.market.domain.dao.ApproveApplyResultEntityMapper;
import cn.guludai.market.domain.dao.ApproveApplyTransactEntityMapper;
import cn.guludai.market.domain.dao.ApproveSecurityUserMapper;
import cn.guludai.market.domain.entity.ApproveApplyResultEntity;
import cn.guludai.market.domain.entity.ApproveApplyTransactEntity;
import cn.guludai.market.domain.entity.ApproveSecurityUser;
import cn.guludai.market.service.saler.service.ApproveApplyCommentService;
import cn.guludai.market.service.saler.service.ApproveApplyRecordService;
import cn.guludai.market.service.saler.service.ApproveApplyResultService;
import cn.guludai.market.service.saler.service.WorkflowTraceService;
import cn.guludai.market.web.code.MarketBaseCode;
import cn.guludai.market.web.request.ApproveApplyCommentReq;
import cn.guludai.market.web.request.ApproveApplyResultReq;
import cn.guludai.market.web.response.ApproveApplyResultResponse;
import cn.guludai.market.web.response.TableResponse;

/**
 * 
 * @ClassName: WorkflowTraceService 
 * @Description: activity5帮助类
 * @author: xiongshikang
 * @date: 2017年12月1日 上午9:56:13
 */
@Service
public class WorkflowTraceServiceImpl implements WorkflowTraceService {
	
	private static final Logger logger = LoggerFactory.getLogger(WorkflowTraceServiceImpl.class);
	
	@Autowired
	private RepositoryService repositoryService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private ApproveSecurityUserMapper approveSecurityUserMapper;
	@Autowired
	private ApproveApplyResultEntityMapper approveApplyResultEntityMapper;
	@Autowired
	private ApproveApplyRecordService approveApplyRecordEntityService;
	@Autowired
	private ApproveApplyResultService approveApplyResultService;
	@Autowired
	private RuntimeService runtimeService;
	@Autowired
	private HistoryService historyService;
	@Autowired
	private ApplyShopApi applyShopApi;
	@Autowired
	private ApproveApplyTransactEntityMapper approveApplyTransactEntityMapper;
	@Autowired
	private ApproveApplyCommentService approveApplyCommentService;
	
	public void deploymentProcessDefinition() {
		repositoryService.createDeployment()// 创建一个部署对象
				.name("ApproveApplyResultEntityProcess")// 添加部署的名称
				.addClasspathResource("process/approveApplyResultEntity.bpmn")
				.addClasspathResource("process/approveApplyResultEntity.png").deploy();// 完成部署
	}
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月18日 下午4:15:50
	 * @Title: setAssignee 
	 * @Description: 将个人任务指派给其它人
	 * @param req
	 * @param userCode 转交人
	 * @throws Exception 
	 *
	 */
	public void setAssignee(ApproveApplyResultReq req,String userCode) throws Exception {
		 taskService.setAssignee(req.getId(),req.getTaskActionUserCode()); 
		 /**
		  * 存入办理或转交任务信息表
		  */
		 addApplyTransactEntity(req,userCode);
	}
	
	public ResultModel<String> receiveTask(String userCode, String applyCode) {
		ResultModel<String> result = new ResultModel<String>();
		ApproveApplyResultEntity model = approveApplyResultEntityMapper.selectApproveApplyResultByApplyCode(applyCode);
		if(!model.getActivitiCode().equals("NIL")) {
			/**
			 * 已领取过
			 */
			result.setCode(MarketBaseCode.PROCESSINSTANCE_IS_NOT_EMPTY.getCode());
			return result;
		}
		ApproveApplyResultEntity entity = new ApproveApplyResultEntity();
		/**
		 * 获取流程实例key
		 */
		String key = entity.getClass().getSimpleName();
		/**
		 * 从Session中获取当前任务的办理人，使用流程变量设置下一个任务的办理人 inputUser是流程变量的名称， 获取的办理人是流程变量的值
		 */
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("inputUser", userCode);// 表示惟一用户
		/**
		 * 使用正在执行对象表中的一个字段BUSINESS_KEY（Activiti提供的一个字段），让启动的流程（流程实例）关联业务
		 */
		String objCode = key + "." + applyCode;
		variables.put("objId", objCode);
		/**
		 * 使用流程定义的key，启动流程实例，同时设置流程变量，同时向正在执行的执行对象表中的字段BUSINESS_KEY添加业务数据，同时让流程关联业务
		 */
		ProcessInstance processInstance = runtimeService.startProcessInstanceByKey(key, objCode, variables);
		// 获取流程实例ID
		String processInstanceId = processInstance.getId();
		/**
		 * 写入流程实列id
		 */
		approveApplyResultService.updateActivitiCodeByApplyCode(applyCode, processInstanceId);
		result.setCode(BaseCode.SUCCESS.getCode());
		return result;
	}
	
	/**
	 * @author: xiongshikang
	 * @date: 2017年11月30日 下午2:15:57
	 * @Title: getBusinessKey
	 * @Description: 通过任务id,获取业物id
	 * @param taskId
	 * @return
	 */
	private String getBusinessKey(String taskId) {
		/**
		 * 使用任务ID，查询任务对象Task
		 */
		Task task = taskService.createTaskQuery()//
				.taskId(taskId)// 使用任务ID查询
				.singleResult();
		/**
		 * 使用任务对象Task获取流程实例ID
		 */
		String processInstanceId = task.getProcessInstanceId();
		/**
		 * 使用流程实例ID，查询正在执行的执行对象表，返回流程实例对象
		 */
		ProcessInstance pi = runtimeService.createProcessInstanceQuery()//
				.processInstanceId(processInstanceId)// 使用流程实例ID查询
				.singleResult();
		/**
		 * 使用流程实例对象获取BUSINESS_KEY
		 */
		String buniness_key = pi.getBusinessKey();
		/**
		 * 获取BUSINESS_KEY对应的主键ID，使用主键ID，查询请假单对象
		 */
		String code = "";
		if (StringUtils.isNotBlank(buniness_key)) {
			// 截取字符串，取buniness_key小数点的第2个值
			code = buniness_key.split("\\.")[1];
		}
		return code;
	}
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月30日 下午1:09:40
	 * @Title: findTaskListByUserCode 
	 * @Description: 获取当前登录管理员的任务列表
	 * @return
	 * @throws InvocationTargetException 
	 * @throws IllegalAccessException 
	 *
	 */
	public TableResponse<ApproveApplyResultResponse> findTaskListByUserCode(Request<ApproveApplyResultReq> request,String userCode) throws Exception{
		TableResponse<ApproveApplyResultResponse> table = new TableResponse<ApproveApplyResultResponse>();
		List<ApproveApplyResultResponse> resultLs = new ArrayList<ApproveApplyResultResponse>();
		ApproveApplyResultReq req = request.getData() ; 
		List<Task> list = taskService.createTaskQuery()//
					.taskAssignee(userCode)//指定个人任务查询
					.orderByTaskCreateTime().desc()//
					.listPage(req.getOffset(), req.getLimit());
		Long count = taskService.createTaskQuery()//
				.taskAssignee(userCode)
				.count();
		
		for (Task t : list) {
			ApproveApplyResultResponse p = new ApproveApplyResultResponse();
			/**
			 * 通过任务id，获取业务code
			 */
			String applyCode =  getBusinessKey(t.getId());
			ApproveApplyResultEntity entity = approveApplyResultEntityMapper.selectApproveApplyResultByApplyCode(applyCode);
			BeanUtils.copyProperties(p, entity);
			if (p.getDataStatus().equals(BaseConstant.DATA_STATUS_Y)) {
				p.setDataStatus("正常");
			} else {
				p.setDataStatus("物理册除");
			}
			if (p.getDiskStatus().equals(BaseConstant.DISK_STATUS_Y)) {
				p.setDiskStatus("正常");
			} else {
				p.setDiskStatus("逻辑册除");
			}
			if (p.getApproveStatus().equals(BaseConstant.APPROVE_STATUS_Y)) {
				p.setApproveStatus("已审批");
			} else if (p.getApproveStatus().equals(BaseConstant.APPROVE_STATUS_N)) {
				p.setApproveStatus("未审批");
			} else {
				p.setApproveStatus("审批中");
			}
			if (p.getApproveResult().equals(BaseConstant.APPROVE_RESULT_Y)) {
				p.setApproveResult("同意（绑定）");
			} else if (p.getApproveResult().equals(BaseConstant.APPROVE_RESULT_N)) {
				p.setApproveResult("拒绝（解绑");
			} else {
				p.setApproveResult("待定（未绑）");
			}
			p.setId(t.getId());
			p.setName(t.getName());
			/**
			 * 获取流水信息
			 */
			Request<String> re = new Request<String>();
			re.setData(applyCode);
			Response<ApiApplyShopResponse> response = applyShopApi.select(re);
			if (response.getCode().equals(BaseCode.SUCCESS.getCode())) {
				p.setBossName(response.getData().getBossName());
				p.setShopName(response.getData().getShopName());
			}else {
				logger.error(MarketBaseCode.APP_USER_APPLY_SHOP_ERROR.getMessage());
			}
			 
			/**
			 * activity流程id
			 */
			String activitiCode = t.getProcessInstanceId();
			ApproveApplyTransactEntity model = approveApplyTransactEntityMapper.selectApplyTransactByActivitiCodeOne(activitiCode);
			if(null!=model) {
				ApproveSecurityUser userModel = approveSecurityUserMapper.selectUserByUserCode(model.getTransactUser());
				if(model.getTransactType().equals(BaseConstant.TRANSACT_STATUS_Y)) {
					/**
					 * 指派
					 */
					p.setAssignUser("指派人->"+userModel.getUserName());
				}else {
					p.setAssignUser("转交人=>"+userModel.getUserName());
				}
				p.setFlowNodeResult(model.getTransactComment());
				p.setTransactUser(model.getTransactCode());
				p.setCreateTime(model.getCreateTime());
			}
			/**
			 * 流程序号
			 */
			p.setNodeIndex(getNodeIndexByTaskId(t.getId()));
			resultLs.add(p);
		}
		table.setRows(resultLs);
		table.setTotal(count);
		return  table;
	}
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月30日 下午3:43:36
	 * @Title: saveSubmitTask 
	 * @Description: 开启流程实例
	 * @param request 
	 * @param userCode 当前登录的管理员code
	 * @param taskActionUserCode 指定办理人
	 * @return
	 *
	 */
	public String saveSubmitTask(ApproveApplyResultReq req,boolean bl, String userCode) {
		BaseConstant.ASSIGNEE_ = req.getTaskActionUserCode();
		// 获取任务ID
		String taskId = req.getId();
		// 批注信息
		String message = req.getFlowNodeResult();
	 
		/**
		 * 1：在完成之前，添加一个批注信息，向act_hi_comment表中添加数据，用于记录对当前申请人的一些审核信息
		 * 使用任务ID，查询任务对象，获取流程流程实例ID
		 */
		Task task = taskService.createTaskQuery()//
				.taskId(taskId)// 使用任务ID查询
				.singleResult();
		// 获取流程实例ID
		String processInstanceId = task.getProcessInstanceId();
		/**
		 * 注意：添加批注的时候，由于Activiti底层代码是使用： String userId = Authentication.getAuthenticatedUserId();
		 * CommentEntity comment = new CommentEntity(); comment.setUserId(userId);
		 * 所有需要从Session中获取当前登录人，作为该任务的办理人（审核人），对应act_hi_comment表中的User_ID的字段，不过不添加审核人，该字段为null
		 * 所以要求，添加配置执行使用Authentication.setAuthenticatedUserId();添加当前任务的审核人
		 */
		Authentication.setAuthenticatedUserId(userCode);
		/**
		 * 办理任务
		 */
		taskService.addComment(taskId, processInstanceId, message);
		Map<String, Object> variables = new HashMap<String, Object>();
		variables.put("action", bl);
		/**
		 * 使用任务ID，完成当前人的个人任务，同时流程变量
		 */
		taskService.complete(taskId, variables);
		// 当任务完成之后，需要指定下一个任务的办理人（使用类）-----已经开发完成
		
		/**
		 * 在完成任务之后，判断流程是否结束 如果流程结束了,修改审批信息状态
		 */
		ProcessInstance pi = runtimeService.createProcessInstanceQuery()//
				.processInstanceId(processInstanceId)// 使用流程实例ID查询
				.singleResult();
		if (pi == null) {
			if(bl==false) {
				/**
				 * 拒绝 ,修改申请审批信息为，N-拒绝（解绑）、Y-已审批
				 */
				approveApplyRecordEntityService.updateApplyShop(req.getApplyCode(), BaseConstant.APPROVE_RESULT_N, BaseConstant.APPROVE_STATUS_Y);
			}else {
				/**
				 * 同意
				 */
				
			}
			
		}
		return processInstanceId;
	}
  
	@Override
	public List<Comment> findCommentByApplyCode(String applyCode) {
		//使用请假单ID，查询请假单对象
		ApproveApplyResultEntity entity = approveApplyResultEntityMapper.selectApproveApplyResultByApplyCode(applyCode);
		//获取对象的名称
		String objectName = entity.getClass().getSimpleName();
		//组织流程表中的字段中的值
		String objId = objectName+"."+applyCode;
 
		/**2:使用历史的流程变量查询，返回历史的流程变量的对象，获取流程实例ID*/
		HistoricVariableInstance hvi = historyService.createHistoricVariableInstanceQuery()//对应历史的流程变量表
						.variableValueEquals("objId", objId)//使用流程变量的名称和流程变量的值查询
						.singleResult();
		//流程实例ID
		String processInstanceId = hvi.getProcessInstanceId();
		List<Comment> list = taskService.getProcessInstanceComments(processInstanceId);
		/**
		 * 按创建日期排序
		 */
		list.sort(new Comparator<Comment>() {
			@Override
			public int compare(Comment o1, Comment o2) {
				 int flag = o1.getTime().compareTo(o2.getTime());  
				return flag;
			}
		});
		return list;
	}
	
	 
	@Override
	public List<Comment> findCommentByTaskId(String taskId) {
		List<Comment> list = new ArrayList<Comment>();
		//使用当前的任务ID，查询当前流程对应的历史任务ID
		//使用当前任务ID，获取当前任务对象
		Task task = taskService.createTaskQuery()//
				.taskId(taskId)//使用任务ID查询
				.singleResult();
		//获取流程实例ID
		String processInstanceId = task.getProcessInstanceId();
		list = taskService.getProcessInstanceComments(processInstanceId);
		return list;
	}
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月3日 下午2:46:46
	 * @Title: getTaskById 
	 * @Description: 通过任务id,获取当前任务
	 * @param taskId
	 * @return
	 *
	 */
	public Task getTaskById(String taskId) {
		Task task = taskService.createTaskQuery()//
				.taskId(taskId)// 使用任务ID查询
				.singleResult();
		return task;
	}
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月18日 下午4:07:16
	 * @Title: getNodeCodeByTaskId 
	 * @Description: 通过任务id获取任务节点id
	 * @param id 任务id
	 * @return
	 *
	 */
	public String getNodeCodeByTaskId(String id) {
		Task task = getTaskById(id);
		String nodeName = task.getName();
		String nodeCode = "";
		if (nodeName.equals(FlowNodeConstant.ACCEPTAPPLICATION_NAME)) {
			nodeCode = FlowNodeConstant.ACCEPTAPPLICATION;
		} else if (nodeName.equals(FlowNodeConstant.CALL_BACK_NAME)) {
			/**
			 * 电话回访
			 */
			nodeCode = FlowNodeConstant.CALL_BACK;
		} else if (nodeName.equals(FlowNodeConstant.PRE_LOAN_REVIEW_NAME)) {
			/**
			 * 贷前审核
			 */
			nodeCode = FlowNodeConstant.PRE_LOAN_REVIEW;
		} else if (nodeName.equals(FlowNodeConstant.CLOSE_TO_THE_DOOR_NAME)) {
			/**
			 * 上门尽调
			 */
			nodeCode = FlowNodeConstant.CLOSE_TO_THE_DOOR;
		} else if (nodeName.equals(FlowNodeConstant.MATERIAL_APPROVAL_NAME)) {
			/**
			 * 材料审批
			 */
			nodeCode = FlowNodeConstant.MATERIAL_APPROVAL;
		} else if (nodeName.equals(FlowNodeConstant.BOTH_PARTIES_SIGNED_A_CONTRACT_NAME)) {
			/**
			 * 双方签约
			 */
			nodeCode = FlowNodeConstant.BOTH_PARTIES_SIGNED_A_CONTRACT;
		} else if (nodeName.equals(FlowNodeConstant.FUNDS_APPROPRIATION_NAME)) {
			/**
			 * 资金拨款
			 */
			nodeCode = FlowNodeConstant.FUNDS_APPROPRIATION;
		}
		return nodeCode;
	}
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月18日 上午10:21:52
	 * @Title: addApplyTransactEntity 
	 * @Description: 添加办理或转交任务关联信息
	 * @param req
	 * @param userCode
	 *
	 */
	private void addApplyTransactEntity(ApproveApplyResultReq req,String userCode) {
		String nodeCode = getNodeCodeByTaskId(req.getId());
		ApproveApplyTransactEntity entity = new ApproveApplyTransactEntity();
		entity.setApplyCode(req.getApplyCode());
		entity.setTransactCode(GUID.randomGUID());
		entity.setFlowCode(req.getFlowCode());
		entity.setNodeCode(nodeCode);
		entity.setActivitiCode(req.getActivitiCode());
		entity.setTransactAcceptor(req.getTaskActionUserCode());
		entity.setTransactUser(userCode);
		entity.setTransactComment(req.getFlowNodeResult());
		entity.setTransactType(BaseConstant.TRANSACT_STATUS_N);
		entity.setCreateTime(new Date());
		entity.setUpdateTime(new Date());
		entity.setVersion(1L);
		entity.setDataStatus(BaseConstant.DATA_STATUS_Y);
		entity.setDiskStatus(BaseConstant.DISK_STATUS_Y);
		entity.setTransactParentUser(req.getTransactUser());
		approveApplyTransactEntityMapper.insert(entity);
	}
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月18日 下午4:07:16
	 * @Title: getNodeCodeByTaskId 
	 * @Description: 通过任务id获取任务节点序号
	 * @param id 任务id
	 * @return
	 *
	 */
	private int getNodeIndexByTaskId(String id) {
		Task task = getTaskById(id);
		String nodeName = task.getName();
		int index =0;
		if (nodeName.equals(FlowNodeConstant.ACCEPTAPPLICATION_NAME)) {
			index = 2;
		} else if (nodeName.equals(FlowNodeConstant.CALL_BACK_NAME)) {
			/**
			 * 电话回访
			 */
			index = 3;
		} else if (nodeName.equals(FlowNodeConstant.PRE_LOAN_REVIEW_NAME)) {
			/**
			 * 贷前审核
			 */
			index = 4;
		} else if (nodeName.equals(FlowNodeConstant.CLOSE_TO_THE_DOOR_NAME)) {
			/**
			 * 上门尽调
			 */
			index = 5;
		} else if (nodeName.equals(FlowNodeConstant.MATERIAL_APPROVAL_NAME)) {
			/**
			 * 材料审批
			 */
			index = 6;
		} else if (nodeName.equals(FlowNodeConstant.BOTH_PARTIES_SIGNED_A_CONTRACT_NAME)) {
			/**
			 * 双方签约
			 */
			index = 7;
		} else if (nodeName.equals(FlowNodeConstant.FUNDS_APPROPRIATION_NAME)) {
			/**
			 * 资金拨款
			 */
			index = 8;
		}
		return index;
	}
	
}
