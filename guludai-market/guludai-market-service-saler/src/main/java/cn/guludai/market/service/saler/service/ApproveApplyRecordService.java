/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.service.saler.service;

import cn.guludai.api.data.Request;
import cn.guludai.market.api.saler.request.SalerRequest;
import cn.guludai.market.api.saler.response.FlowNodeModel;
import cn.guludai.market.common.model.ResultModel;
import cn.guludai.market.domain.entity.ApproveApplyRecordEntity;

/**
 * 
 * @ClassName: ApproveApplyRecordEntityService 
 * @Description: 申请审批进度记录表服务类
 * @author: xiongshikang
 * @date: 2017年11月29日 下午2:23:20
 */
public interface ApproveApplyRecordService {
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月29日 下午2:23:39
	 * @Title: add 
	 * @Description: 添加申请审批进度记录
	 * @param record
	 *
	 */
	public void add(ApproveApplyRecordEntity record);
	
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月30日 下午3:20:40
	 * @Title: updateApproveApplyRecordEntity 
	 * @Description: 添加进度节点
	 * @param flowNodeStatus 流程进度审批状态
	 * @param flowNodeResult 流程进度审批结果备注
	 * @param flowCode 流程编号
	 * @param applyCode 申请流水编号
	 * @param pid Activiti流程编号
	 * @param nodeCode 进度节点编号
	 *
	 */
	public void addApproveApplyRecordEntity(String flowNodeStatus,String flowNodeResult,
			String flowCode,String applyCode,String pid,String nodeCode,String userCode);
	
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月1日 下午1:51:13
	 * @Title: updateApplyShop 
	 * @Description: 
	 * @param applyCode 流水号
	 * @param approveResult 审批结果
	 * @param approveStatus 审批状态
	 *
	 */
	public void updateApplyShop(String applyCode,String approveResult,String approveStatus);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月7日 下午5:00:54
	 * @Title: queryFlowListByApplycodeForBS 
	 * @Description: 通过流水号，查找个各节点状态
	 * @param request
	 * @return
	 *
	 */
	public ResultModel<FlowNodeModel> queryFlowListByApplycodeForBS(Request<SalerRequest> request) throws Exception;
	
}
