/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.domain.dao;

import cn.guludai.market.domain.entity.ApproveApplyLoanEntity;

/**
 * @author gaopeng
 */
public interface ApproveApplyLoanEntityMapper {
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
	 *              {@link cn.guludai.market.domain.entity.ApproveApplyLoanEntity}
	 */
	int insert(ApproveApplyLoanEntity record);

	/**
	 * 插入数据库记录(仅仅插入非空属性)
	 * 
	 * @param record
	 *              {@link cn.guludai.market.domain.entity.ApproveApplyLoanEntity}
	 */
	int insertSelective(ApproveApplyLoanEntity record);

	/**
	 * 根据主键ID查询数据库记录
	 * 
	 * @param id
	 *              {@link java.lang.Long}
	 */
	ApproveApplyLoanEntity selectByPrimaryKey(Long id);

	/**
	 * 根据主键ID来更新数据库记录(仅仅修改非空属性)
	 * 
	 * @param record
	 *              {@link cn.guludai.market.domain.entity.ApproveApplyLoanEntity}
	 */
	int updateByPrimaryKeySelective(ApproveApplyLoanEntity record);

	/**
	 * 根据主键ID更新数据库记录
	 * 
	 * @param record
	 *              {@link cn.guludai.market.domain.entity.ApproveApplyLoanEntity}
	 */
	int updateByPrimaryKey(ApproveApplyLoanEntity record);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月30日 下午2:35:05
	 * @Title: deleteByLoanCode 
	 * @Description: 册除
	 * @param loanCode
	 * @return
	 *
	 */
	Integer deleteByLoanCode(String loanCode);
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月2日 下午3:26:28
	 * @Title: selectApplyLoanApplyCode 
	 * @Description: 通过流水号查询审批放款信息
	 * @param applyCode 流水单号
	 * @return
	 *
	 */
	ApproveApplyLoanEntity selectApplyLoanApplyCode(String applyCode);
}