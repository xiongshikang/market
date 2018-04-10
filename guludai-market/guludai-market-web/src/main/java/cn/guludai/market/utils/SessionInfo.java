/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.utils;

import java.io.Serializable;

import cn.guludai.market.domain.entity.ApproveSecurityUser;


/**
 * sessionInfo模型，只要登录成功，就需要设置到session里面，便于系统使用
 * 
 * @author xsk
 * 不做为数据库表
 * 
 */

public class SessionInfo implements Serializable  {

	private static final long serialVersionUID = 1L;
	
	private ApproveSecurityUser user;

	public ApproveSecurityUser getUser() {
		return user;
	}

	public void setUser(ApproveSecurityUser user) {
		this.user = user;
	}

	 

}
