/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.user.request;

import cn.guludai.market.web.request.BaseReq;

/**
 * 
 * @ClassName: ApproveSecurityUserReq 
 * @Description: 管理员传参类
 * @author: xiongshikang
 * @date: 2017年11月27日 下午2:38:50
 */
public class ApproveSecurityUserReq extends BaseReq{

	/**
	 * @author: xiongshikang
	 * @date: 2017年12月18日 下午2:43:46
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: 
	 */
	private static final long serialVersionUID = 1L;

	/**'用户编号'*/
	private String userCode ;

	  /**
     * 管理员名称
     */
    private String userName;

    /**
     * 用户密码
     */
    private String password;


	/**'盐值'*/
	private String salt ;


	/**邮箱'*/
	private String email ;


	/**性别'*/
	private String sex ;


	/**'联系电话'*/
	private String phone ;


	/**联系地址'*/
	private String address ;


	/**'上级用户编号'*/
	private String parentCode ;


	/**
	 * 页面大小
	 */
	private int limit;

	/**
	 * 页码
	 */
	private int offset;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getSalt() {
		return salt;
	}

	public void setSalt(String salt) {
		this.salt = salt;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getParentCode() {
		return parentCode;
	}

	public void setParentCode(String parentCode) {
		this.parentCode = parentCode;
	}

	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}
}

