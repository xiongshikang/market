/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.domain.dao;

import java.util.List;

import cn.guludai.market.domain.entity.ApproveApplyResultEntity;
import cn.guludai.market.web.request.ApproveApplyResultReq;
import org.apache.ibatis.annotations.Param;

/**
 * @author gaopeng
 */
public interface ApproveApplyResultEntityMapper {
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
	 *              {@link cn.guludai.market.domain.entity.ApproveApplyResultEntity}
	 */
	int insert(ApproveApplyResultEntity record);

	/**
	 * 插入数据库记录(仅仅插入非空属性)
	 * 
	 * @param record
	 *              {@link cn.guludai.market.domain.entity.ApproveApplyResultEntity}
	 */
	int insertSelective(ApproveApplyResultEntity record);

	/**
	 * 根据主键ID查询数据库记录
	 * 
	 * @param id
	 *              {@link java.lang.Long}
	 */
	ApproveApplyResultEntity selectByPrimaryKey(Long id);

	/**
	 * 根据主键ID来更新数据库记录(仅仅修改非空属性)
	 * 
	 * @param record
	 *              {@link cn.guludai.market.domain.entity.ApproveApplyResultEntity}
	 */
	int updateByPrimaryKeySelective(ApproveApplyResultEntity record);

	/**
	 * 根据主键ID更新数据库记录
	 * 
	 * @param record
	 *              {@link cn.guludai.market.domain.entity.ApproveApplyResultEntity}
	 */
	int updateByPrimaryKey(ApproveApplyResultEntity record);
	
	
	void updateApplyResultByApplyCode(ApproveApplyResultEntity applyResultEntity);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月27日 下午2:22:54
	 * @Title: selectApplyResultList 
	 * @Description: 查询申请审批数据
	 * @param recod
	 * @return
	 *
	 */
	List<ApproveApplyResultEntity >selectApplyResultList(ApproveApplyResultReq record);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月27日 下午2:23:38
	 * @Title: selectApplyResultListCount 
	 * @Description: 查询申请审批数据总数
	 * @param recod
	 * @return
	 *
	 */
	Integer selectApplyResultListCount(ApproveApplyResultReq record);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月28日 上午10:38:13
	 * @Title: updateByApplyCode 
	 * @Description: 更新 申请审批信息
	 * @param record
	 * @return
	 *
	 */
	void updateByApplyCode(ApproveApplyResultEntity record);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月28日 上午10:40:03
	 * @Title: selectApproveApplyResultByApplyCode 
	 * @Description: 通过流水号查询申请信息
	 * @param applyCode 流水号
	 * @return
	 *
	 */
	ApproveApplyResultEntity selectApproveApplyResultByApplyCode(@Param("applyCode") String applyCode);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月24日 下午2:17:49
	 * @Title: selectNodeInfoByNodeCodePage 
	 * @Description: 通过节点编号查询当前节点分页数据 
	 * @param nodeCode 节点编号
	 * @return
	 *
	 */
	List<ApproveApplyResultEntity> selectNodeInfoByNodeCodePage(ApproveApplyResultReq record);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月24日 下午2:18:14
	 * @Title: selectNodeInfoByNodeCodePageCount 
	 * @Description: 通过节点编号查询当前节点分页总数
	 * @param nodeCode 节点编号
	 * @return
	 *
	 */
	Integer selectNodeInfoByNodeCodePageCount(ApproveApplyResultReq record);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月24日 下午3:19:24
	 * @Title: selectNodeInfoForResultIsNo 
	 * @Description: 通过节点编号查询被拒绝节点分页数据
	 * @param record
	 * @return
	 *
	 */
	List<ApproveApplyResultEntity> selectNodeInfoForResultIsNo(ApproveApplyResultReq record);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月24日 下午3:19:58
	 * @Title: selectNodeInfoForResultIsNoCount 
	 * @Description: 通过节点编号查询被拒绝节点分页数据总数 
	 * @param record
	 * @return
	 *
	 */
	Integer selectNodeInfoForResultIsNoCount(ApproveApplyResultReq record);
	
}