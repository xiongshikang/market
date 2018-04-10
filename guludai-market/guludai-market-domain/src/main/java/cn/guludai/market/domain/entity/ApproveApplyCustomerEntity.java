/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.domain.entity;

import java.util.Date;

/**
 * @author gaopeng
 */
public class ApproveApplyCustomerEntity {
	/**
	 * <pre>
	 * 默认主键自增
	 * 表字段 : approve_apply_customer.id
	 * </pre>
	 */
	private Long id;

	/**
	 * <pre>
	 * 申请审批客户信息编号
	 * 表字段 : approve_apply_customer.customer_code
	 * </pre>
	 */
	private String customerCode;

	/**
	 * <pre>
	 * 申请审批客户身份证号
	 * 表字段 : approve_apply_customer.customer_idcard
	 * </pre>
	 */
	private String customerIdcard;

	/**
	 * <pre>
	 * 申请审批客户姓名
	 * 表字段 : approve_apply_customer.customer_name
	 * </pre>
	 */
	private String customerName;

	/**
	 * <pre>
	 * 流程编号
	 * 表字段 : approve_apply_customer.flow_code
	 * </pre>
	 */
	private String flowCode;

	/**
	 * <pre>
	 * 申请流水编号
	 * 表字段 : approve_apply_customer.apply_code
	 * </pre>
	 */
	private String applyCode;

	/**
	 * <pre>
	 * Activiti流程编号
	 * 表字段 : approve_apply_customer.activiti_code
	 * </pre>
	 */
	private String activitiCode;

	/**
	 * <pre>
	 * 版本号(默认值：1，同步递增修改)
	 * 表字段 : approve_apply_customer.version
	 * </pre>
	 */
	private Long version;

	/**
	 * <pre>
	 * 创建时间
	 * 表字段 : approve_apply_customer.create_time
	 * </pre>
	 */
	private Date createTime;

	/**
	 * <pre>
	 * 修改时间
	 * 表字段 : approve_apply_customer.update_time
	 * </pre>
	 */
	private Date updateTime;

	/**
	 * <pre>
	 * 逻辑状态(常量值：Y-逻辑保留，N-逻辑删除，默认值：Y)
	 * 表字段 : approve_apply_customer.data_status
	 * </pre>
	 */
	private String dataStatus;

	/**
	 * <pre>
	 * 物理状态(常量值：Y-物理保留，N-物理删除，默认值：Y)
	 * 表字段 : approve_apply_customer.disk_status
	 * </pre>
	 */
	private String diskStatus;

	/**
	 * <pre>
	 * 获取：默认主键自增
	 * 表字段：approve_apply_customer.id
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
	 * 表字段：approve_apply_customer.id
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
	 * 获取：申请审批客户信息编号
	 * 表字段：approve_apply_customer.customer_code
	 * </pre>
	 * 
	 * @return 申请审批客户信息编号 : {@link java.lang.String}
	 */
	public String getCustomerCode() {
		return customerCode;
	}

	/**
	 * <pre>
	 * 设置：申请审批客户信息编号
	 * 表字段：approve_apply_customer.customer_code
	 * </pre>
	 * 
	 * @param customerCode
	 *              申请审批客户信息编号 : {@link java.lang.String}
	 */
	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode == null ? null : customerCode.trim();
	}

	/**
	 * <pre>
	 * 获取：申请审批客户身份证号
	 * 表字段：approve_apply_customer.customer_idcard
	 * </pre>
	 * 
	 * @return 申请审批客户身份证号 : {@link java.lang.String}
	 */
	public String getCustomerIdcard() {
		return customerIdcard;
	}

	/**
	 * <pre>
	 * 设置：申请审批客户身份证号
	 * 表字段：approve_apply_customer.customer_idcard
	 * </pre>
	 * 
	 * @param customerIdcard
	 *              申请审批客户身份证号 : {@link java.lang.String}
	 */
	public void setCustomerIdcard(String customerIdcard) {
		this.customerIdcard = customerIdcard == null ? null : customerIdcard.trim();
	}

	/**
	 * <pre>
	 * 获取：申请审批客户姓名
	 * 表字段：approve_apply_customer.customer_name
	 * </pre>
	 * 
	 * @return 申请审批客户姓名 : {@link java.lang.String}
	 */
	public String getCustomerName() {
		return customerName;
	}

	/**
	 * <pre>
	 * 设置：申请审批客户姓名
	 * 表字段：approve_apply_customer.customer_name
	 * </pre>
	 * 
	 * @param customerName
	 *              申请审批客户姓名 : {@link java.lang.String}
	 */
	public void setCustomerName(String customerName) {
		this.customerName = customerName == null ? null : customerName.trim();
	}

	/**
	 * <pre>
	 * 获取：流程编号
	 * 表字段：approve_apply_customer.flow_code
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
	 * 表字段：approve_apply_customer.flow_code
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
	 * 获取：申请流水编号
	 * 表字段：approve_apply_customer.apply_code
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
	 * 表字段：approve_apply_customer.apply_code
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
	 * 表字段：approve_apply_customer.activiti_code
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
	 * 表字段：approve_apply_customer.activiti_code
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
	 * 获取：版本号(默认值：1，同步递增修改)
	 * 表字段：approve_apply_customer.version
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
	 * 表字段：approve_apply_customer.version
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
	 * 表字段：approve_apply_customer.create_time
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
	 * 表字段：approve_apply_customer.create_time
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
	 * 表字段：approve_apply_customer.update_time
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
	 * 表字段：approve_apply_customer.update_time
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
	 * 表字段：approve_apply_customer.data_status
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
	 * 表字段：approve_apply_customer.data_status
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
	 * 表字段：approve_apply_customer.disk_status
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
	 * 表字段：approve_apply_customer.disk_status
	 * </pre>
	 * 
	 * @param diskStatus
	 *              物理状态(常量值：Y-物理保留，N-物理删除，默认值：Y) : {@link java.lang.String}
	 */
	public void setDiskStatus(String diskStatus) {
		this.diskStatus = diskStatus == null ? null : diskStatus.trim();
	}
}