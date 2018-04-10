/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.service.user;

import cn.guludai.market.common.model.ResultModel;
import cn.guludai.market.web.user.request.ZtreeRequest;

/**
 * 
 * @ClassName: ApproveSecurityUserResourceEntityMapper 
 * @Description: 用户资源关联服务类
 * @author: xiongshikang
 * @date: 2017年12月12日 下午3:10:24
 */
public interface ApproveSecurityUserResourceEntityService{
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月14日 下午5:59:01
	 * @Title: settingUserResources 
	 * @Description: 添加用户权限  （用户与资源的中间表）
	 * @param record
	 * @return
	 *
	 */
	public ResultModel<String> settingUserResources(ZtreeRequest record);
}