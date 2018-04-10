/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.domain.dao;

import org.apache.ibatis.annotations.Param;

import cn.guludai.market.domain.entity.ApproveFlowEntity;

/**
 * @author gaopeng
 */
public interface ApproveFlowEntityMapper {
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
	 *              {@link cn.guludai.market.domain.entity.ApproveFlowEntity}
	 */
	int insert(ApproveFlowEntity record);

	/**
	 * 插入数据库记录(仅仅插入非空属性)
	 * 
	 * @param record
	 *              {@link cn.guludai.market.domain.entity.ApproveFlowEntity}
	 */
	int insertSelective(ApproveFlowEntity record);

	/**
	 * 根据主键ID查询数据库记录
	 * 
	 * @param id
	 *              {@link java.lang.Long}
	 */
	ApproveFlowEntity selectByPrimaryKey(Long id);

	/**
	 * 根据主键ID来更新数据库记录(仅仅修改非空属性)
	 * 
	 * @param record
	 *              {@link cn.guludai.market.domain.entity.ApproveFlowEntity}
	 */
	int updateByPrimaryKeySelective(ApproveFlowEntity record);

	/**
	 * 根据主键ID更新数据库记录
	 * 
	 * @param record
	 *              {@link cn.guludai.market.domain.entity.ApproveFlowEntity}
	 */
	int updateByPrimaryKey(ApproveFlowEntity record);

	/**
	 * 根据类型查询可用的审批流程
	 * 
	 * @param flowType
	 *              流程类型常量
	 * @return
	 */
	ApproveFlowEntity selectFlowByStatus(@Param(value = "flowType") String flowType);
}