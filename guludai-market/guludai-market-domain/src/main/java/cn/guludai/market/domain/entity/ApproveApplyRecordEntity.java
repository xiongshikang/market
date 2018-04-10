/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.domain.entity;

import java.util.Date;

/**
 * @author gaopeng
 */
public class ApproveApplyRecordEntity {
	/**
	 * <pre>
	 * 默认主键自增
	 * 表字段 : approve_apply_record.id
	 * </pre>
	 */
	private Long id;

	/**
	 * <pre>
	 * 流程进度审批状态(常量值：Y-同意，N-拒绝，O-审批中)
	 * 表字段 : approve_apply_record.flow_node_status
	 * </pre>
	 */
	private String flowNodeStatus;

	/**
	 * <pre>
	 * 流程进度审批结果
	 * 表字段 : approve_apply_record.flow_node_result
	 * </pre>
	 */
	private String flowNodeResult;

	/**
	 * <pre>
	 * 进度节点编号
	 * 表字段 : approve_apply_record.node_code
	 * </pre>
	 */
	private String nodeCode;

	/**
	 * <pre>
	 * 流程编号
	 * 表字段 : approve_apply_record.flow_code
	 * </pre>
	 */
	private String flowCode;

	/**
	 * <pre>
	 * Activiti流程编号
	 * 表字段 : approve_apply_record.activiti_code
	 * </pre>
	 */
	private String activitiCode;

	/**
	 * <pre>
	 * 申请流水编号
	 * 表字段 : approve_apply_record.apply_code
	 * </pre>
	 */
	private String applyCode;

	/**
	 * <pre>
	 * 版本号(默认值：1，同步递增修改)
	 * 表字段 : approve_apply_record.version
	 * </pre>
	 */
	private Long version;

	/**
	 * <pre>
	 * 创建时间
	 * 表字段 : approve_apply_record.create_time
	 * </pre>
	 */
	private Date createTime;

	/**
	 * <pre>
	 * 修改时间
	 * 表字段 : approve_apply_record.update_time
	 * </pre>
	 */
	private Date updateTime;

	/**
	 * <pre>
	 * 逻辑状态(常量值：Y-逻辑保留，N-逻辑删除，默认值：Y)
	 * 表字段 : approve_apply_record.data_status
	 * </pre>
	 */
	private String dataStatus;

	/**
	 * <pre>
	 * 物理状态(常量值：Y-物理保留，N-物理删除，默认值：Y)
	 * 表字段 : approve_apply_record.disk_status
	 * </pre>
	 */
	private String diskStatus;

	/**
	 * 任务持行人编号
	 */
	private String userCode;
	
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	/**
	 * <pre>
	 * 获取：默认主键自增
	 * 表字段：approve_apply_record.id
	 * </pre>
	 * 
	 * @return 默认主键自增 : {@link java.lang.Long}
	 */
	public Long getId() {
		return id;
	}

	/**
	 * <pre>
	 * 设置：默认主键自增
	 * 表字段：approve_apply_record.id
	 * </pre>
	 * 
	 * @param id
	 *              默认主键自增 : {@link java.lang.Long}
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * <pre>
	 * 获取：流程进度审批状态(常量值：Y-同意，N-拒绝，O-审批中)
	 * 表字段：approve_apply_record.flow_node_status
	 * </pre>
	 * 
	 * @return 流程进度审批状态(常量值：Y-同意，N-拒绝，O-审批中) : {@link java.lang.String}
	 */
	public String getFlowNodeStatus() {
		return flowNodeStatus;
	}

	/**
	 * <pre>
	 * 设置：流程进度审批状态(常量值：Y-同意，N-拒绝，O-审批中)
	 * 表字段：approve_apply_record.flow_node_status
	 * </pre>
	 * 
	 * @param flowNodeStatus
	 *              流程进度审批状态(常量值：Y-同意，N-拒绝，O-审批中) : {@link java.lang.String}
	 */
	public void setFlowNodeStatus(String flowNodeStatus) {
		this.flowNodeStatus = flowNodeStatus == null ? null : flowNodeStatus.trim();
	}

	/**
	 * <pre>
	 * 获取：流程进度审批结果
	 * 表字段：approve_apply_record.flow_node_result
	 * </pre>
	 * 
	 * @return 流程进度审批结果 : {@link java.lang.String}
	 */
	public String getFlowNodeResult() {
		return flowNodeResult;
	}

	/**
	 * <pre>
	 * 设置：流程进度审批结果
	 * 表字段：approve_apply_record.flow_node_result
	 * </pre>
	 * 
	 * @param flowNodeResult
	 *              流程进度审批结果 : {@link java.lang.String}
	 */
	public void setFlowNodeResult(String flowNodeResult) {
		this.flowNodeResult = flowNodeResult == null ? null : flowNodeResult.trim();
	}

	/**
	 * <pre>
	 * 获取：进度节点编号
	 * 表字段：approve_apply_record.node_code
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
	 * 表字段：approve_apply_record.node_code
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
	 * 获取：流程编号
	 * 表字段：approve_apply_record.flow_code
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
	 * 表字段：approve_apply_record.flow_code
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
	 * 获取：Activiti流程编号
	 * 表字段：approve_apply_record.activiti_code
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
	 * 表字段：approve_apply_record.activiti_code
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
	 * 表字段：approve_apply_record.apply_code
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
	 * 表字段：approve_apply_record.apply_code
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
	 * 获取：版本号(默认值：1，同步递增修改)
	 * 表字段：approve_apply_record.version
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
	 * 表字段：approve_apply_record.version
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
	 * 表字段：approve_apply_record.create_time
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
	 * 表字段：approve_apply_record.create_time
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
	 * 获取：修改时间
	 * 表字段：approve_apply_record.update_time
	 * </pre>
	 * 
	 * @return 修改时间 : {@link java.util.Date}
	 */
	public Date getUpdateTime() {
		return updateTime;
	}

	/**
	 * <pre>
	 * 设置：修改时间
	 * 表字段：approve_apply_record.update_time
	 * </pre>
	 * 
	 * @param updateTime
	 *              修改时间 : {@link java.util.Date}
	 */
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}

	/**
	 * <pre>
	 * 获取：逻辑状态(常量值：Y-逻辑保留，N-逻辑删除，默认值：Y)
	 * 表字段：approve_apply_record.data_status
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
	 * 表字段：approve_apply_record.data_status
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
	 * 表字段：approve_apply_record.disk_status
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
	 * 表字段：approve_apply_record.disk_status
	 * </pre>
	 * 
	 * @param diskStatus
	 *              物理状态(常量值：Y-物理保留，N-物理删除，默认值：Y) : {@link java.lang.String}
	 */
	public void setDiskStatus(String diskStatus) {
		this.diskStatus = diskStatus == null ? null : diskStatus.trim();
	}
}