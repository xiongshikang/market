/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.service.user;

import java.util.List;

import cn.guludai.market.common.model.ResultModel;
import cn.guludai.market.web.user.request.ApproveSecurityResourceEntityReq;
import cn.guludai.market.web.user.response.ApproveSecurityResourceEntityRep;
import cn.guludai.market.web.user.response.MenuTree;
import cn.guludai.market.web.user.response.ZtreeResponse;

/**
 * 
 * @ClassName: ApproveSecurityResourceEntityMapper 
 * @Description: 资源服务类
 * @author: xiongshikang
 * @date: 2017年12月12日 下午3:09:40
 */
public interface ApproveSecurityResourceEntityService {
	
	/**
	 * @author: xiongshikang
	 * @date: 2017年12月12日 下午4:56:35
	 * @Title: getResourceAll 
	 * @Description: 多条件查找资源数据
	 * @param record
	 * @return
	 *
	 */
	public ResultModel<ApproveSecurityResourceEntityRep> getResourceAll(ApproveSecurityResourceEntityReq record)throws Exception ;
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月12日 下午5:23:38
	 * @Title: insert 
	 * @Description: 添加资源
	 * @param record
	 * @return
	 *
	 */
	public ResultModel<String> insert(ApproveSecurityResourceEntityReq record)throws Exception; 
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月12日 下午5:43:01
	 * @Title: edit 
	 * @Description: 修改
	 * @param record
	 * @return
	 * @throws Exception
	 *
	 */
	public ResultModel<String> edit(ApproveSecurityResourceEntityReq record) throws Exception;
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月12日 下午5:48:47
	 * @Title: select 
	 * @Description: 通过编号查询资源
	 * @param record
	 * @return
	 *
	 */
	public ResultModel<ApproveSecurityResourceEntityRep> select(ApproveSecurityResourceEntityReq record)throws Exception;
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月13日 上午11:59:32
	 * @Title: parentAll 
	 * @Description: 获取类型为 1（菜单类型）的数据
	 * @return
	 *
	 */
	public ResultModel<ApproveSecurityResourceEntityRep> parentAll()throws Exception;
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月14日 下午2:42:16
	 * @Title: getzTreeAll 
	 * @Description: 权限树--角色
	 * @Param roleCode 角色编号
	 * @return
	 *
	 */
	public ResultModel<ZtreeResponse> getzTreeAll(String roleCode);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月14日 下午5:48:30
	 * @Title: getzTreeAllForUser 
	 * @Description: 权限树--用户
	 * @param userCode
	 * @return
	 *
	 */
	public ResultModel<ZtreeResponse> getzTreeAllForUser(String userCode);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月15日 下午2:28:57
	 * @Title: getMeun 
	 * @Description: 菜单
	 * @param userCode 用户编号
	 * @return
	 *
	 */
	public List<MenuTree> getMeun(String userCode);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月20日 下午4:31:48
	 * @Title: deleteResourceByCode 
	 * @Description: 册除权限，册除关联人员
	 * @param resourceCode
	 *
	 */
	public ResultModel<String> deleteResourceByCode(String resourceCode);
	
	
}