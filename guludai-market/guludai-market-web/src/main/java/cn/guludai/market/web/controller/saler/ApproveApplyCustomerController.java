/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.controller.saler;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.guludai.api.code.BaseCode;
import cn.guludai.api.data.Request;
import cn.guludai.api.data.Response;
import cn.guludai.market.api.saler.code.SalerCode;
import cn.guludai.market.common.model.ResultModel;
import cn.guludai.market.service.saler.service.ApproveApplyCustomerService;
import cn.guludai.market.web.request.ApproveApplyCommentReq;
import cn.guludai.market.web.saler.ApproveApplyCustomerWeb;
import cn.guludai.market.web.saler.response.ApproveApplyCustomerResponse;

@Controller
public class ApproveApplyCustomerController implements ApproveApplyCustomerWeb{
	
	private static final Logger logger = LoggerFactory.getLogger(ApproveApplyCustomerController.class);

	@Autowired
	private ApproveApplyCustomerService approveApplyCustomerService;
	
	@Override
	@ResponseBody
	public Response<ApproveApplyCustomerResponse> selectApplyCustomerByApplyCode(@RequestBody Request<String> request) {
		 String applyCode = request.getData();
		 ResultModel<ApproveApplyCustomerResponse> result ;
		 if(StringUtils.isBlank(applyCode)) {
			return Response.failure(SalerCode.APPLY_CODE_EMPTY, SalerCode.APPLY_CODE_EMPTY.getMessage());
		 }
		 try {
			 result = approveApplyCustomerService.selectApplyCustomerByApplyCode(applyCode);
		} catch (Exception e) {
			logger.error("[系统运行错误:]" + e.getMessage(), e);
			return null;
		}
		return Response.success(BaseCode.SUCCESS,result.getLs());
	}
	
}
