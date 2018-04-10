/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.domain.dao;

import org.apache.ibatis.annotations.Param;

import cn.guludai.market.domain.entity.ApproveSecurityUserResourceEntity;

/**
 * 
 * @ClassName: ApproveSecurityUserResourceEntityMapper 
 * @Description: 用户资源关联mapper
 * @author: xiongshikang
 * @date: 2017年12月12日 下午3:10:24
 */
public interface ApproveSecurityUserResourceEntityMapper{
	
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月14日 下午3:42:39
	 * @Title: insert 
	 * @Description: 用户添加权限
	 * @param record
	 * @return
	 *
	 */
	Integer insert(ApproveSecurityUserResourceEntity record);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月14日 下午5:32:52
	 * @Title: selectUserResourceByResourceCodeAndUserCode 
	 * @Description: 通过资源编号与用户编号查询是否在存数据
	 * @param resourceCode 资源编号
	 * @param userCode 用户编号 
	 * @return
	 *
	 */
	Integer selectCountByResourceCodeAndUserCode(@Param("resourceCode")String resourceCode,@Param("userCode")String userCode);
	
	 /**
	  * 
	  * @author: xiongshikang
	  * @date: 2017年12月14日 下午5:33:48
	  * @Title: insertUserResource 
	  * @Description: 添加用户权限 
	  * @param resourceCode
	  * @param userCode
	  * @return
	  *
	  */
	Integer insertUserResource(@Param("resourceCode")String resourceCode,@Param("userCode")String userCode);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月14日 下午5:54:25
	 * @Title: deleteByUserCode 
	 * @Description: 通过用户编号册除权限
	 * @param userCode 用户编号
	 * @return
	 *
	 */
	Integer deleteByUserCode(String userCode);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月20日 下午4:29:38
	 * @Title: deleteUserResourceByResourceCode 
	 * @Description: 册除用户权限
	 * @param resourceCode 资源编号
	 * @return
	 *
	 */
	Integer deleteUserResourceByResourceCode(String resourceCode);
	
}