/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.saler;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cn.guludai.api.data.Request;
import cn.guludai.api.data.Response;
import cn.guludai.market.api.saler.request.SalerRequest;
import cn.guludai.market.api.saler.response.FlowNodeModel;
import cn.guludai.market.web.request.ApproveApplyResultReq;
import cn.guludai.market.web.request.ApproveFlowNodeReq;
import cn.guludai.market.web.response.ApproveApplyResultResponse;
import cn.guludai.market.web.response.ApproveFlowNodeResponse;
import cn.guludai.market.web.response.ApproveSecurityUserResponse;
import cn.guludai.market.web.response.TableResponse;
import cn.guludai.market.web.user.request.ZtreeRequest;
import cn.guludai.market.web.user.response.ZtreeResponse;

/**
 * 
 * @ClassName: ApproveFlowNodeWeb 
 * @Description: 流程节点控制器
 * @author: xiongshikang
 * @date: 2018年1月16日 下午5:24:04
 */
public interface ApproveFlowNodeWeb {
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月16日 下午5:40:40
	 * @Title: list 
	 * @Description: 节点列表
	 * @param request
	 * @return
	 *
	 */
	@PostMapping("/web/approveFlowNode/list")
	public TableResponse<ApproveFlowNodeResponse> list(Request<ApproveFlowNodeReq> request);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月16日 下午6:23:43
	 * @Title: zTree 
	 * @Description: 用户树
	 * @param request
	 * @return
	 *
	 */
	@PostMapping("/web/approveFlowNode/zTree")
	public Response<ZtreeResponse> zTree(Request<String> request);
	
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月16日 下午6:50:36
	 * @Title: setting 
	 * @Description: 设置节点人员
	 * @param request
	 * @return
	 *
	 */
	@PostMapping("/web/approveFlowNode/setting")
	public Response<String> setting(Request<ZtreeRequest> request);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月16日 下午7:42:14
	 * @Title: selectUserByNodeCode 
	 * @Description: 节点用户列表
	 * @param request
	 * @return
	 *
	 */
	@PostMapping("/web/approveFlowNode/userList")
	public Response<ApproveSecurityUserResponse> selectUserByNodeCode(Request<String> request);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月24日 下午3:29:42
	 * @Title: selectNodeInfoByNodeCodePage 
	 * @Description: 查询节点上活动的流水单信息
	 * @param request
	 * @return
	 *
	 */
	@PostMapping("/web/nodeResultInfo")
	public TableResponse<ApproveApplyResultResponse> selectNodeInfoByNodeCodePage(Request<ApproveApplyResultReq> request);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月24日 下午3:27:19
	 * @Title: selectNodeInfoFOrIsNoPage 
	 * @Description: 查询节点上被拒绝的流水单信息
	 * @param request
	 * @return
	 *
	 */
	@PostMapping("/web/resultIsNo")
	public TableResponse<ApproveApplyResultResponse> selectNodeInfoFOrIsNoPage(Request<ApproveApplyResultReq> request);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月7日 下午5:16:37
	 * @Title: queryFlowListByApplyCodeForBs 
	 * @Description: 活动节点查询流水单相关所有信息
	 * @param request
	 * @return
	 *
	 */
	@PostMapping("/web/nodeResultInfo/nodeList")
	public Response<List<FlowNodeModel>> queryFlowListByApplyCodeForNodeResultInfo(Request<SalerRequest> request);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月24日 下午5:52:33
	 * @Title: queryFlowListByApplyCodeForResultIsNo 
	 * @Description: 规党节点查询流水单相关所有信息
	 * @param request
	 * @return
	 *
	 */
	@PostMapping("/web/resultIsNo/nodeList")
	public Response<List<FlowNodeModel>> queryFlowListByApplyCodeForResultIsNo(@RequestBody Request<SalerRequest> request);

}
