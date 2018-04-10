/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.domain.entity;

import java.util.Date;

/**
 * @author gaopeng
 */
public class ApproveFlowEntity {
	/**
	 * <pre>
	 * 默认主键自增
	 * 表字段 : approve_flow.id
	 * </pre>
	 */
	private Long id;

	/**
	 * <pre>
	 * 审批流程编号
	 * 表字段 : approve_flow.flow_code
	 * </pre>
	 */
	private String flowCode;

	/**
	 * <pre>
	 * 流程类型 常量值：1=销售资料审批流程，2=风控材料审批流程
	 * 表字段 : approve_flow.flow_type
	 * </pre>
	 */
	private String flowType;

	/**
	 * <pre>
	 * 流程简称
	 * 表字段 : approve_flow.flow_name
	 * </pre>
	 */
	private String flowName;

	/**
	 * <pre>
	 * 流程描述
	 * 表字段 : approve_flow.flow_description
	 * </pre>
	 */
	private String flowDescription;

	/**
	 * <pre>
	 * 流程状态 常量值：Y-启用，N-停用，默认值：Y
	 * 表字段 : approve_flow.flow_status
	 * </pre>
	 */
	private String flowStatus;

	/**
	 * <pre>
	 * 版本号(默认值：1，同步递增修改)
	 * 表字段 : approve_flow.version
	 * </pre>
	 */
	private Long version;

	/**
	 * <pre>
	 * 创建时间
	 * 表字段 : approve_flow.create_time
	 * </pre>
	 */
	private Date createTime;

	/**
	 * <pre>
	 * 修改时间
	 * 表字段 : approve_flow.update_time
	 * </pre>
	 */
	private Date updateTime;

	/**
	 * <pre>
	 * 逻辑状态(常量值：Y-逻辑保留，N-逻辑删除，默认值：Y)
	 * 表字段 : approve_flow.data_status
	 * </pre>
	 */
	private String dataStatus;

	/**
	 * <pre>
	 * 物理状态(常量值：Y-物理保留，N-物理删除，默认值：Y)
	 * 表字段 : approve_flow.disk_status
	 * </pre>
	 */
	private String diskStatus;

	/**
	 * <pre>
	 * 获取：默认主键自增
	 * 表字段：approve_flow.id
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
	 * 表字段：approve_flow.id
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
	 * 获取：审批流程编号
	 * 表字段：approve_flow.flow_code
	 * </pre>
	 * 
	 * @return 审批流程编号 : {@link java.lang.String}
	 */
	public String getFlowCode() {
		return flowCode;
	}

	/**
	 * <pre>
	 * 设置：审批流程编号
	 * 表字段：approve_flow.flow_code
	 * </pre>
	 * 
	 * @param flowCode
	 *              审批流程编号 : {@link java.lang.String}
	 */
	public void setFlowCode(String flowCode) {
		this.flowCode = flowCode == null ? null : flowCode.trim();
	}

	/**
	 * <pre>
	 * 获取：流程类型 常量值：1=销售资料审批流程，2=风控材料审批流程
	 * 表字段：approve_flow.flow_type
	 * </pre>
	 * 
	 * @return 流程类型 常量值：1=销售资料审批流程，2=风控材料审批流程 : {@link java.lang.String}
	 */
	public String getFlowType() {
		return flowType;
	}

	/**
	 * <pre>
	 * 设置：流程类型 常量值：1=销售资料审批流程，2=风控材料审批流程
	 * 表字段：approve_flow.flow_type
	 * </pre>
	 * 
	 * @param flowType
	 *              流程类型 常量值：1=销售资料审批流程，2=风控材料审批流程 : {@link java.lang.String}
	 */
	public void setFlowType(String flowType) {
		this.flowType = flowType == null ? null : flowType.trim();
	}

	/**
	 * <pre>
	 * 获取：流程简称
	 * 表字段：approve_flow.flow_name
	 * </pre>
	 * 
	 * @return 流程简称 : {@link java.lang.String}
	 */
	public String getFlowName() {
		return flowName;
	}

	/**
	 * <pre>
	 * 设置：流程简称
	 * 表字段：approve_flow.flow_name
	 * </pre>
	 * 
	 * @param flowName
	 *              流程简称 : {@link java.lang.String}
	 */
	public void setFlowName(String flowName) {
		this.flowName = flowName == null ? null : flowName.trim();
	}

	/**
	 * <pre>
	 * 获取：流程描述
	 * 表字段：approve_flow.flow_description
	 * </pre>
	 * 
	 * @return 流程描述 : {@link java.lang.String}
	 */
	public String getFlowDescription() {
		return flowDescription;
	}

	/**
	 * <pre>
	 * 设置：流程描述
	 * 表字段：approve_flow.flow_description
	 * </pre>
	 * 
	 * @param flowDescription
	 *              流程描述 : {@link java.lang.String}
	 */
	public void setFlowDescription(String flowDescription) {
		this.flowDescription = flowDescription == null ? null : flowDescription.trim();
	}

	/**
	 * <pre>
	 * 获取：流程状态 常量值：Y-启用，N-停用，默认值：Y
	 * 表字段：approve_flow.flow_status
	 * </pre>
	 * 
	 * @return 流程状态 常量值：Y-启用，N-停用，默认值：Y : {@link java.lang.String}
	 */
	public String getFlowStatus() {
		return flowStatus;
	}

	/**
	 * <pre>
	 * 设置：流程状态 常量值：Y-启用，N-停用，默认值：Y
	 * 表字段：approve_flow.flow_status
	 * </pre>
	 * 
	 * @param flowStatus
	 *              流程状态 常量值：Y-启用，N-停用，默认值：Y : {@link java.lang.String}
	 */
	public void setFlowStatus(String flowStatus) {
		this.flowStatus = flowStatus == null ? null : flowStatus.trim();
	}

	/**
	 * <pre>
	 * 获取：版本号(默认值：1，同步递增修改)
	 * 表字段：approve_flow.version
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
	 * 表字段：approve_flow.version
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
	 * 表字段：approve_flow.create_time
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
	 * 表字段：approve_flow.create_time
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
	 * 表字段：approve_flow.update_time
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
	 * 表字段：approve_flow.update_time
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
	 * 表字段：approve_flow.data_status
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
	 * 表字段：approve_flow.data_status
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
	 * 表字段：approve_flow.disk_status
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
	 * 表字段：approve_flow.disk_status
	 * </pre>
	 * 
	 * @param diskStatus
	 *              物理状态(常量值：Y-物理保留，N-物理删除，默认值：Y) : {@link java.lang.String}
	 */
	public void setDiskStatus(String diskStatus) {
		this.diskStatus = diskStatus == null ? null : diskStatus.trim();
	}
}