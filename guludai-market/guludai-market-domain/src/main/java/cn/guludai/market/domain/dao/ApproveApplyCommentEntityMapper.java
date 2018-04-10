/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.domain.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.guludai.market.domain.entity.ApproveApplyCommentEntity;

/**
 * @author gaopeng
 */
public interface ApproveApplyCommentEntityMapper {
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
	 *              {@link cn.guludai.market.domain.entity.ApproveApplyCommentEntity}
	 */
	int insert(ApproveApplyCommentEntity record);

	/**
	 * 插入数据库记录(仅仅插入非空属性)
	 * 
	 * @param record
	 *              {@link cn.guludai.market.domain.entity.ApproveApplyCommentEntity}
	 */
	int insertSelective(ApproveApplyCommentEntity record);

	/**
	 * 根据主键ID查询数据库记录
	 * 
	 * @param id
	 *              {@link java.lang.Long}
	 */
	ApproveApplyCommentEntity selectByPrimaryKey(Long id);

	/**
	 * 根据主键ID来更新数据库记录(仅仅修改非空属性)
	 * 
	 * @param record
	 *              {@link cn.guludai.market.domain.entity.ApproveApplyCommentEntity}
	 */
	int updateByPrimaryKeySelective(ApproveApplyCommentEntity record);

	/**
	 * @param record
	 *              {@link cn.guludai.market.domain.entity.ApproveApplyCommentEntity}
	 */
	int updateByPrimaryKeyWithBLOBs(ApproveApplyCommentEntity record);

	/**
	 * 根据主键ID更新数据库记录
	 * 
	 * @param record
	 *              {@link cn.guludai.market.domain.entity.ApproveApplyCommentEntity}
	 */
	int updateByPrimaryKey(ApproveApplyCommentEntity record);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月16日 下午4:45:17
	 * @Title: selectCommentsByApplyCode 
	 * @Description: 通过流水号查询备注信息
	 * @param applyCode 流水编号
	 *
	 */
	List<ApproveApplyCommentEntity> selectCommentsByApplyCode(String applyCode);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月24日 下午6:47:25
	 * @Title: selectTransactByApplyCodeAndNodeCode 
	 * @Description: 通过流水编号与节点编号查询批备
	 * @param applyCode 流水编号
	 * @param nodeCode 节点编号
	 * @return
	 *
	 */
	List<ApproveApplyCommentEntity> selectCommentByApplyCodeAndNodeCode(
			@Param("applyCode") String  applyCode,
			@Param("nodeCode") String nodeCode);
}