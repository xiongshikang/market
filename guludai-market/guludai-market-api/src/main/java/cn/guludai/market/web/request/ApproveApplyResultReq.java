/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.request;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 
 * @ClassName: ApproveApplyResultReq 
 * @Description: 申请审批结果接参类
 * @author: xiongshikang
 * @date: 2017年11月27日 下午2:13:14
 */
public class ApproveApplyResultReq extends BaseReq {
	
	/**
	 * @author: xiongshikang
	 * @date: 2017年11月27日 下午5:05:37
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * 办理或转交人(用来查找个人历吏任务)
	 */
	private String transactUser;
	
	/**
	 * 节点编号
	 */
    private String nodeCode;
    
	private String id;
	/**
	 * 指派任务的持行人usercode
	 */
	private String taskActionUserCode;

	/**
	 * <pre>
	 * 申请流水编号
	 * 表字段 : approve_apply_result.apply_code
	 * </pre>
	 */
	private String applyCode;
	
	/**
	 * 备注
	 */
    private String flowNodeResult;
    
    /**
     * 确定与取消
     */
    private String yesOrNo;

    //=======================erp厂商编号======================
    /**
     * ERP厂商编号
     */
    private String	erpFactoryCode;
    
    //=======================erp版本号编号=================================
    /**
     * ERP版本号编号
     */
    private String erpVersionCode;
    
    //========================门店公司信息===================================
    
    //公司编号
    private String companyCode;
    
    //========================门店信息===================================
    
   //门店名称
    private String shopName;
    //联系人
    private String contacts;
    //联系电话
    private String phone;
    //商铺地址
    private String shopAddress;
    //省份编号
    private String provinceNo;
    //城市编号
    private String cityNo;
    //镇区编号
    private String townNo;
    //门店编号
    private String shopCode;
    //========================资金发放数据================================
   
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
    
    private String flowCode;
    
    private String activitiCode;
    
    public String getNodeCode() {
		return nodeCode;
	}

	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}

	public String getTransactUser() {
		return transactUser;
	}

	public void setTransactUser(String transactUser) {
		this.transactUser = transactUser;
	}

	public String getActivitiCode() {
		return activitiCode;
	}

	public void setActivitiCode(String activitiCode) {
		this.activitiCode = activitiCode;
	}

	public String getFlowCode() {
		return flowCode;
	}

	public void setFlowCode(String flowCode) {
		this.flowCode = flowCode;
	}

	public String getShopCode() {
		return shopCode;
	}

	public void setShopCode(String shopCode) {
		this.shopCode = shopCode;
	}

	//===============身份证信息===========
    private List<ApproveApplyCustomerReq> approveApplyCustomerReqs;
    
	public List<ApproveApplyCustomerReq> getApproveApplyCustomerReqs() {
		return approveApplyCustomerReqs;
	}

	public void setApproveApplyCustomerReqs(List<ApproveApplyCustomerReq> approveApplyCustomerReqs) {
		this.approveApplyCustomerReqs = approveApplyCustomerReqs;
	}

	public BigDecimal getLoanMoney() {
		return loanMoney;
	}

	public void setLoanMoney(BigDecimal loanMoney) {
		this.loanMoney = loanMoney;
	}

	public BigDecimal getLoanActualMoney() {
		return loanActualMoney;
	}

	public void setLoanActualMoney(BigDecimal loanActualMoney) {
		this.loanActualMoney = loanActualMoney;
	}

	public Date getInterestStartTime() {
		return interestStartTime;
	}

	public void setInterestStartTime(Date interestStartTime) {
		this.interestStartTime = interestStartTime;
	}

	public Date getInterestEndTime() {
		return interestEndTime;
	}

	public void setInterestEndTime(Date interestEndTime) {
		this.interestEndTime = interestEndTime;
	}

	public String getShopName() {
		return shopName;
	}

	public void setShopName(String shopName) {
		this.shopName = shopName;
	}

	public String getContacts() {
		return contacts;
	}

	public void setContacts(String contacts) {
		this.contacts = contacts;
	}

	public String getShopAddress() {
		return shopAddress;
	}

	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}

	public String getProvinceNo() {
		return provinceNo;
	}

	public void setProvinceNo(String provinceNo) {
		this.provinceNo = provinceNo;
	}

	public String getCityNo() {
		return cityNo;
	}

	public void setCityNo(String cityNo) {
		this.cityNo = cityNo;
	}

	public String getTownNo() {
		return townNo;
	}

	public void setTownNo(String townNo) {
		this.townNo = townNo;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getYesOrNo() {
		return yesOrNo;
	}

	public void setYesOrNo(String yesOrNo) {
		this.yesOrNo = yesOrNo;
	}

	public String getFlowNodeResult() {
		return flowNodeResult;
	}

	public void setFlowNodeResult(String flowNodeResult) {
		this.flowNodeResult = flowNodeResult;
	}
 
	public String getApplyCode() {
		return applyCode;
	}

	public void setApplyCode(String applyCode) {
		this.applyCode = applyCode;
	}

	public String getTaskActionUserCode() {
		return taskActionUserCode;
	}

	public void setTaskActionUserCode(String taskActionUserCode) {
		this.taskActionUserCode = taskActionUserCode;
	}

	public String getErpFactoryCode() {
		return erpFactoryCode;
	}

	public void setErpFactoryCode(String erpFactoryCode) {
		this.erpFactoryCode = erpFactoryCode;
	}

	public String getErpVersionCode() {
		return erpVersionCode;
	}

	public void setErpVersionCode(String erpVersionCode) {
		this.erpVersionCode = erpVersionCode;
	}

	public String getCompanyCode() {
		return companyCode;
	}

	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	
}
