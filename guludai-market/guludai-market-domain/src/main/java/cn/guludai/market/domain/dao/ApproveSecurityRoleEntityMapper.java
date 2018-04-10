/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.domain.dao;

import java.util.List;

import cn.guludai.market.domain.entity.ApproveSecurityRoleEntity;
import cn.guludai.market.web.user.request.ApproveSecurityRoleEntityReq;

/**
 * 
 * @ClassName: ApproveSecurityRoleEntityMapper 
 * @Description: 角色
 * @author: xiongshikang
 * @date: 2017年12月12日 下午3:09:54
 */
public interface ApproveSecurityRoleEntityMapper {
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月12日 下午4:20:47
	 * @Title: selectProveSecurityResourceEntity 
	 * @Description: 查询角色
	 * @param record
	 * @return
	 *
	 */
	public List<ApproveSecurityRoleEntity> selectApproveSecurityRoleEntity(ApproveSecurityRoleEntityReq record);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月14日 上午11:45:23
	 * @Title: selectApproveSecurityRoleEntityCount 
	 * @Description: 分页总数
	 * @param record
	 * @return
	 *
	 */
	public Integer selectApproveSecurityRoleEntityCount(ApproveSecurityRoleEntityReq record);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月12日 下午5:14:09
	 * @Title: insert 
	 * @Description: 添加
	 * @param record
	 *
	 */
	public Integer insert(ApproveSecurityRoleEntity record);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月12日 下午5:32:39
	 * @Title: edit 
	 * @Description: 修改
	 * @param record
	 *
	 */
	public Integer edit(ApproveSecurityRoleEntity record);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月12日 下午5:52:00
	 * @Title: select 
	 * @Description: 通过角色编号查询资源
	 * @param resourceCode
	 * @return
	 *
	 */
	public ApproveSecurityRoleEntity select(String roleCode);
	
}