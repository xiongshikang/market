/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.controller.user;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
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
import cn.guludai.market.domain.entity.ApproveSecurityUser;
import cn.guludai.market.service.user.ApproveSecurityResourceEntityService;
import cn.guludai.market.service.user.ApproveSecurityRoleEntityService;
import cn.guludai.market.service.user.ApproveSecurityRoleResourceEntityService;
import cn.guludai.market.web.code.MarketBaseCode;
import cn.guludai.market.web.response.TableResponse;
import cn.guludai.market.web.user.ApproveSecurityRoleEntityWeb;
import cn.guludai.market.web.user.request.ApproveSecurityRoleEntityReq;
import cn.guludai.market.web.user.request.ZtreeRequest;
import cn.guludai.market.web.user.response.ApproveSecurityRoleEntityRep;
import cn.guludai.market.web.user.response.ZtreeResponse;
@Controller
public class ApproveSecurityRoleEntityController implements ApproveSecurityRoleEntityWeb {
	
	private static final Logger logger = LoggerFactory.getLogger(ApproveSecurityRoleEntityController.class);
	
	@Autowired
	private ApproveSecurityRoleEntityService approveSecurityRoleEntityService;
	@Autowired
	private ApproveSecurityResourceEntityService approveSecurityResourceEntityService;
	@Autowired
	private ApproveSecurityRoleResourceEntityService approveSecurityRoleResourceEntityService;
	
	@GetMapping("/role")
	public String resource() {
		return "admin/role/list";
	}
	
	@GetMapping("/role/edit")
	public String edit() {
		return "admin/role/edit";
	}
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月14日 下午2:28:29
	 * @Title: edit 
	 * @Description: 设置权限
	 * @return
	 *
	 */
	@GetMapping("/role/setting")
	public String setting() {
		return "admin/role/setting";
	}
	
	@Override
	@ResponseBody
	public Response<ZtreeResponse> zTree(@RequestBody Request<String> request) {
		String roleCode = request.getData();
		ResultModel<ZtreeResponse> result = null;
		try {
			result = approveSecurityResourceEntityService.getzTreeAll(roleCode);
		} catch (Exception e) {
			logger.error(MarketBaseCode.ERROR_SYS.getMessage(),e,e.getMessage());
		}
		return Response.success(BaseCode.SUCCESS,result.getLs());
	}
	
	@Override
	@ResponseBody
	public TableResponse<ApproveSecurityRoleEntityRep> meunList(@RequestBody Request<ApproveSecurityRoleEntityReq> request) {
		ApproveSecurityRoleEntityReq record = request.getData();
		TableResponse<ApproveSecurityRoleEntityRep> result = null;
		try {
			result = approveSecurityRoleEntityService.getRoleAll(record);
		} catch (Exception e) {
			logger.error(MarketBaseCode.ERROR_SYS.getMessage(),e,e.getMessage());
		}
		return result;
	}

	@Override
	@ResponseBody
	public Response<String> add(@RequestBody Request<ApproveSecurityRoleEntityReq> request) {
		ApproveSecurityRoleEntityReq record = request.getData();
		ResultModel<String> result;
		try {
			result = approveSecurityRoleEntityService.insert(record);
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
	public Response<String> edit(@RequestBody Request<ApproveSecurityRoleEntityReq> request) {
		ApproveSecurityRoleEntityReq record = request.getData();
		try {
			ResultModel<String> result = approveSecurityRoleEntityService.edit(record);
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
	public Response<ApproveSecurityRoleEntityRep> select(@RequestBody Request<ApproveSecurityRoleEntityReq> request) {
		ApproveSecurityRoleEntityReq record =  request.getData();
		ResultModel<ApproveSecurityRoleEntityRep> result;
		try {
			result = approveSecurityRoleEntityService.select(record);
		} catch (Exception e) {
			logger.error(MarketBaseCode.ERROR_SYS.getMessage(),e,e.getMessage());
			return Response.failure(MarketBaseCode.ERROR_SYS, MarketBaseCode.ERROR_SYS.getMessage());
		} 
		return Response.success(BaseCode.SUCCESS,result.getResult());
	}

	@Override
	@ResponseBody
	public Response<String> setting(@RequestBody Request<ZtreeRequest> request) {
		 Subject subject = SecurityUtils.getSubject();
		 ApproveSecurityUser user = (ApproveSecurityUser)subject.getSession().getAttribute("userSession");
		// if(!user.getUserName().equals("admin")) {
			 ZtreeRequest record =  request.getData();
			 approveSecurityRoleResourceEntityService.settingRoleResources(record);
		// }
		return Response.success(BaseCode.SUCCESS);
	}
 
}
