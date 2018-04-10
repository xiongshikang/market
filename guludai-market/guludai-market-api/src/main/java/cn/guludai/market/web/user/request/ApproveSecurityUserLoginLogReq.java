/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.user.request;

import java.util.Date;

import cn.guludai.market.web.request.BaseReq;

/**
 * 
 * @ClassName: ApproveSecurityUserLoginLogReq 
 * @Description: 登录日志接参类
 * @author: xiongshikang
 * @date: 2018年2月27日 上午11:40:10
 */
public class ApproveSecurityUserLoginLogReq  extends BaseReq{

	/**
	 * @author: xiongshikang
	 * @date: 2018年2月27日 上午11:40:48
	 * @fieldName: serialVersionUID
	 * @fieldType: long
	 * @Description: 
	 */
	private static final long serialVersionUID = 1L;

    private String clientIp;

    private Date loginTime;

    private String userName;

	public String getClientIp() {
		return clientIp;
	}

	public void setClientIp(String clientIp) {
		this.clientIp = clientIp;
	}

	public Date getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(Date loginTime) {
		this.loginTime = loginTime;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
    
}
