/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.controller.saler;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.guludai.api.code.BaseCode;
import cn.guludai.api.data.Request;
import cn.guludai.api.data.Response;
import cn.guludai.market.api.saler.code.SalerCode;
import cn.guludai.market.api.saler.request.SalerRequest;
import cn.guludai.market.api.saler.response.FlowNodeModel;
import cn.guludai.market.common.model.ResultModel;
import cn.guludai.market.service.saler.service.ApproveApplyRecordService;
import cn.guludai.market.service.saler.service.ApproveApplyResultService;
import cn.guludai.market.service.saler.service.ApproveFlowNodeService;
import cn.guludai.market.web.code.MarketBaseCode;
import cn.guludai.market.web.request.ApproveApplyResultReq;
import cn.guludai.market.web.request.ApproveFlowNodeReq;
import cn.guludai.market.web.response.ApproveApplyResultResponse;
import cn.guludai.market.web.response.ApproveFlowNodeResponse;
import cn.guludai.market.web.response.ApproveSecurityUserResponse;
import cn.guludai.market.web.response.TableResponse;
import cn.guludai.market.web.saler.ApproveFlowNodeWeb;
import cn.guludai.market.web.user.request.ZtreeRequest;
import cn.guludai.market.web.user.response.ZtreeResponse;

@Controller
public class ApproveFlowNodeController implements ApproveFlowNodeWeb {
	private static final Logger logger = LoggerFactory.getLogger(ApproveFlowNodeController.class);
	@Autowired
	private ApproveApplyResultService approveApplyResultService;
	@Autowired
	private ApproveFlowNodeService approveFlowNodeService;
	
	@Autowired
	private ApproveApplyRecordService approveApplyRecordService;

	@Override
	@ResponseBody
	public TableResponse<ApproveFlowNodeResponse> list(@RequestBody Request<ApproveFlowNodeReq> request) {
		ApproveFlowNodeReq param = request.getData();
		TableResponse<ApproveFlowNodeResponse> result;
		try {
			result = approveFlowNodeService.seletFlowNodeByFlowCode(param);
		} catch (Exception e) {
			logger.error("[系统运行错误:]" + e.getMessage(), e);
			return null;
		}
		return result;
	}
	@Override
	@ResponseBody
	public Response<ZtreeResponse> zTree(@RequestBody Request<String> request) {
		String nodeCode = request.getData();
		ResultModel<ZtreeResponse> result = null;
		try {
			result = approveFlowNodeService.getzTreeForUserAndFlowNode(nodeCode);
		} catch (Exception e) {
			logger.error(MarketBaseCode.ERROR_SYS.getMessage(), e, e.getMessage());
		}
		return Response.success(BaseCode.SUCCESS, result.getLs());
	}
	@Override
	@ResponseBody
	public Response<String> setting(@RequestBody Request<ZtreeRequest> request) {
		ZtreeRequest param = request.getData();
		approveFlowNodeService.setting(param);
		return Response.success(BaseCode.SUCCESS);
	}
	@Override
	@ResponseBody
	public Response<ApproveSecurityUserResponse> selectUserByNodeCode(@RequestBody Request<String> request) {
		String id = request.getData();
		ResultModel<ApproveSecurityUserResponse> result;
		try {
			result = approveFlowNodeService.selectUserByNodeCode(id);
		} catch (Exception e) {
			logger.error("[系统运行错误:]" + e.getMessage(), e);
			return null;
		}
		return Response.success(BaseCode.SUCCESS, result.getLs());
	}
	/**
	 * @author: xiongshikang
	 * @date: 2018年1月17日 上午10:02:05
	 * @Title: resource
	 * @Description: 节点展示页
	 * @return
	 */
	@GetMapping("/approveFlowNode")
	public String approveFlowNode() {
		return "admin/approveFlowNode/list";
	}
	/**
	 * @author: xiongshikang
	 * @date: 2018年1月17日 上午10:02:33
	 * @Title: setting
	 * @Description: 节点分配人员页
	 * @return
	 */
	@GetMapping("/approveFlowNode/setting")
	public String setting() {
		return "admin/approveFlowNode/setting";
	}
	@Override
	@ResponseBody
	public TableResponse<ApproveApplyResultResponse> selectNodeInfoByNodeCodePage(
			@RequestBody Request<ApproveApplyResultReq> request) {
		ApproveApplyResultReq req = request.getData();
		if (StringUtils.isBlank(req.getNodeCode())) {
			return null;
		}
		TableResponse<ApproveApplyResultResponse> result;
		try {
			result = approveApplyResultService.selectNodeInfoByNodeCodePage(req);
		} catch (Exception e) {
			logger.error("[系统运行错误:]" + e.getMessage(), e);
			return null;
		}
		return result;
	}
	@Override
	@ResponseBody
	public TableResponse<ApproveApplyResultResponse> selectNodeInfoFOrIsNoPage(
			@RequestBody Request<ApproveApplyResultReq> request) {
		ApproveApplyResultReq req = request.getData();
		if (StringUtils.isBlank(req.getNodeCode())) {
			return null;
		}
		TableResponse<ApproveApplyResultResponse> result;
		try {
			result = approveApplyResultService.selectNodeInfoFOrIsNoPage(req);
		} catch (Exception e) {
			logger.error("[系统运行错误:]" + e.getMessage(), e);
			return null;
		}
		return result;
	}
	/**
	 * @author: xiongshikang
	 * @date: 2018年1月17日 上午10:02:05
	 * @Title: resource
	 * @Description: 节点活动定单页
	 * @return
	 */
	@GetMapping("/nodeResultInfo")
	public String nodeResultInfo() {
		return "admin/nodeResultInfo/list";
	}
	/**
	 * @author: xiongshikang
	 * @date: 2018年1月17日 上午10:02:05
	 * @Title: resource
	 * @Description: 节点被拒绝流水单页
	 * @return
	 */
	@GetMapping("/resultIsNo")
	public String resultIsNo() {
		return "admin/resultIsNo/list";
	}
	/**
	 * @author: xiongshikang
	 * @date: 2017年12月8日 下午12:07:38
	 * @Title: ApproveApplyRecord
	 * @Description: 活动节点详情页
	 * @return
	 */
	@GetMapping("/nodeResultInfo/edit")
	public String nodeResultInfoEdit() {
		return "admin/nodeResultInfo/edit";
	}
	
	/**
	 * @author: xiongshikang
	 * @date: 2017年12月8日 下午12:07:38
	 * @Title: ApproveApplyRecord
	 * @Description: 规党节点详情页
	 * @return
	 */
	@GetMapping("/resultIsNo/edit")
	public String resultIsNoEdit() {
		return "admin/resultIsNo/edit";
	}
 
	@Override
	@ResponseBody
	public Response<List<FlowNodeModel>> queryFlowListByApplyCodeForNodeResultInfo(@RequestBody Request<SalerRequest> request) {
		try {
			ResultModel<FlowNodeModel> result =  approveApplyRecordService.queryFlowListByApplycodeForBS(request);
			if(result.getCode().equals(SalerCode.DATA_EMPTY.getCode())) {
				/**
				 * 无数据
				 */
				return Response.failure(SalerCode.DATA_EMPTY, SalerCode.DATA_EMPTY.getMessage());
			}else if(result.getCode().equals(SalerCode.APPLY_CODE_EMPTY.getCode())){
				/**
				 * 流水号参数错误
				 */
				return Response.failure(SalerCode.APPLY_CODE_EMPTY, SalerCode.APPLY_CODE_EMPTY.getMessage());
			}else {
				return Response.success(BaseCode.SUCCESS, result.getLs());
			}
		} catch (Exception e) {
			logger.error("[系统运行错误:]" + e.getMessage(), e);
			return null;
		}
	}
	
	@Override
	@ResponseBody
	public Response<List<FlowNodeModel>> queryFlowListByApplyCodeForResultIsNo(@RequestBody Request<SalerRequest> request) {
		try {
			ResultModel<FlowNodeModel> result =  approveApplyRecordService.queryFlowListByApplycodeForBS(request);
			if(result.getCode().equals(SalerCode.DATA_EMPTY.getCode())) {
				/**
				 * 无数据
				 */
				return Response.failure(SalerCode.DATA_EMPTY, SalerCode.DATA_EMPTY.getMessage());
			}else if(result.getCode().equals(SalerCode.APPLY_CODE_EMPTY.getCode())){
				/**
				 * 流水号参数错误
				 */
				return Response.failure(SalerCode.APPLY_CODE_EMPTY, SalerCode.APPLY_CODE_EMPTY.getMessage());
			}else {
				return Response.success(BaseCode.SUCCESS, result.getLs());
			}
		} catch (Exception e) {
			logger.error("[系统运行错误:]" + e.getMessage(), e);
			return null;
		}
	}
}
