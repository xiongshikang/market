/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.domain.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.guludai.market.domain.entity.ApproveSecurityResourceEntity;
import cn.guludai.market.web.user.request.ApproveSecurityResourceEntityReq;

/**
 * 
 * @ClassName: ApproveSecurityResourceEntityMapper 
 * @Description: 资源
 * @author: xiongshikang
 * @date: 2017年12月12日 下午3:09:40
 */
public interface ApproveSecurityResourceEntityMapper {
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月12日 下午4:20:47
	 * @Title: selectProveSecurityResourceEntity 
	 * @Description: 查询资源
	 * @param record
	 * @return
	 *
	 */
	public List<ApproveSecurityResourceEntity> selectProveSecurityResourceEntity(ApproveSecurityResourceEntityReq record);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月12日 下午5:14:09
	 * @Title: insert 
	 * @Description: 添加
	 * @param record
	 *
	 */
	public Integer insert(ApproveSecurityResourceEntity record);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月12日 下午5:32:39
	 * @Title: edit 
	 * @Description: 修改
	 * @param record
	 *
	 */
	public Integer edit(ApproveSecurityResourceEntity record);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月12日 下午5:52:00
	 * @Title: select 
	 * @Description: 通过资源编号查询资源
	 * @param resourceCode
	 * @return
	 *
	 */
	public ApproveSecurityResourceEntity select(String resourceCode);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月13日 下午12:03:07
	 * @Title: parentAll 
	 * @Description: 获取类型为 指定的（菜单类型）的数据
	 * @return
	 *
	 */
	public List<ApproveSecurityResourceEntity> resourceAllByResourceType(@Param("resourceType")Integer resourceType);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月13日 下午6:06:55
	 * @Title: getResourceByUserId 
	 * @Description: 通过用户编号查询用户所有资源 
	 * @param userCode 用户编号
	 * @param resourceType 资源类型
	 * @return
	 *
	 */
	List<ApproveSecurityResourceEntity> getResourceByUserCode(@Param("userCode")String userCode,@Param("resourceType")Integer resourceType);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月20日 下午4:21:15
	 * @Title: deleteResourceByResourceCode 
	 * @Description: 册除资源
	 * @param resourceCode 资源编号
	 * @return
	 *
	 */
	Integer deleteResourceByResourceCode(String resourceCode);
	
}