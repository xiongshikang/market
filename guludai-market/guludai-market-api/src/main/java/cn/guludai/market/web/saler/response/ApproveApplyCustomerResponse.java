/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.saler.response;
/**
 * 
 * @ClassName: ApproveApplyCustomerResponse 
 * @Description: 申请审批客户信息展示类
 * @author: xiongshikang
 * @date: 2018年1月6日 下午1:27:54
 */
public class ApproveApplyCustomerResponse {
	
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

	public String getCustomerCode() {
		return customerCode;
	}

	public void setCustomerCode(String customerCode) {
		this.customerCode = customerCode;
	}

	public String getCustomerIdcard() {
		return customerIdcard;
	}

	public void setCustomerIdcard(String customerIdcard) {
		this.customerIdcard = customerIdcard;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
}


