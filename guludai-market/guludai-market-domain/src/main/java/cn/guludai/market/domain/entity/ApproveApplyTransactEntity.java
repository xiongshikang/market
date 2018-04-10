/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.domain.entity;

import java.util.Date;

/**
 * @author gaopeng
 */
public class ApproveApplyTransactEntity {
	/**
	 * <pre>
	 * 主建
	 * 表字段 : approve_apply_transact.id
	 * </pre>
	 */
	private Long id;

	/**
	 * <pre>
	 * 办理编号
	 * 表字段 : approve_apply_transact.transact_code
	 * </pre>
	 */
	private String transactCode;

	/**
	 * <pre>
	 * 办理或转交人
	 * 表字段 : approve_apply_transact.transact_user
	 * </pre>
	 */
	private String transactUser;

	/**
	 * <pre>
	 * 接受人
	 * 表字段 : approve_apply_transact.transact_acceptor
	 * </pre>
	 */
	private String transactAcceptor;

	/**
	 * <pre>
	 * 办理类型(Y代表办理任务,N代有转交任务)
	 * 表字段 : approve_apply_transact.transact_type
	 * </pre>
	 */
	private String transactType;

	/**
	 * <pre>
	 * Activiti流程编号
	 * 表字段 : approve_apply_transact.activiti_code
	 * </pre>
	 */
	private String activitiCode;

	/**
	 * <pre>
	 * 申请流水编号
	 * 表字段 : approve_apply_transact.apply_code
	 * </pre>
	 */
	private String applyCode;

	/**
	 * <pre>
	 * 流程编号
	 * 表字段 : approve_apply_transact.flow_code
	 * </pre>
	 */
	private String flowCode;

	/**
	 * <pre>
	 * 进度节点编号
	 * 表字段 : approve_apply_transact.node_code
	 * </pre>
	 */
	private String nodeCode;

	/**
	 * <pre>
	 * 版本号(默认值：1，同步递增修改)
	 * 表字段 : approve_apply_transact.version
	 * </pre>
	 */
	private Long version;

	/**
	 * <pre>
	 * 创建时间
	 * 表字段 : approve_apply_transact.create_time
	 * </pre>
	 */
	private Date createTime;

	/**
	 * <pre>
	 * 更新时间
	 * 表字段 : approve_apply_transact.update_time
	 * </pre>
	 */
	private Date updateTime;

	/**
	 * <pre>
	 * 逻辑状态(常量值：Y-逻辑保留，N-逻辑删除，默认值：Y)
	 * 表字段 : approve_apply_transact.data_status
	 * </pre>
	 */
	private String dataStatus;

	/**
	 * <pre>
	 * 物理状态(常量值：Y-物理保留，N-物理删除，默认值：Y)
	 * 表字段 : approve_apply_transact.disk_status
	 * </pre>
	 */
	private String diskStatus;

	/**
	 * <pre>
	 * 注备
	 * 表字段 : approve_apply_transact.transact_comment
	 * </pre>
	 */
	private String transactComment;
	
	/**
	 * 指派或转交人的上级
	 */
	private String transactParentUser;
	
	public String getTransactParentUser() {
		return transactParentUser;
	}

	public void setTransactParentUser(String transactParentUser) {
		this.transactParentUser = transactParentUser;
	}

	/**
	 * <pre>
	 * 获取：主建
	 * 表字段：approve_apply_transact.id
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
	 * 表字段：approve_apply_transact.id
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
	 * 获取：办理编号
	 * 表字段：approve_apply_transact.transact_code
	 * </pre>
	 * 
	 * @return 办理编号 : {@link java.lang.String}
	 */
	public String getTransactCode() {
		return transactCode;
	}

	/**
	 * <pre>
	 * 设置：办理编号
	 * 表字段：approve_apply_transact.transact_code
	 * </pre>
	 * 
	 * @param transactCode
	 *              办理编号 : {@link java.lang.String}
	 */
	public void setTransactCode(String transactCode) {
		this.transactCode = transactCode == null ? null : transactCode.trim();
	}

	/**
	 * <pre>
	 * 获取：办理或转交人
	 * 表字段：approve_apply_transact.transact_user
	 * </pre>
	 * 
	 * @return 办理或转交人 : {@link java.lang.String}
	 */
	public String getTransactUser() {
		return transactUser;
	}

	/**
	 * <pre>
	 * 设置：办理或转交人
	 * 表字段：approve_apply_transact.transact_user
	 * </pre>
	 * 
	 * @param transactUser
	 *              办理或转交人 : {@link java.lang.String}
	 */
	public void setTransactUser(String transactUser) {
		this.transactUser = transactUser == null ? null : transactUser.trim();
	}

	/**
	 * <pre>
	 * 获取：接受人
	 * 表字段：approve_apply_transact.transact_acceptor
	 * </pre>
	 * 
	 * @return 接受人 : {@link java.lang.String}
	 */
	public String getTransactAcceptor() {
		return transactAcceptor;
	}

	/**
	 * <pre>
	 * 设置：接受人
	 * 表字段：approve_apply_transact.transact_acceptor
	 * </pre>
	 * 
	 * @param transactAcceptor
	 *              接受人 : {@link java.lang.String}
	 */
	public void setTransactAcceptor(String transactAcceptor) {
		this.transactAcceptor = transactAcceptor == null ? null : transactAcceptor.trim();
	}

	/**
	 * <pre>
	 * 获取：办理类型(Y代表办理任务,N代有转交任务)
	 * 表字段：approve_apply_transact.transact_type
	 * </pre>
	 * 
	 * @return 办理类型(Y代表办理任务,N代有转交任务) : {@link java.lang.String}
	 */
	public String getTransactType() {
		return transactType;
	}

	/**
	 * <pre>
	 * 设置：办理类型(Y代表办理任务,N代有转交任务)
	 * 表字段：approve_apply_transact.transact_type
	 * </pre>
	 * 
	 * @param transactType
	 *              办理类型(Y代表办理任务,N代有转交任务) : {@link java.lang.String}
	 */
	public void setTransactType(String transactType) {
		this.transactType = transactType == null ? null : transactType.trim();
	}

	/**
	 * <pre>
	 * 获取：Activiti流程编号
	 * 表字段：approve_apply_transact.activiti_code
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
	 * 表字段：approve_apply_transact.activiti_code
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
	 * 表字段：approve_apply_transact.apply_code
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
	 * 表字段：approve_apply_transact.apply_code
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
	 * 表字段：approve_apply_transact.flow_code
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
	 * 表字段：approve_apply_transact.flow_code
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
	 * 表字段：approve_apply_transact.node_code
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
	 * 表字段：approve_apply_transact.node_code
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
	 * 表字段：approve_apply_transact.version
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
	 * 表字段：approve_apply_transact.version
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
	 * 表字段：approve_apply_transact.create_time
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
	 * 表字段：approve_apply_transact.create_time
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
	 * 表字段：approve_apply_transact.update_time
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
	 * 表字段：approve_apply_transact.update_time
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
	 * 表字段：approve_apply_transact.data_status
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
	 * 表字段：approve_apply_transact.data_status
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
	 * 表字段：approve_apply_transact.disk_status
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
	 * 表字段：approve_apply_transact.disk_status
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
	 * 获取：注备
	 * 表字段：approve_apply_transact.transact_comment
	 * </pre>
	 * 
	 * @return 注备 : {@link java.lang.String}
	 */
	public String getTransactComment() {
		return transactComment;
	}

	/**
	 * <pre>
	 * 设置：注备
	 * 表字段：approve_apply_transact.transact_comment
	 * </pre>
	 * 
	 * @param transactComment
	 *              注备 : {@link java.lang.String}
	 */
	public void setTransactComment(String transactComment) {
		this.transactComment = transactComment == null ? null : transactComment.trim();
	}
}