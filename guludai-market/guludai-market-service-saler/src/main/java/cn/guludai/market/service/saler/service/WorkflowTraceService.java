/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.service.saler.service;

import java.util.List;

import org.activiti.engine.task.Comment;
import org.activiti.engine.task.Task;

import cn.guludai.api.data.Request;
import cn.guludai.market.common.model.ResultModel;
import cn.guludai.market.web.request.ApproveApplyResultReq;
import cn.guludai.market.web.response.ApproveApplyResultResponse;
import cn.guludai.market.web.response.TableResponse;

/**
 * 
 * @ClassName: WorkflowTraceService 
 * @Description: activity5服务接口
 * @author: xiongshikang
 * @date: 2017年12月1日 上午9:57:41
 */
public interface WorkflowTraceService {
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月29日 下午2:11:24
	 * @Title: deploymentProcessDefinition 
	 * @Description: 部署流程定义
	 *
	 */
	public void deploymentProcessDefinition();
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月18日 下午4:15:50
	 * @Title: setAssignee 
	 * @Description: 将个人任务指派给其它人
	 * @param req
	 * @param userCode 转交人
	 *
	 */
	public void setAssignee(ApproveApplyResultReq req,String userCode) throws Exception;
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月30日 下午1:03:04
	 * @Title: receiveTask 
	 * @Description: 启动流程实例
	 * @param userName
	 * @return
	 *
	 */
	public ResultModel<String> receiveTask(String userCode,String applyCode);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月30日 下午1:12:35
	 * @Title: findTaskListByUserCode 
	 * @Description: 通过用户编号查找当前用户任务列表
	 * @param userCode 用户编号
	 * @return
	 *
	 */
	public TableResponse<ApproveApplyResultResponse> findTaskListByUserCode(Request<ApproveApplyResultReq> request,String userCode)throws Exception;
	
 
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月30日 下午3:43:36
	 * @Title: saveSubmitTask 
	 * @Description: 持行个人任务
	 * @param request 
	 * @param userCode 当前登录的管理员code
	 * @param taskActionUserCode 指定办理人
	 * @return
	 *
	 */
	public String saveSubmitTask(ApproveApplyResultReq req,boolean bl, String userCode);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月3日 下午12:50:20
	 * @Title: findCommentByApplyCode 
	 * @Description: 通过流水号获取批注
	 * @param applyCode
	 * @return
	 *
	 */
	public List<Comment> findCommentByApplyCode(String applyCode);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月3日 下午12:51:46
	 * @Title: findCommentByTaskId 
	 * @Description: 通过任务id,获取批注信息
	 * @param taskId 任务id
	 * @return
	 *
	 */
	public List<Comment> findCommentByTaskId(String taskId);
	
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
	public Task getTaskById(String taskId);
	
	
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
	public String getNodeCodeByTaskId(String id);
	
}
