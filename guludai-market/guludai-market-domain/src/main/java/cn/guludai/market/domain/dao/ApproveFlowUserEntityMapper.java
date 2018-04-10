/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.domain.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.guludai.market.domain.entity.ApproveFlowUserEntity;

/**
 * @author gaopeng
 */
public interface ApproveFlowUserEntityMapper {
	/**
	 * 根据主键ID删除数据库的记录
	 * 
	 * @param id
	 *              {@link java.lang.Long}
	 */
	int deleteByPrimaryKey(Long id);

	/**
	 * 插入数据库记录
	 * 
	 * @param record
	 *              {@link cn.guludai.market.domain.entity.ApproveFlowUserEntity}
	 */
	int insert(ApproveFlowUserEntity record);

	/**
	 * 插入数据库记录(仅仅插入非空属性)
	 * 
	 * @param record
	 *              {@link cn.guludai.market.domain.entity.ApproveFlowUserEntity}
	 */
	int insertSelective(ApproveFlowUserEntity record);

	/**
	 * 根据主键ID查询数据库记录
	 * 
	 * @param id
	 *              {@link java.lang.Long}
	 */
	ApproveFlowUserEntity selectByPrimaryKey(Long id);

	/**
	 * 根据主键ID来更新数据库记录(仅仅修改非空属性)
	 * 
	 * @param record
	 *              {@link cn.guludai.market.domain.entity.ApproveFlowUserEntity}
	 */
	int updateByPrimaryKeySelective(ApproveFlowUserEntity record);

	/**
	 * 根据主键ID更新数据库记录
	 * 
	 * @param record
	 *              {@link cn.guludai.market.domain.entity.ApproveFlowUserEntity}
	 */
	int updateByPrimaryKey(ApproveFlowUserEntity record);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月16日 下午6:33:55
	 * @Title: selectFlowUserByNodeCode 
	 * @Description: 通过节点编号查询分配的用户 
	 * @param nodeCode 节点编号
	 * @return
	 *
	 */
	List<ApproveFlowUserEntity> selectFlowUserByNodeCode(@Param("nodeCode")String nodeCode);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月16日 下午7:01:55
	 * @Title: deleteFlowUserByNodeCode 
	 * @Description: 通过节编号册除节点上分配的人员
	 * @param nodeCode 节点编号
	 *
	 */
	void deleteFlowUserByNodeCode(String nodeCode);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月16日 下午7:15:36
	 * @Title: selectFlowUserByUserCodeAndNodeCode 
	 * @Description: 通过节点编号与用户编号查询是否存在分配人员数据
	 * @param userCode 用户编号
	 * @param nodeCode 节点编号
	 * @return
	 *
	 */
	Integer selectFlowUserByUserCodeAndNodeCode(@Param("userCode")String userCode,@Param("nodeCode")String nodeCode);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月16日 下午7:22:01
	 * @Title: insertFlowUser 
	 * @Description: 修改成未册除状态 
	 * @param userCode 用户编号
	 * @param nodeCode 节点编号
	 *
	 */
	void insertFlowUser(@Param("userCode")String userCode,@Param("nodeCode")String nodeCode);
	
}