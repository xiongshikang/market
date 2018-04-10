/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.service.user;

import cn.guludai.market.domain.entity.ApproveSecurityUserLoginLogEntity;

/**
 * 
 * @ClassName: ApproveSecurityUserLoginLogService 
 * @Description: 用户登录日志记录表
 * @author: xiongshikang
 * @date: 2018年2月27日 上午11:34:48
 */
public interface ApproveSecurityUserLoginLogService {
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年2月27日 上午11:35:26
	 * @Title: add 
	 * @Description: 添加用户登录记录日志
	 *
	 */
	public void add(ApproveSecurityUserLoginLogEntity entity);
}
