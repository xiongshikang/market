/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.service.user;

import cn.guludai.market.common.model.ResultModel;
import cn.guludai.market.web.user.request.ZtreeRequest;

/**
 * 
 * @ClassName: ApproveSecurityRoleResourceEntityMapper 
 * @Description: 角色资源服务类
 * @author: xiongshikang
 * @date: 2017年12月12日 下午3:10:10
 */
public interface ApproveSecurityRoleResourceEntityService{
	
	ResultModel<String> settingRoleResources(ZtreeRequest record);
}