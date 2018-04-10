/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.domain.dao;

import java.util.List;

import cn.guludai.market.domain.entity.ApproveApplyCustomerEntity;

/**
 * @author gaopeng
 */
public interface ApproveApplyCustomerEntityMapper {
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
	 *              {@link cn.guludai.market.domain.entity.ApproveApplyCustomerEntity}
	 */
	int insert(ApproveApplyCustomerEntity record);

	/**
	 * 插入数据库记录(仅仅插入非空属性)
	 * 
	 * @param record
	 *              {@link cn.guludai.market.domain.entity.ApproveApplyCustomerEntity}
	 */
	int insertSelective(ApproveApplyCustomerEntity record);

	/**
	 * 根据主键ID查询数据库记录
	 * 
	 * @param id
	 *              {@link java.lang.Long}
	 */
	ApproveApplyCustomerEntity selectByPrimaryKey(Long id);

	/**
	 * 根据主键ID来更新数据库记录(仅仅修改非空属性)
	 * 
	 * @param record
	 *              {@link cn.guludai.market.domain.entity.ApproveApplyCustomerEntity}
	 */
	int updateByPrimaryKeySelective(ApproveApplyCustomerEntity record);

	/**
	 * 根据主键ID更新数据库记录
	 * 
	 * @param record
	 *              {@link cn.guludai.market.domain.entity.ApproveApplyCustomerEntity}
	 */
	int updateByPrimaryKey(ApproveApplyCustomerEntity record);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月2日 下午4:57:30
	 * @Title: selectApplyCustomerByApplyCode 
	 * @Description: 通过身份证号查找申请审批客户信息
	 * @param customerIdcard 身份证号
	 * @return
	 *
	 */
	List<ApproveApplyCustomerEntity> selectApplyCustomerByCustomerIdcard(String customerIdcard);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月6日 下午1:19:46
	 * @Title: selectApplyCustomerByApplyCode 
	 * @Description: 通过流水编号查询申请审批客户信息 
	 * @param applyCode 流水编号
	 * @return
	 *
	 */
	List<ApproveApplyCustomerEntity> selectApplyCustomerByApplyCode(String applyCode);
	
}