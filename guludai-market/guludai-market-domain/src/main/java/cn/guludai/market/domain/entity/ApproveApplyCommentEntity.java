/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.domain.entity;

import java.util.Date;

/**
 * @author gaopeng
 */
public class ApproveApplyCommentEntity {
	/**
	 * <pre>
	 * 主建
	 * 表字段 : approve_apply_comment.id
	 * </pre>
	 */
	private Long id;

	/**
	 * <pre>
	 * 备注编号
	 * 表字段 : approve_apply_comment.comment_code
	 * </pre>
	 */
	private String commentCode;

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
	 * 版本号(默认值：1，同步递增修改)
	 * 表字段 : approve_apply_comment.version
	 * </pre>
	 */
	private Long version;

	/**
	 * <pre>
	 * 创建时间
	 * 表字段 : approve_apply_comment.create_time
	 * </pre>
	 */
	private Date createTime;

	/**
	 * <pre>
	 * 更新时间
	 * 表字段 : approve_apply_comment.update_time
	 * </pre>
	 */
	private Date updateTime;

	/**
	 * <pre>
	 * 逻辑状态(常量值：Y-逻辑保留，N-逻辑删除，默认值：Y)
	 * 表字段 : approve_apply_comment.data_status
	 * </pre>
	 */
	private String dataStatus;

	/**
	 * <pre>
	 * 物理状态(常量值：Y-物理保留，N-物理删除，默认值：Y)
	 * 表字段 : approve_apply_comment.disk_status
	 * </pre>
	 */
	private String diskStatus;

	/**
	 * <pre>
	 * 备注信息
	 * 表字段 : approve_apply_comment.comment
	 * </pre>
	 */
	private String comment;

	/**
	 * <pre>
	 * 获取：主建
	 * 表字段：approve_apply_comment.id
	 * </pre>
	 * 
	 * @return 主建 : {@link java.lang.Long}
	 */
	public Long getId() {
		return id;
	}

	/**
	 * <pre>
	 * 设置：主建
	 * 表字段：approve_apply_comment.id
	 * </pre>
	 * 
	 * @param id
	 *              主建 : {@link java.lang.Long}
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * <pre>
	 * 获取：备注编号
	 * 表字段：approve_apply_comment.comment_code
	 * </pre>
	 * 
	 * @return 备注编号 : {@link java.lang.String}
	 */
	public String getCommentCode() {
		return commentCode;
	}

	/**
	 * <pre>
	 * 设置：备注编号
	 * 表字段：approve_apply_comment.comment_code
	 * </pre>
	 * 
	 * @param commentCode
	 *              备注编号 : {@link java.lang.String}
	 */
	public void setCommentCode(String commentCode) {
		this.commentCode = commentCode == null ? null : commentCode.trim();
	}

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
	 * 获取：版本号(默认值：1，同步递增修改)
	 * 表字段：approve_apply_comment.version
	 * </pre>
	 * 
	 * @return 版本号(默认值：1，同步递增修改) : {@link java.lang.Long}
	 */
	public Long getVersion() {
		return version;
	}

	/**
	 * <pre>
	 * 设置：版本号(默认值：1，同步递增修改)
	 * 表字段：approve_apply_comment.version
	 * </pre>
	 * 
	 * @param version
	 *              版本号(默认值：1，同步递增修改) : {@link java.lang.Long}
	 */
	public void setVersion(Long version) {
		this.version = version;
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
	 * 获取：更新时间
	 * 表字段：approve_apply_comment.update_time
	 * </pre>
	 * 
	 * @return 更新时间 : {@link java.util.Date}
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * <pre>
	 * 设置：更新时间
	 * 表字段：approve_apply_comment.update_time
	 * </pre>
	 * 
	 * @param updateTime
	 *              更新时间 : {@link java.util.Date}
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * <pre>
	 * 获取：逻辑状态(常量值：Y-逻辑保留，N-逻辑删除，默认值：Y)
	 * 表字段：approve_apply_comment.data_status
	 * </pre>
	 * 
	 * @return 逻辑状态(常量值：Y-逻辑保留，N-逻辑删除，默认值：Y) : {@link java.lang.String}
	 */
	public String getDataStatus() {
		return dataStatus;
	}

	/**
	 * <pre>
	 * 设置：逻辑状态(常量值：Y-逻辑保留，N-逻辑删除，默认值：Y)
	 * 表字段：approve_apply_comment.data_status
	 * </pre>
	 * 
	 * @param dataStatus
	 *              逻辑状态(常量值：Y-逻辑保留，N-逻辑删除，默认值：Y) : {@link java.lang.String}
	 */
	public void setDataStatus(String dataStatus) {
		this.dataStatus = dataStatus == null ? null : dataStatus.trim();
	}

	/**
	 * <pre>
	 * 获取：物理状态(常量值：Y-物理保留，N-物理删除，默认值：Y)
	 * 表字段：approve_apply_comment.disk_status
	 * </pre>
	 * 
	 * @return 物理状态(常量值：Y-物理保留，N-物理删除，默认值：Y) : {@link java.lang.String}
	 */
	public String getDiskStatus() {
		return diskStatus;
	}

	/**
	 * <pre>
	 * 设置：物理状态(常量值：Y-物理保留，N-物理删除，默认值：Y)
	 * 表字段：approve_apply_comment.disk_status
	 * </pre>
	 * 
	 * @param diskStatus
	 *              物理状态(常量值：Y-物理保留，N-物理删除，默认值：Y) : {@link java.lang.String}
	 */
	public void setDiskStatus(String diskStatus) {
		this.diskStatus = diskStatus == null ? null : diskStatus.trim();
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