/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.domain.dao;

import java.util.List;

import cn.guludai.market.domain.entity.ApproveApplyTransactEntity;
import cn.guludai.market.web.request.ApproveApplyResultReq;

/**
 * @author gaopeng
 */
public interface ApproveApplyTransactEntityMapper {
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
	 *              {@link cn.guludai.market.domain.entity.ApproveApplyTransactEntity}
	 */
	int insert(ApproveApplyTransactEntity record);

	/**
	 * 插入数据库记录(仅仅插入非空属性)
	 * 
	 * @param record
	 *              {@link cn.guludai.market.domain.entity.ApproveApplyTransactEntity}
	 */
	int insertSelective(ApproveApplyTransactEntity record);

	/**
	 * 根据主键ID查询数据库记录
	 * 
	 * @param id
	 *              {@link java.lang.Long}
	 */
	ApproveApplyTransactEntity selectByPrimaryKey(Long id);

	/**
	 * 根据主键ID来更新数据库记录(仅仅修改非空属性)
	 * 
	 * @param record
	 *              {@link cn.guludai.market.domain.entity.ApproveApplyTransactEntity}
	 */
	int updateByPrimaryKeySelective(ApproveApplyTransactEntity record);

	/**
	 * @param record
	 *              {@link cn.guludai.market.domain.entity.ApproveApplyTransactEntity}
	 */
	int updateByPrimaryKeyWithBLOBs(ApproveApplyTransactEntity record);

	/**
	 * 根据主键ID更新数据库记录
	 * 
	 * @param record
	 *              {@link cn.guludai.market.domain.entity.ApproveApplyTransactEntity}
	 */
	int updateByPrimaryKey(ApproveApplyTransactEntity record);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月18日 下午5:20:45
	 * @Title: selectApplyTransactByActivitiCodeOne 
	 * @Description: 通过流程id查询办理或转交任务关联信息
	 * @param activitiCode 流程id
	 * @return
	 *
	 */
	ApproveApplyTransactEntity selectApplyTransactByActivitiCodeOne(String activitiCode);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月18日 下午6:16:18
	 * @Title: selectApplyRecordByUserCode 
	 * @Description: 通过用户编号分页查询个人办理过的历吏任务
	 * @param userCode 用户编号
	 * @return
	 *
	 */
	List<ApproveApplyTransactEntity> selectApplyTransacByUserCode(ApproveApplyResultReq model);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月18日 下午6:24:09
	 * @Title: selectApplyRecordByUserCodeCount 
	 * @Description: 通过用户编号分页查询个人办理过的历吏任务总数
	 * @param userCode 用户编号
	 * @return
	 *
	 */
	Integer selectApplyTransacByUserCodeCount(ApproveApplyResultReq model);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月19日 下午4:16:40
	 * @Title: selectApplyTransactByTransactCode 
	 * @Description: 通过编号查询办理或转交任务关联信息 
	 * @param transactCode 编号
	 * @return
	 *
	 */
	ApproveApplyTransactEntity selectApplyTransactByTransactCode(String transactCode);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年3月12日 下午7:00:34
	 * @Title: selectApproveApplyTransactByApplyCode 
	 * @Description: 通过流程编号获取流程备注信息
	 * @param applyCode
	 * @return
	 *
	 */
	List<ApproveApplyTransactEntity> selectApproveApplyTransactByApplyCode(String applyCode);
	
	
}