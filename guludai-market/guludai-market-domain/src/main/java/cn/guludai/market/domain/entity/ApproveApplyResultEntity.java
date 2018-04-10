/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.domain.entity;

import java.util.Date;

/**
 * @author gaopeng
 */
public class ApproveApplyResultEntity {
	/**
	 * <pre>
	 * 默认主键自增
	 * 表字段 : approve_apply_result.id
	 * </pre>
	 */
	private Long id;

	/**
	 * <pre>
	 * 审批开始时间
	 * 表字段 : approve_apply_result.approve_start_time
	 * </pre>
	 */
	private Date approveStartTime;

	/**
	 * <pre>
	 * 审批结束时间
	 * 表字段 : approve_apply_result.approve_end_time
	 * </pre>
	 */
	private Date approveEndTime;

	/**
	 * <pre>
	 * 审批状态(常量值：Y-已审批，N-未审批，O-审批中，默认值：N)
	 * 表字段 : approve_apply_result.approve_status
	 * </pre>
	 */
	private String approveStatus;

	/**
	 * <pre>
	 * 审批结果(常量值：Y-同意（绑定），N-拒绝（解绑），O-待定（未绑），默认值：O)
	 * 表字段 : approve_apply_result.approve_result
	 * </pre>
	 */
	private String approveResult;

	/**
	 * <pre>
	 * 申请时间
	 * 表字段 : approve_apply_result.apply_time
	 * </pre>
	 */
	private Date applyTime;

	/**
	 * <pre>
	 * 申请流水编号
	 * 表字段 : approve_apply_result.apply_code
	 * </pre>
	 */
	private String applyCode;

	/**
	 * <pre>
	 * Activiti流程编号
	 * 表字段 : approve_apply_result.activiti_code
	 * </pre>
	 */
	private String activitiCode;

	/**
	 * <pre>
	 * 流程编号
	 * 表字段 : approve_apply_result.flow_code
	 * </pre>
	 */
	private String flowCode;

	/**
	 * <pre>
	 * 最新的审批进度节点编号
	 * 表字段 : approve_apply_result.node_code
	 * </pre>
	 */
	private String nodeCode;

	/**
	 * <pre>
	 * 版本号(默认值：1，同步递增修改)
	 * 表字段 : approve_apply_result.version
	 * </pre>
	 */
	private Long version;

	/**
	 * <pre>
	 * 创建时间
	 * 表字段 : approve_apply_result.create_time
	 * </pre>
	 */
	private Date createTime;

	/**
	 * <pre>
	 * 修改时间
	 * 表字段 : approve_apply_result.update_time
	 * </pre>
	 */
	private Date updateTime;

	/**
	 * <pre>
	 * 逻辑状态(常量值：Y-逻辑保留，N-逻辑删除，默认值：Y)
	 * 表字段 : approve_apply_result.data_status
	 * </pre>
	 */
	private String dataStatus;

	/**
	 * <pre>
	 * 物理状态(常量值：Y-物理保留，N-物理删除，默认值：Y)
	 * 表字段 : approve_apply_result.disk_status
	 * </pre>
	 */
	private String diskStatus;

	/**
	 * 门店编号
	 */
	private String shopCode;


	public String getShopCode() {
		return shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}

	/**
	 * <pre>
	 * 获取：默认主键自增
	 * 表字段：approve_apply_result.id
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
	 * 表字段：approve_apply_result.id
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
	 * 获取：审批开始时间
	 * 表字段：approve_apply_result.approve_start_time
	 * </pre>
	 * 
	 * @return 审批开始时间 : {@link java.util.Date}
	 */
	public Date getApproveStartTime() {
		return approveStartTime;
	}

	/**
	 * <pre>
	 * 设置：审批开始时间
	 * 表字段：approve_apply_result.approve_start_time
	 * </pre>
	 * 
	 * @param approveStartTime
	 *              审批开始时间 : {@link java.util.Date}
	 */
	public void setApproveStartTime(Date approveStartTime) {
		this.approveStartTime = approveStartTime;
	}

	/**
	 * <pre>
	 * 获取：审批结束时间
	 * 表字段：approve_apply_result.approve_end_time
	 * </pre>
	 * 
	 * @return 审批结束时间 : {@link java.util.Date}
	 */
	public Date getApproveEndTime() {
		return approveEndTime;
	}

	/**
	 * <pre>
	 * 设置：审批结束时间
	 * 表字段：approve_apply_result.approve_end_time
	 * </pre>
	 * 
	 * @param approveEndTime
	 *              审批结束时间 : {@link java.util.Date}
	 */
	public void setApproveEndTime(Date approveEndTime) {
		this.approveEndTime = approveEndTime;
	}

	/**
	 * <pre>
	 * 获取：审批状态(常量值：Y-已审批，N-未审批，O-审批中，默认值：N)
	 * 表字段：approve_apply_result.approve_status
	 * </pre>
	 * 
	 * @return 审批状态(常量值：Y-已审批，N-未审批，O-审批中，默认值：N) : {@link java.lang.String}
	 */
	public String getApproveStatus() {
		return approveStatus;
	}

	/**
	 * <pre>
	 * 设置：审批状态(常量值：Y-已审批，N-未审批，O-审批中，默认值：N)
	 * 表字段：approve_apply_result.approve_status
	 * </pre>
	 * 
	 * @param approveStatus
	 *              审批状态(常量值：Y-已审批，N-未审批，O-审批中，默认值：N) : {@link java.lang.String}
	 */
	public void setApproveStatus(String approveStatus) {
		this.approveStatus = approveStatus == null ? null : approveStatus.trim();
	}

	/**
	 * <pre>
	 * 获取：审批结果(常量值：Y-同意（绑定），N-拒绝（解绑），O-待定（未绑），默认值：O)
	 * 表字段：approve_apply_result.approve_result
	 * </pre>
	 * 
	 * @return 审批结果(常量值：Y-同意（绑定），N-拒绝（解绑），O-待定（未绑），默认值：O) : {@link java.lang.String}
	 */
	public String getApproveResult() {
		return approveResult;
	}

	/**
	 * <pre>
	 * 设置：审批结果(常量值：Y-同意（绑定），N-拒绝（解绑），O-待定（未绑），默认值：O)
	 * 表字段：approve_apply_result.approve_result
	 * </pre>
	 * 
	 * @param approveResult
	 *              审批结果(常量值：Y-同意（绑定），N-拒绝（解绑），O-待定（未绑），默认值：O) :
	 *              {@link java.lang.String}
	 */
	public void setApproveResult(String approveResult) {
		this.approveResult = approveResult == null ? null : approveResult.trim();
	}

	/**
	 * <pre>
	 * 获取：申请时间
	 * 表字段：approve_apply_result.apply_time
	 * </pre>
	 * 
	 * @return 申请时间 : {@link java.util.Date}
	 */
	public Date getApplyTime() {
		return applyTime;
	}

	/**
	 * <pre>
	 * 设置：申请时间
	 * 表字段：approve_apply_result.apply_time
	 * </pre>
	 * 
	 * @param applyTime
	 *              申请时间 : {@link java.util.Date}
	 */
	public void setApplyTime(Date applyTime) {
		this.applyTime = applyTime;
	}

	/**
	 * <pre>
	 * 获取：申请流水编号
	 * 表字段：approve_apply_result.apply_code
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
	 * 表字段：approve_apply_result.apply_code
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
	 * 获取：Activiti流程编号
	 * 表字段：approve_apply_result.activiti_code
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
	 * 表字段：approve_apply_result.activiti_code
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
	 * 获取：流程编号
	 * 表字段：approve_apply_result.flow_code
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
	 * 表字段：approve_apply_result.flow_code
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
	 * 获取：最新的审批进度节点编号
	 * 表字段：approve_apply_result.node_code
	 * </pre>
	 * 
	 * @return 最新的审批进度节点编号 : {@link java.lang.String}
	 */
	public String getNodeCode() {
		return nodeCode;
	}

	/**
	 * <pre>
	 * 设置：最新的审批进度节点编号
	 * 表字段：approve_apply_result.node_code
	 * </pre>
	 * 
	 * @param flowCode
	 *              最新的审批进度节点编号 : {@link java.lang.String}
	 */
	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}

	/**
	 * <pre>
	 * 获取：版本号(默认值：1，同步递增修改)
	 * 表字段：approve_apply_result.version
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
	 * 表字段：approve_apply_result.version
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
	 * 表字段：approve_apply_result.create_time
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
	 * 表字段：approve_apply_result.create_time
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
	 * 表字段：approve_apply_result.update_time
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
	 * 表字段：approve_apply_result.update_time
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
	 * 表字段：approve_apply_result.data_status
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
	 * 表字段：approve_apply_result.data_status
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
	 * 表字段：approve_apply_result.disk_status
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
	 * 表字段：approve_apply_result.disk_status
	 * </pre>
	 * 
	 * @param diskStatus
	 *              物理状态(常量值：Y-物理保留，N-物理删除，默认值：Y) : {@link java.lang.String}
	 */
	public void setDiskStatus(String diskStatus) {
		this.diskStatus = diskStatus == null ? null : diskStatus.trim();
	}
}