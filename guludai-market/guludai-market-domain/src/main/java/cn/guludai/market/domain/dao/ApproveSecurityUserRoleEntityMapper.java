/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.domain.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.guludai.market.domain.entity.ApproveSecurityUserRoleEntity;

/**
 * 
 * @ClassName: ApproveSecurityUserRoleEntityMapper 
 * @Description: 用户角色关联mapper
 * @author: xiongshikang
 * @date: 2017年12月12日 下午3:10:46
 */
public interface ApproveSecurityUserRoleEntityMapper {
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月15日 上午10:16:15
	 * @Title: insert 
	 * @Description: 添加
	 * @param record
	 * @return
	 *
	 */
	public Integer insert(ApproveSecurityUserRoleEntity record);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月15日 上午10:17:35
	 * @Title: selectCountByRoleCodeAndUserCode 
	 * @Description: 通过角色编号与用户编号查询是否在存数据
	 * @param role_code 角色编号
	 * @param userCode 用户编号
	 * @return
	 *
	 */
	public Integer selectCountByRoleCodeAndUserCode(@Param("roleCode")String role_code,@Param("userCode")String userCode);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月15日 上午10:18:37
	 * @Title: insertUserRole 
	 * @Description: 添加用户角色 
	 * @param role_code 角色编号
	 * @param userCode 用户编号
	 * @return
	 *
	 */
	public Integer insertUserRole(@Param("roleCode")String role_code,@Param("userCode")String userCode);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月15日 上午10:19:37
	 * @Title: deleteByUserCode 
	 * @Description: 通过用户编号册除角色权限
	 * @param userCode 用户编号
	 * @return
	 *
	 */
	public Integer deleteByUserCode(String userCode);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月15日 上午11:31:38
	 * @Title: selectUserRoleByUserCode 
	 * @Description: 
	 * @return
	 *
	 */
	public List<ApproveSecurityUserRoleEntity> selectUserRoleByUserCode(String userCode);
	
}