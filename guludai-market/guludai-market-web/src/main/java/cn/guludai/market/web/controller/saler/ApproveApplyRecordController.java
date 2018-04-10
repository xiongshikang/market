/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.controller.saler;

import java.util.List;

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
import cn.guludai.market.web.request.ApplyShopReq;
import cn.guludai.market.web.response.ApproveApplyResultResponse;
import cn.guludai.market.web.response.TableResponse;
import cn.guludai.market.web.saler.ApproveApplyRecordWeb;

@Controller
public class ApproveApplyRecordController implements ApproveApplyRecordWeb{
	
	private static final Logger logger = LoggerFactory.getLogger(ApproveApplyRecordController.class);

	@Autowired
	private ApproveApplyResultService approveApplyResultService;
	@Autowired
	private ApproveApplyRecordService approveApplyRecordService;
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月8日 下午12:07:38
	 * @Title: ApproveApplyRecord 
	 * @Description: 任务进度查看列表
	 * @return
	 *
	 */
	@GetMapping("/approveApplyRecord")
	public String ApproveApplyRecord() {
		return "admin/approveApplyRecord/list";
	}

	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月8日 下午12:07:38
	 * @Title: ApproveApplyRecord 
	 * @Description: 任务进度查看列表
	 * @return
	 *
	 */
	@GetMapping("/approveApplyRecord/edit")
	public String ApproveApplyRecordEdit() {
		return "admin/approveApplyRecord/edit";
	}
	
	@Override
	@ResponseBody
	public TableResponse<ApproveApplyResultResponse> selectPluginLicenseAllList(@RequestBody Request<ApplyShopReq> request) {
		ApplyShopReq req = request.getData() ;
		TableResponse<ApproveApplyResultResponse> result;
		try {
			 result = approveApplyResultService.selectPluginLicenseAllList(req);
		} catch (Exception e) {
			logger.error("[系统运行错误:]" + e.getMessage(), e);
			return null;
		}
		 return result;
	}
	
	@Override
	@ResponseBody
	public Response<List<FlowNodeModel>> queryFlowListByApplyCodeForBs(@RequestBody Request<SalerRequest> request) {
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

