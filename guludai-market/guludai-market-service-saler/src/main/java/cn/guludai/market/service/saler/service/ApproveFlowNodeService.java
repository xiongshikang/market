/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.service.saler.service;

import cn.guludai.market.common.model.ResultModel;
import cn.guludai.market.web.request.ApproveFlowNodeReq;
import cn.guludai.market.web.response.ApproveFlowNodeResponse;
import cn.guludai.market.web.response.ApproveSecurityUserResponse;
import cn.guludai.market.web.response.TableResponse;
import cn.guludai.market.web.user.request.ZtreeRequest;
import cn.guludai.market.web.user.response.ZtreeResponse;

/**
 * 
 * @ClassName: ApproveFlowNodeService 
 * @Description: 任务节点服务类
 * @author: xiongshikang
 * @date: 2018年1月16日 下午5:05:52
 */
public interface ApproveFlowNodeService {
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月16日 下午5:18:48
	 * @Title: seletFlowNodeByFlowCode 
	 * @Description: 审批流程所有的节点
	 * @return
	 * @throws Exception
	 *
	 */
	public TableResponse<ApproveFlowNodeResponse> seletFlowNodeByFlowCode(ApproveFlowNodeReq request) throws Exception;
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月16日 下午6:44:26
	 * @Title: getzTreeForUserAndFlowNode 
	 * @Description: 通过节点编号查询分配的人员
	 * @param nodeCode 节点编号
	 * @return
	 *
	 */
	public ResultModel<ZtreeResponse> getzTreeForUserAndFlowNode(String nodeCode);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月16日 下午7:25:34
	 * @Title: setting 
	 * @Description: 设配节点可分配人员
	 * @param record
	 * @return
	 *
	 */
	public ResultModel<String> setting(ZtreeRequest record);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月16日 下午7:26:50
	 * @Title: selectUserByNodeCode 
	 * @Description: 通过节点编号查询节点点可操作人员
	 * @param nodeCode
	 * @return
	 *
	 */
	public ResultModel<ApproveSecurityUserResponse> selectUserByNodeCode(String nodeCode) throws Exception;
 
}
