/**
 * 上海谨微数据服务有限公司
 */package cn.guludai.market.api.saler.response;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author gaopeng
 */
public class ApproveApplyLoanResp {
    

    /**
     * <pre>
     * 申请审批放款编号
     * 表字段 : approve_apply_loan.loan_code
     * </pre>
     */
    private String loanCode;

    /**
     * <pre>
     * 审批批款金额
     * 表字段 : approve_apply_loan.loan_money
     * </pre>
     */
    private BigDecimal loanMoney;

    /**
     * <pre>
     * 实际放款金额
     * 表字段 : approve_apply_loan.loan_actual_money
     * </pre>
     */
    private BigDecimal loanActualMoney;

    /**
     * <pre>
     * 放款起息日
     * 表字段 : approve_apply_loan.interest_start_time
     * </pre>
     */
    private Date interestStartTime;

    /**
     * <pre>
     * 回款到期日
     * 表字段 : approve_apply_loan.interest_end_time
     * </pre>
     */
    private Date interestEndTime;

    /**
     * <pre>
     * 流程编号
     * 表字段 : approve_apply_loan.flow_code
     * </pre>
     */
    private String flowCode;

    /**
     * <pre>
     * 申请流水编号
     * 表字段 : approve_apply_loan.apply_code
     * </pre>
     */
    private String applyCode;

    /**
     * <pre>
     * Activiti流程编号
     * 表字段 : approve_apply_loan.activiti_code
     * </pre>
     */
    private String activitiCode;

    /**
     * <pre>
     * 版本号(默认值：1，同步递增修改)
     * 表字段 : approve_apply_loan.version
     * </pre>
     */
    private Long version;

    /**
     * <pre>
     * 创建时间
     * 表字段 : approve_apply_loan.create_time
     * </pre>
     */
    private Date createTime;

    /**
     * <pre>
     * 修改时间
     * 表字段 : approve_apply_loan.update_time
     * </pre>
     */
    private Date updateTime;

    /**
     * <pre>
     * 逻辑状态(常量值：Y-逻辑保留，N-逻辑删除，默认值：Y)
     * 表字段 : approve_apply_loan.data_status
     * </pre>
     */
    private String dataStatus;

    /**
     * <pre>
     * 物理状态(常量值：Y-物理保留，N-物理删除，默认值：Y)
     * 表字段 : approve_apply_loan.disk_status
     * </pre>
     */
    private String diskStatus;

    /**
     * <pre>
     * 获取：申请审批放款编号
     * 表字段：approve_apply_loan.loan_code
     * </pre>
     * @return 申请审批放款编号 : {@link java.lang.String} 
     */
    public String getLoanCode() {
        return loanCode;
    }

    /**
     * <pre>
     * 设置：申请审批放款编号
     * 表字段：approve_apply_loan.loan_code
     * </pre>
     * @param loanCode 申请审批放款编号 : {@link java.lang.String} 
     */
    public void setLoanCode(String loanCode) {
        this.loanCode = loanCode == null ? null : loanCode.trim();
    }

    /**
     * <pre>
     * 获取：审批批款金额
     * 表字段：approve_apply_loan.loan_money
     * </pre>
     * @return 审批批款金额 : {@link java.math.BigDecimal} 
     */
    public BigDecimal getLoanMoney() {
        return loanMoney;
    }

    /**
     * <pre>
     * 设置：审批批款金额
     * 表字段：approve_apply_loan.loan_money
     * </pre>
     * @param loanMoney 审批批款金额 : {@link java.math.BigDecimal} 
     */
    public void setLoanMoney(BigDecimal loanMoney) {
        this.loanMoney = loanMoney;
    }

    /**
     * <pre>
     * 获取：实际放款金额
     * 表字段：approve_apply_loan.loan_actual_money
     * </pre>
     * @return 实际放款金额 : {@link java.math.BigDecimal} 
     */
    public BigDecimal getLoanActualMoney() {
        return loanActualMoney;
    }

    /**
     * <pre>
     * 设置：实际放款金额
     * 表字段：approve_apply_loan.loan_actual_money
     * </pre>
     * @param loanActualMoney 实际放款金额 : {@link java.math.BigDecimal} 
     */
    public void setLoanActualMoney(BigDecimal loanActualMoney) {
        this.loanActualMoney = loanActualMoney;
    }

    /**
     * <pre>
     * 获取：放款起息日
     * 表字段：approve_apply_loan.interest_start_time
     * </pre>
     * @return 放款起息日 : {@link java.util.Date} 
     */
    public Date getInterestStartTime() {
        return interestStartTime;
    }

    /**
     * <pre>
     * 设置：放款起息日
     * 表字段：approve_apply_loan.interest_start_time
     * </pre>
     * @param interestStartTime 放款起息日 : {@link java.util.Date} 
     */
    public void setInterestStartTime(Date interestStartTime) {
        this.interestStartTime = interestStartTime;
    }

    /**
     * <pre>
     * 获取：回款到期日
     * 表字段：approve_apply_loan.interest_end_time
     * </pre>
     * @return 回款到期日 : {@link java.util.Date} 
     */
    public Date getInterestEndTime() {
        return interestEndTime;
    }

    /**
     * <pre>
     * 设置：回款到期日
     * 表字段：approve_apply_loan.interest_end_time
     * </pre>
     * @param interestEndTime 回款到期日 : {@link java.util.Date} 
     */
    public void setInterestEndTime(Date interestEndTime) {
        this.interestEndTime = interestEndTime;
    }

    /**
     * <pre>
     * 获取：流程编号
     * 表字段：approve_apply_loan.flow_code
     * </pre>
     * @return 流程编号 : {@link java.lang.String} 
     */
    public String getFlowCode() {
        return flowCode;
    }

    /**
     * <pre>
     * 设置：流程编号
     * 表字段：approve_apply_loan.flow_code
     * </pre>
     * @param flowCode 流程编号 : {@link java.lang.String} 
     */
    public void setFlowCode(String flowCode) {
        this.flowCode = flowCode == null ? null : flowCode.trim();
    }

    /**
     * <pre>
     * 获取：申请流水编号
     * 表字段：approve_apply_loan.apply_code
     * </pre>
     * @return 申请流水编号 : {@link java.lang.String} 
     */
    public String getApplyCode() {
        return applyCode;
    }

    /**
     * <pre>
     * 设置：申请流水编号
     * 表字段：approve_apply_loan.apply_code
     * </pre>
     * @param applyCode 申请流水编号 : {@link java.lang.String} 
     */
    public void setApplyCode(String applyCode) {
        this.applyCode = applyCode == null ? null : applyCode.trim();
    }

    /**
     * <pre>
     * 获取：Activiti流程编号
     * 表字段：approve_apply_loan.activiti_code
     * </pre>
     * @return Activiti流程编号 : {@link java.lang.String} 
     */
    public String getActivitiCode() {
        return activitiCode;
    }

    /**
     * <pre>
     * 设置：Activiti流程编号
     * 表字段：approve_apply_loan.activiti_code
     * </pre>
     * @param activitiCode Activiti流程编号 : {@link java.lang.String} 
     */
    public void setActivitiCode(String activitiCode) {
        this.activitiCode = activitiCode == null ? null : activitiCode.trim();
    }

    /**
     * <pre>
     * 获取：版本号(默认值：1，同步递增修改)
     * 表字段：approve_apply_loan.version
     * </pre>
     * @return 版本号(默认值：1，同步递增修改) : {@link java.lang.Long} 
     */
    public Long getVersion() {
        return version;
    }

    /**
     * <pre>
     * 设置：版本号(默认值：1，同步递增修改)
     * 表字段：approve_apply_loan.version
     * </pre>
     * @param version 版本号(默认值：1，同步递增修改) : {@link java.lang.Long} 
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    /**
     * <pre>
     * 获取：创建时间
     * 表字段：approve_apply_loan.create_time
     * </pre>
     * @return 创建时间 : {@link java.util.Date} 
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * <pre>
     * 设置：创建时间
     * 表字段：approve_apply_loan.create_time
     * </pre>
     * @param createTime 创建时间 : {@link java.util.Date} 
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * <pre>
     * 获取：修改时间
     * 表字段：approve_apply_loan.update_time
     * </pre>
     * @return 修改时间 : {@link java.util.Date} 
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * <pre>
     * 设置：修改时间
     * 表字段：approve_apply_loan.update_time
     * </pre>
     * @param updateTime 修改时间 : {@link java.util.Date} 
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * <pre>
     * 获取：逻辑状态(常量值：Y-逻辑保留，N-逻辑删除，默认值：Y)
     * 表字段：approve_apply_loan.data_status
     * </pre>
     * @return 逻辑状态(常量值：Y-逻辑保留，N-逻辑删除，默认值：Y) : {@link java.lang.String} 
     */
    public String getDataStatus() {
        return dataStatus;
    }

    /**
     * <pre>
     * 设置：逻辑状态(常量值：Y-逻辑保留，N-逻辑删除，默认值：Y)
     * 表字段：approve_apply_loan.data_status
     * </pre>
     * @param dataStatus 逻辑状态(常量值：Y-逻辑保留，N-逻辑删除，默认值：Y) : {@link java.lang.String} 
     */
    public void setDataStatus(String dataStatus) {
        this.dataStatus = dataStatus == null ? null : dataStatus.trim();
    }

    /**
     * <pre>
     * 获取：物理状态(常量值：Y-物理保留，N-物理删除，默认值：Y)
     * 表字段：approve_apply_loan.disk_status
     * </pre>
     * @return 物理状态(常量值：Y-物理保留，N-物理删除，默认值：Y) : {@link java.lang.String} 
     */
    public String getDiskStatus() {
        return diskStatus;
    }

    /**
     * <pre>
     * 设置：物理状态(常量值：Y-物理保留，N-物理删除，默认值：Y)
     * 表字段：approve_apply_loan.disk_status
     * </pre>
     * @param diskStatus 物理状态(常量值：Y-物理保留，N-物理删除，默认值：Y) : {@link java.lang.String} 
     */
    public void setDiskStatus(String diskStatus) {
        this.diskStatus = diskStatus == null ? null : diskStatus.trim();
    }
}