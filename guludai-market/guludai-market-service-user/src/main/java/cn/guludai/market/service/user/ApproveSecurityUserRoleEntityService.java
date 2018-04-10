/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.service.user;

import cn.guludai.market.common.model.ResultModel;
import cn.guludai.market.web.user.request.ZtreeRequest;

/**
 * 
 * @ClassName: ApproveSecurityUserRoleEntityMapper 
 * @Description: 用户角色关联服务类
 * @author: xiongshikang
 * @date: 2017年12月12日 下午3:10:46
 */
public interface ApproveSecurityUserRoleEntityService {
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月15日 上午10:22:24
	 * @Title: settingRoleUser 
	 * @Description: 设置用户角色
	 * @param record
	 * @return
	 *
	 */
	public ResultModel<String> settingRoleUser(ZtreeRequest record) ;
	
}