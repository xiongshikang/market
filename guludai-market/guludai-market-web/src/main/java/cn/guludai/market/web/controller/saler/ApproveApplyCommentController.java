/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.controller.saler;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.guludai.api.code.BaseCode;
import cn.guludai.api.data.Request;
import cn.guludai.api.data.Response;
import cn.guludai.market.domain.entity.ApproveSecurityUser;
import cn.guludai.market.service.saler.service.ApproveApplyCommentService;
import cn.guludai.market.web.code.MarketBaseCode;
import cn.guludai.market.web.request.ApproveApplyCommentReq;
import cn.guludai.market.web.response.ApproveApplyCommentResponse;
import cn.guludai.market.web.saler.ApproveApplyCommentWeb;

@Controller
public class ApproveApplyCommentController implements ApproveApplyCommentWeb{

	private static final Logger logger = LoggerFactory.getLogger(ApproveApplyCommentController.class);
	
	@Autowired
	private ApproveApplyCommentService approveApplyCommentService;
	
	@Override
	@ResponseBody
	public Response<ApproveApplyCommentResponse> list(@RequestBody Request<String> request) {
		String applyCode = request.getData();
		if(StringUtils.isBlank(applyCode)) {
			return Response.failure(MarketBaseCode.ERROR_REQ_A002, MarketBaseCode.ERROR_REQ_A002.getMessage());
		}
		List<ApproveApplyCommentResponse> ls;
		try {
			ls = approveApplyCommentService.list(applyCode);
		} catch (Exception e) {
			logger.error("[系统运行错误:]" + e.getMessage(), e);
			return null;
		}
		return Response.success(BaseCode.SUCCESS, ls);
	}

	@Override
	@ResponseBody
	public Response<ApproveApplyCommentResponse> add(@RequestBody Request<ApproveApplyCommentReq> request) {
		ApproveApplyCommentReq param = request.getData();
		Subject subject = SecurityUtils.getSubject();
		ApproveSecurityUser user = (ApproveSecurityUser)subject.getSession().getAttribute("userSession");
		param.setUserCode(user.getUserCode());
		try {
			approveApplyCommentService.addApproveApplyCommentEntity(param);
		} catch (Exception e) {
			logger.error("[系统运行错误:]" + e.getMessage(), e);
			return null;
		}
		return Response.success(BaseCode.SUCCESS);
	}
}
