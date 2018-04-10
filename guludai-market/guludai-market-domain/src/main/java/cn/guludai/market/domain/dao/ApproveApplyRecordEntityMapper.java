/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.domain.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.guludai.market.api.saler.response.FlowNodeModel;
import cn.guludai.market.domain.entity.ApproveApplyRecordEntity;

/**
 * @author gaopeng
 */
public interface ApproveApplyRecordEntityMapper {
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
	 *              {@link cn.guludai.market.domain.entity.ApproveApplyRecordEntity}
	 */
	int insert(ApproveApplyRecordEntity record);

	/**
	 * 插入数据库记录(仅仅插入非空属性)
	 * 
	 * @param record
	 *              {@link cn.guludai.market.domain.entity.ApproveApplyRecordEntity}
	 */
	int insertSelective(ApproveApplyRecordEntity record);

	/**
	 * 根据主键ID查询数据库记录
	 * 
	 * @param id
	 *              {@link java.lang.Long}
	 */
	ApproveApplyRecordEntity selectByPrimaryKey(Long id);

	/**
	 * 根据主键ID来更新数据库记录(仅仅修改非空属性)
	 * 
	 * @param record
	 *              {@link cn.guludai.market.domain.entity.ApproveApplyRecordEntity}
	 */
	int updateByPrimaryKeySelective(ApproveApplyRecordEntity record);

	/**
	 * 根据主键ID更新数据库记录
	 * 
	 * @param record
	 *              {@link cn.guludai.market.domain.entity.ApproveApplyRecordEntity}
	 */
	int updateByPrimaryKey(ApproveApplyRecordEntity record);

	/**
	 * 
	 * @author: nijichao
	 * @date: 2017年11月10日 下午5:22:42
	 * @Title: selectByflowCode
	 * @Description: 根据flowCode查询applyCode
	 * @param flowCode
	 * @return
	 *
	 */
	ApproveApplyRecordEntity selectByflowCode(@Param(value = "flowCode") String flowCode);

	/**
	 * 
	 * @author: nijichao
	 * @date: 2017年11月12日 下午7:53:02
	 * @Title: updateByFlowCode
	 * @Description: 根据FlowCode更新ApproveApplyRecordEntity
	 * @param record
	 * @return
	 *
	 */
	int updateByFlowCode(ApproveApplyRecordEntity record);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月22日 下午7:06:49
	 * @Title: selectApproveApplyRecordByApplyCode 
	 * @Description: 通过申请流水编号查找申请审批结果（有多条）
	 * @param 申请流水编号
	 * @return
	 *
	 */
	List<ApproveApplyRecordEntity> selectApproveApplyRecordByApplyCode(String applyCode);
    /**
     *
     * @author: xiongshikang
     * @date: 2017年11月22日 下午7:06:49
     * @Title: selectApproveApplyRecordByApplyCode
     * @Description: 通过申请流水编号查找申请审批结果（有一条）
     * @param
     * @return
     *
     */
	FlowNodeModel queryApplyRecordByApplyCode(String applyCode);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月19日 下午12:10:04
	 * @Title: selectApproveApplyRecordByNodeCodeAndActivitiCode 
	 * @Description: 通过节点编号与流程编号查找节点信息
	 * @param nodeCode 节点编号
	 * @param activitiCode 流程编号
	 * @return
	 *
	 */
	ApproveApplyRecordEntity selectApproveApplyRecordByNodeCodeAndActivitiCode(@Param("nodeCode")String nodeCode,@Param("activitiCode")String activitiCode);
	
}