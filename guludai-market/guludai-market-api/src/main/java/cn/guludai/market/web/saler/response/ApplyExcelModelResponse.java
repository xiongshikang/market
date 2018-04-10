/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.saler.response;

import java.math.BigDecimal;
import java.util.List;

/**
 * 
 * @ClassName: ApplyExcelModel 
 * @Description: 查询及导出【销售人员及其销售月报】参数类
 * @author: xiongshikang
 * @date: 2018年1月2日 下午6:31:16
 */
public class ApplyExcelModelResponse {
	
	/**
	 * 父节点
	 */
	private String parentAccount;
	
	/**
	 * 子节点
	 */
	private String account;
	
	/**
	 * 父节点描述
	 */
	private String parentDes;
	
	/**
	 * 子节点描述
	 */
	private String childrenDes;
	
	/**
	 * 进件数
	 */
	private int applyCount;
	
	/**
	 * 成交数
	 */
	private int dealCount;
	
	/**
	 * 拒绝件数
	 */
	private int refuseCount;
	
	/**
	 * 审查中件数
	 */
	private int HaveInHandCount;
	
	/**
	 * 审批批款金额
	 */
	private BigDecimal loanMoneySum ;
	 /**
     * 实际放款金额
     */
	private BigDecimal loanActualMoneySum ;
	
	/**
	 * 用户名
	 */
	private String name;
	/**
	 * 用户手机号
	 */
	private String mobile;
	
	/**
	 * 一级下线
	 */
	private List<ApplyExcelModelResponse> spplyExcelModelResponses;
	
	public String getParentAccount() {
		return parentAccount;
	}

	public void setParentAccount(String parentAccount) {
		this.parentAccount = parentAccount;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getParentDes() {
		return parentDes;
	}

	public void setParentDes(String parentDes) {
		this.parentDes = parentDes;
	}

	public String getChildrenDes() {
		return childrenDes;
	}

	public void setChildrenDes(String childrenDes) {
		this.childrenDes = childrenDes;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public List<ApplyExcelModelResponse> getSpplyExcelModelResponses() {
		return spplyExcelModelResponses;
	}

	public void setSpplyExcelModelResponses(List<ApplyExcelModelResponse> spplyExcelModelResponses) {
		this.spplyExcelModelResponses = spplyExcelModelResponses;
	}

	public BigDecimal getLoanMoneySum() {
		return loanMoneySum;
	}

	public void setLoanMoneySum(BigDecimal loanMoneySum) {
		this.loanMoneySum = loanMoneySum;
	}

	public BigDecimal getLoanActualMoneySum() {
		return loanActualMoneySum;
	}

	public void setLoanActualMoneySum(BigDecimal loanActualMoneySum) {
		this.loanActualMoneySum = loanActualMoneySum;
	}

	public int getApplyCount() {
		return applyCount;
	}

	public void setApplyCount(int applyCount) {
		this.applyCount = applyCount;
	}

	public int getDealCount() {
		return dealCount;
	}

	public void setDealCount(int dealCount) {
		this.dealCount = dealCount;
	}

	public int getRefuseCount() {
		return refuseCount;
	}

	public void setRefuseCount(int refuseCount) {
		this.refuseCount = refuseCount;
	}

	public int getHaveInHandCount() {
		return HaveInHandCount;
	}

	public void setHaveInHandCount(int haveInHandCount) {
		HaveInHandCount = haveInHandCount;
	}
	
	
}
