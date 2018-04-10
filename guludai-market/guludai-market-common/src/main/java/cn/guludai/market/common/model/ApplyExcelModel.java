/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.common.model;

import java.math.BigDecimal;

/**
 * 
 * @ClassName: ApplyExcelModel 
 * @Description: 查询及导出【销售人员及其销售月报】参数类
 * @author: xiongshikang
 * @date: 2018年1月2日 下午6:31:16
 */
public class ApplyExcelModel {
	
	/**
	 * 进行数
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
	 * 审批批款金额总和
	 */
    private BigDecimal loanMoneySum;
    
    /**
     * 实际放款金额总和
     */
    private BigDecimal loanActualMoneySum;
    
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
