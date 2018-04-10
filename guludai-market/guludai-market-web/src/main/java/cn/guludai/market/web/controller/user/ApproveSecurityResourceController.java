/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.controller.user;

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
import cn.guludai.market.common.model.ResultModel;
import cn.guludai.market.service.user.ApproveSecurityResourceEntityService;
import cn.guludai.market.web.code.MarketBaseCode;
import cn.guludai.market.web.user.ApproveSecurityResourceWeb;
import cn.guludai.market.web.user.request.ApproveSecurityResourceEntityReq;
import cn.guludai.market.web.user.response.ApproveSecurityResourceEntityRep;

@Controller
public class ApproveSecurityResourceController implements ApproveSecurityResourceWeb {
	
	private static final Logger logger = LoggerFactory.getLogger(ApproveSecurityResourceController.class);

	@Autowired
	private ApproveSecurityResourceEntityService approveSecurityResourceEntityService;
	
	@GetMapping("/resource")
	public String resource() {
		return "admin/resource/list";
	}


	@GetMapping("/resource/edit")
	public String edit() {
		return "admin/resource/edit";
	}
	
	@Override
	@ResponseBody
	public List<ApproveSecurityResourceEntityRep> meunList(Request<ApproveSecurityResourceEntityReq> request) {
		ApproveSecurityResourceEntityReq record = request.getData();
		ResultModel<ApproveSecurityResourceEntityRep> result = null;
		try {
			result = approveSecurityResourceEntityService.getResourceAll(record);
		} catch (Exception e) {
			logger.error(MarketBaseCode.ERROR_SYS.getMessage(),e.getMessage(),e);
		}
		return result.getLs();
	}
 
	@Override
	@ResponseBody
	public Response<String> add(@RequestBody Request<ApproveSecurityResourceEntityReq> request) {
		ApproveSecurityResourceEntityReq record = request.getData();
		ResultModel<String> result;
		try {
			result = approveSecurityResourceEntityService.insert(record);
			if(result.getCode().equals(BaseCode.SUCCESS.getCode())) {
				return Response.success(BaseCode.SUCCESS);
			}else {
				return Response.failure(MarketBaseCode.ERROR_SYS, MarketBaseCode.ERROR_SYS.getMessage());
			}
		} catch (Exception e) {
			logger.error(MarketBaseCode.ERROR_SYS.getMessage(),e.getMessage(),e);
			return Response.failure(MarketBaseCode.ERROR_SYS, MarketBaseCode.ERROR_SYS.getMessage());
		}
	}

	@Override
	@ResponseBody
	public Response<String> edit(@RequestBody Request<ApproveSecurityResourceEntityReq> request) {
		ApproveSecurityResourceEntityReq record = request.getData();
		try {
			ResultModel<String> result = approveSecurityResourceEntityService.edit(record);
			if(result.getCode().equals(BaseCode.SUCCESS.getCode())) {
				return Response.success(BaseCode.SUCCESS);
			}else {
				return Response.failure(MarketBaseCode.ERROR_SYS, MarketBaseCode.ERROR_SYS.getMessage());
			}
		} catch (Exception e) {
			logger.error(MarketBaseCode.ERROR_SYS.getMessage(),e.getMessage(),e);
			return Response.failure(MarketBaseCode.ERROR_SYS, MarketBaseCode.ERROR_SYS.getMessage());
		}
	}
	
	@Override
	@ResponseBody
	public Response<ApproveSecurityResourceEntityRep> select(@RequestBody Request<ApproveSecurityResourceEntityReq> request) {
		ApproveSecurityResourceEntityReq record =  request.getData();
		ResultModel<ApproveSecurityResourceEntityRep> result = null;
		try {
			 result = approveSecurityResourceEntityService.select(record);
		} catch (Exception e) {
			logger.error(MarketBaseCode.ERROR_SYS.getMessage(),e.getMessage(),e);
			return Response.failure(MarketBaseCode.ERROR_SYS, MarketBaseCode.ERROR_SYS.getMessage());
		} 
		return Response.success(BaseCode.SUCCESS,result.getResult());
	}
	
	
	@Override
	@ResponseBody
	public Response<ApproveSecurityResourceEntityRep> parentAll() {
		ResultModel<ApproveSecurityResourceEntityRep> result;
		try {
			result = approveSecurityResourceEntityService.parentAll();
		} catch (Exception e) {
			logger.error(MarketBaseCode.ERROR_SYS.getMessage(),e.getMessage(),e);
			return Response.failure(MarketBaseCode.ERROR_SYS, MarketBaseCode.ERROR_SYS.getMessage());
		}
		return Response.success(BaseCode.SUCCESS,result.getLs());
	}
	
	@Override
	@ResponseBody
	public Response<String> delete(@RequestBody Request<String> request) {
		String resourceCode = request.getData();
		if(StringUtils.isBlank(resourceCode)) {
			return Response.failure(MarketBaseCode.ERROR_REQ_A002, MarketBaseCode.ERROR_REQ_A002.getMessage());
		}
		ResultModel<String> result;
		try {
			result = approveSecurityResourceEntityService.deleteResourceByCode(resourceCode);
		} catch (Exception e) {
			logger.error(MarketBaseCode.ERROR_SYS.getMessage(),e.getMessage(),e);
			return Response.failure(MarketBaseCode.ERROR_SYS, MarketBaseCode.ERROR_SYS.getMessage());
		}
		return Response.success(BaseCode.SUCCESS,result.getLs());
	}
	
	
}
