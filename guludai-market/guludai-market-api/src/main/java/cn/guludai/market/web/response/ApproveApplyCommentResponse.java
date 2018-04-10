/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.response;

import java.util.Date;

/**
 * 
 * @ClassName: ApproveApplyCommentResponse 
 * @Description:流程节点注备展示类
 * @author: xiongshikang
 * @date: 2018年1月16日 下午2:52:12
 */
public class ApproveApplyCommentResponse {
 

	 

	/**
	 * <pre>
	 * 备注人
	 * 表字段 : approve_apply_comment.user_code
	 * </pre>
	 */
	private String userCode;

	/**
	 * <pre>
	 * Activiti流程编号
	 * 表字段 : approve_apply_comment.activiti_code
	 * </pre>
	 */
	private String activitiCode;

	/**
	 * <pre>
	 * 申请流水编号
	 * 表字段 : approve_apply_comment.apply_code
	 * </pre>
	 */
	private String applyCode;

	/**
	 * <pre>
	 * 流程编号
	 * 表字段 : approve_apply_comment.flow_code
	 * </pre>
	 */
	private String flowCode;

	/**
	 * <pre>
	 * 进度节点编号
	 * 表字段 : approve_apply_comment.node_code
	 * </pre>
	 */
	private String nodeCode;
  
	/**
	 * <pre>
	 * 创建时间
	 * 表字段 : approve_apply_comment.create_time
	 * </pre>
	 */
	private Date createTime;

	/**
	 * <pre>
	 * 备注信息
	 * 表字段 : approve_apply_comment.comment
	 * </pre>
	 */
	private String comment;
 
	/**
	 * <pre>
	 * 获取：备注人
	 * 表字段：approve_apply_comment.user_code
	 * </pre>
	 * 
	 * @return 备注人 : {@link java.lang.String}
	 */
	public String getUserCode() {
		return userCode;
	}

	/**
	 * <pre>
	 * 设置：备注人
	 * 表字段：approve_apply_comment.user_code
	 * </pre>
	 * 
	 * @param userCode
	 *              备注人 : {@link java.lang.String}
	 */
	public void setUserCode(String userCode) {
		this.userCode = userCode == null ? null : userCode.trim();
	}

	/**
	 * <pre>
	 * 获取：Activiti流程编号
	 * 表字段：approve_apply_comment.activiti_code
	 * </pre>
	 * 
	 * @return Activiti流程编号 : {@link java.lang.String}
	 */
	public String getActivitiCode() {
		return activitiCode;
	}

	/**
	 * <pre>
	 * 设置：Activiti流程编号
	 * 表字段：approve_apply_comment.activiti_code
	 * </pre>
	 * 
	 * @param activitiCode
	 *              Activiti流程编号 : {@link java.lang.String}
	 */
	public void setActivitiCode(String activitiCode) {
		this.activitiCode = activitiCode == null ? null : activitiCode.trim();
	}

	/**
	 * <pre>
	 * 获取：申请流水编号
	 * 表字段：approve_apply_comment.apply_code
	 * </pre>
	 * 
	 * @return 申请流水编号 : {@link java.lang.String}
	 */
	public String getApplyCode() {
		return applyCode;
	}

	/**
	 * <pre>
	 * 设置：申请流水编号
	 * 表字段：approve_apply_comment.apply_code
	 * </pre>
	 * 
	 * @param applyCode
	 *              申请流水编号 : {@link java.lang.String}
	 */
	public void setApplyCode(String applyCode) {
		this.applyCode = applyCode == null ? null : applyCode.trim();
	}

	/**
	 * <pre>
	 * 获取：流程编号
	 * 表字段：approve_apply_comment.flow_code
	 * </pre>
	 * 
	 * @return 流程编号 : {@link java.lang.String}
	 */
	public String getFlowCode() {
		return flowCode;
	}

	/**
	 * <pre>
	 * 设置：流程编号
	 * 表字段：approve_apply_comment.flow_code
	 * </pre>
	 * 
	 * @param flowCode
	 *              流程编号 : {@link java.lang.String}
	 */
	public void setFlowCode(String flowCode) {
		this.flowCode = flowCode == null ? null : flowCode.trim();
	}

	/**
	 * <pre>
	 * 获取：进度节点编号
	 * 表字段：approve_apply_comment.node_code
	 * </pre>
	 * 
	 * @return 进度节点编号 : {@link java.lang.String}
	 */
	public String getNodeCode() {
		return nodeCode;
	}

	/**
	 * <pre>
	 * 设置：进度节点编号
	 * 表字段：approve_apply_comment.node_code
	 * </pre>
	 * 
	 * @param nodeCode
	 *              进度节点编号 : {@link java.lang.String}
	 */
	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode == null ? null : nodeCode.trim();
	}

	/**
	 * <pre>
	 * 获取：创建时间
	 * 表字段：approve_apply_comment.create_time
	 * </pre>
	 * 
	 * @return 创建时间 : {@link java.util.Date}
	 */
	public Date getCreateTime() {
		return createTime;
	}

	/**
	 * <pre>
	 * 设置：创建时间
	 * 表字段：approve_apply_comment.create_time
	 * </pre>
	 * 
	 * @param createTime
	 *              创建时间 : {@link java.util.Date}
	 */
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	/**
	 * <pre>
	 * 获取：备注信息
	 * 表字段：approve_apply_comment.comment
	 * </pre>
	 * 
	 * @return 备注信息 : {@link java.lang.String}
	 */
	public String getComment() {
		return comment;
	}

	/**
	 * <pre>
	 * 设置：备注信息
	 * 表字段：approve_apply_comment.comment
	 * </pre>
	 * 
	 * @param comment
	 *              备注信息 : {@link java.lang.String}
	 */
	public void setComment(String comment) {
		this.comment = comment == null ? null : comment.trim();
	}
}