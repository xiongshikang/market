/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.service.user;

import cn.guludai.market.common.model.ResultModel;
import cn.guludai.market.domain.entity.ApproveSecurityRoleEntity;
import cn.guludai.market.web.response.TableResponse;
import cn.guludai.market.web.user.request.ApproveSecurityRoleEntityReq;
import cn.guludai.market.web.user.response.ApproveSecurityRoleEntityRep;
import cn.guludai.market.web.user.response.ZtreeResponse;

/**
 * 
 * @ClassName: ApproveSecurityRoleEntityMapper 
 * @Description: 角色服务类
 * @author: xiongshikang
 * @date: 2017年12月12日 下午3:09:54
 */
public interface ApproveSecurityRoleEntityService {
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月13日 下午6:35:25
	 * @Title: getRoleAll 
	 * @Description: 查询所有角色
	 * @param record
	 * @return
	 * @throws Exception
	 *
	 */
	public TableResponse<ApproveSecurityRoleEntityRep> getRoleAll(ApproveSecurityRoleEntityReq record) throws Exception;
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月13日 下午6:39:37
	 * @Title: insert 
	 * @Description: 添加角色
	 * @param req
	 * @return
	 * @throws Exception
	 *
	 */
	public ResultModel<String> insert(ApproveSecurityRoleEntityReq req) throws Exception;
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月13日 下午6:40:11
	 * @Title: edit 
	 * @Description: 修改角色
	 * @param record
	 * @return
	 * @throws Exception
	 *
	 */
	public ResultModel<String> edit(ApproveSecurityRoleEntityReq record) throws Exception;
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月13日 下午6:41:00
	 * @Title: select 
	 * @Description: 通过角色编号查询角色
	 * @param record
	 * @return
	 *
	 */
	public ResultModel<ApproveSecurityRoleEntityRep> select(ApproveSecurityRoleEntityReq record)throws Exception;
	
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月14日 下午6:53:51
	 * @Title: getzTreeAllForRole 
	 * @Description: 获取所有的角色tree
	 * @return
	 *
	 */
	public ResultModel<ZtreeResponse> getzTreeAllForRole(String userCode);

}