/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.domain.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import cn.guludai.market.domain.entity.ApproveFlowNodeEntity;
import cn.guludai.market.web.request.ApproveFlowNodeReq;

/**
 * @author gaopeng
 */
public interface ApproveFlowNodeEntityMapper {
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
	 *              {@link cn.guludai.market.domain.entity.ApproveFlowNodeEntity}
	 */
	int insert(ApproveFlowNodeEntity record);

	/**
	 * 插入数据库记录(仅仅插入非空属性)
	 * 
	 * @param record
	 *              {@link cn.guludai.market.domain.entity.ApproveFlowNodeEntity}
	 */
	int insertSelective(ApproveFlowNodeEntity record);

	/**
	 * 根据主键ID查询数据库记录
	 * 
	 * @param id
	 *              {@link java.lang.Long}
	 */
	ApproveFlowNodeEntity selectByPrimaryKey(Long id);

	/**
	 * 根据主键ID来更新数据库记录(仅仅修改非空属性)
	 * 
	 * @param record
	 *              {@link cn.guludai.market.domain.entity.ApproveFlowNodeEntity}
	 */
	int updateByPrimaryKeySelective(ApproveFlowNodeEntity record);

	/**
	 * 根据主键ID更新数据库记录
	 * 
	 * @param record
	 *              {@link cn.guludai.market.domain.entity.ApproveFlowNodeEntity}
	 */
	int updateByPrimaryKey(ApproveFlowNodeEntity record);

	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月22日 下午7:01:00
	 * @Title: selectApproveFlowNodeByFlowCode
	 * @Description: 通过流程编号查找审批进度基础数据
	 * @param flowCode
	 *              申请流水编号
	 * @return
	 *
	 */
	List<ApproveFlowNodeEntity> selectApproveFlowNodeByFlowCode(String flowCode);

	/**
	 * 根据流程编号查询流程根进度节点
	 * 
	 * @param flowCode
	 *              流程编号
	 * @return
	 */
	ApproveFlowNodeEntity selectRootNodeByFlowCode(@Param(value = "flowCode") String flowCode);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月16日 下午5:13:14
	 * @Title: selectFlowNodeByFlowCode 
	 * @Description: 通过 流程编号查询流程节点 
	 * @param flowCode 流程编号
	 * @return
	 *
	 */
	List<ApproveFlowNodeEntity> selectFlowNodeByFlowCode(ApproveFlowNodeReq request);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月16日 下午5:29:18
	 * @Title: selectFlowNodeByFlowCodeCount 
	 * @Description: 分页总数
	 * @param flowCode 流程编号
	 *
	 */
	Integer selectFlowNodeByFlowCodeCount(ApproveFlowNodeReq request);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月17日 下午6:26:00
	 * @Title: selectApplyRecordByNodeCode 
	 * @Description: 通过节点编号查询节点信息
	 * @param nodeCode 节点编号
	 * @return
	 *
	 */
	ApproveFlowNodeEntity selectApplyFlowNodeByNodeCode(String nodeCode);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年3月12日 下午1:47:50
	 * @Title: selectApplyFlowNodeByNodeParentCode 
	 * @Description: 通过父节点编号找查子节点信息
	 * @param nodeParentCode
	 *
	 */
	ApproveFlowNodeEntity selectApplyFlowNodeByNodeParentCode(String nodeParentCode);
	
}