/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.saler.response;

/**
 * @ClassName: BaseShopCompanyResp
 * @Description: 公司列表展示类
 * @author: xiongshikang
 * @date: 2017年12月21日 下午1:54:05
 */
public class BaseShopCompanyResp {
	private String companyCode;
	
	private String companyName;
	// 企业地址
	private String address;
	// 联系电话
	private String phone;
	// 企业邮箱
	private String mail;

	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public String getCompanyCode() {
		return companyCode;
	}
	public void setCompanyCode(String companyCode) {
		this.companyCode = companyCode;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
}
