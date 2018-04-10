/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.domain.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.guludai.market.domain.entity.ApproveSecurityRoleResourceEntity;

/**
 * 
 * @ClassName: ApproveSecurityRoleResourceEntityMapper 
 * @Description: 角色资源
 * @author: xiongshikang
 * @date: 2017年12月12日 下午3:10:10
 */
public interface ApproveSecurityRoleResourceEntityMapper{
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月14日 下午3:42:39
	 * @Title: insert 
	 * @Description: 角色添加权限
	 * @param record
	 * @return
	 *
	 */
	Integer insert(ApproveSecurityRoleResourceEntity record);
	
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月14日 下午3:41:34
	 * @Title: deleteByRoleCode 
	 * @Description: 通过角色编号册除角色权限
	 * @param roleCode 角色编号
	 * @return
	 *
	 */
	Integer deleteByRoleCode(String roleCode);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月14日 下午5:11:31
	 * @Title: insertRoleResource 
	 * @Description:添加权限 
	 * @param resourceCode 资源编号
	 * @param roleCode 角色编号
	 * @return
	 *
	 */
	Integer insertRoleResource(@Param("resourceCode")String resourceCode,@Param("roleCode")String roleCode);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月14日 下午5:12:46
	 * @Title: selectRoleResourceByResourceCodeAndRoleCode 
	 * @Description: 添加权限 
	 * @param resourceCode 资源编号
	 * @param roleCode 角色编号
	 * @return
	 *
	 */
	Integer selectRoleResourceByResourceCodeAndRoleCode(@Param("resourceCode")String resourceCode,@Param("roleCode")String roleCode);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月14日 下午3:00:31
	 * @Title: getRoleResourcesByRocleCode 
	 * @Description: 通过角色编号，获取角色的资源
	 * @param roleCode 角色编号
	 * @return
	 *
	 */
	List<ApproveSecurityRoleResourceEntity> getRoleResourcesByRocleCode(String roleCode);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月20日 下午4:24:24
	 * @Title: deleteResourceByResourceCode 
	 * @Description: 通过资源编号逻辑册除角色权限
	 * @param roleCode 资源编号
	 * @return
	 *
	 */
	Integer deleteRoleResourceByResourceCode(String resourceCode);
	
}