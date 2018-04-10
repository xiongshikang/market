/**
O * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.controller.user;

import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

import cn.guludai.api.code.BaseCode;
import cn.guludai.api.data.Request;
import cn.guludai.api.data.Response;
import cn.guludai.market.common.model.ResultModel;
import cn.guludai.market.common.util.JsonTool;
import cn.guludai.market.domain.entity.ApproveSecurityUser;
import cn.guludai.market.service.user.ApproveSecurityResourceEntityService;
import cn.guludai.market.service.user.ApproveSecurityRoleEntityService;
import cn.guludai.market.service.user.ApproveSecurityUserResourceEntityService;
import cn.guludai.market.service.user.ApproveSecurityUserRoleEntityService;
import cn.guludai.market.service.user.ApproveSecurityUserService;
import cn.guludai.market.web.code.MarketBaseCode;
import cn.guludai.market.web.code.UserCode;
import cn.guludai.market.web.response.ApproveSecurityUserResponse;
import cn.guludai.market.web.response.TableResponse;
import cn.guludai.market.web.user.SecurityUserWeb;
import cn.guludai.market.web.user.request.ApproveSecurityUserReq;
import cn.guludai.market.web.user.request.ZtreeRequest;
import cn.guludai.market.web.user.response.MenuTree;
import cn.guludai.market.web.user.response.ZtreeResponse;

@Controller
public class SecurityUserController implements SecurityUserWeb {

	private static final Logger logger = LoggerFactory.getLogger(SecurityUserController.class);
	
	@Autowired
	private ApproveSecurityUserService approveSecurityUserService;
	@Autowired
	private ApproveSecurityResourceEntityService approveSecurityResourceEntityService;
	@Autowired
	private ApproveSecurityUserResourceEntityService approveSecurityUserResourceEntityService;
	@Autowired
	private ApproveSecurityRoleEntityService approveSecurityRoleEntityService;
	@Autowired
	private ApproveSecurityUserRoleEntityService approveSecurityUserRoleEntityService;
	
	 /**
     * 
     * @author: xiongshikang
     * @date: 2017年12月5日 上午10:45:29
     * @Title: user 
     * @Description: 用户管理列表
     * @return
     *
     */
	@GetMapping("/user")
	public String user() {
		return "admin/user/list";
	}

	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月5日 上午10:45:46
	 * @Title: userAdd 
	 * @Description: 添加与修改用户页
	 * @return
	 *
	 */
	@GetMapping("/user/edit")
	public String userAdd() {
		return "admin/user/edit";
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
	@GetMapping("/user/setting")
	public String setting() {
		return "admin/user/setting";
	}
	
	@Override
	@ResponseBody
	public Response<ZtreeResponse> zTree(@RequestBody Request<String> request) {
		String userCode = request.getData();
		ResultModel<ZtreeResponse> result = null;
		try {
			result = approveSecurityResourceEntityService.getzTreeAllForUser(userCode);
		} catch (Exception e) {
			logger.error(MarketBaseCode.ERROR_SYS.getMessage(),e,e.getMessage());
		}
		return Response.success(BaseCode.SUCCESS,result.getLs());
	}
	
	@Override
	@ResponseBody
	public Response<ApproveSecurityUserResponse> list(){
		try {
			List<ApproveSecurityUserResponse> ls = approveSecurityUserService.getAll();
			return Response.success(BaseCode.SUCCESS,ls);
		} catch (Exception e) {
			logger.error("[系统运行错误:]" + e.getMessage(), e);
			return Response.failure(MarketBaseCode.ERROR_SYS, MarketBaseCode.ERROR_SYS.getMessage());
		}
	}

	@Override
	@ResponseBody
	public TableResponse<ApproveSecurityUserResponse> approveSecurityUserResult(@RequestBody Request<ApproveSecurityUserReq> request) {
		ApproveSecurityUserReq req = request.getData() ;
		TableResponse<ApproveSecurityUserResponse> result;
		try {
			result = approveSecurityUserService.selectSecurityUserList(req);
		} catch (Exception e) {
			logger.error("[系统运行错误:]" + e.getMessage(), e);
			return null;
		}
		return result;
	}


	@Override
	@ResponseBody
	public Response<ApproveSecurityUserResponse> add(@RequestBody Request<ApproveSecurityUserReq> request) {
		try {
			ApproveSecurityUserReq approveSecurityUserReq = request.getData();
			if (StringUtils.isBlank(approveSecurityUserReq.getUserName()) || StringUtils.isBlank(approveSecurityUserReq.getPassword())){
				return Response.failure(UserCode.PWD_NOT_EMPTY, UserCode.PWD_NOT_EMPTY.getMessage());
			}
			ResultModel resultModel = approveSecurityUserService.register(request.getData());
			if (resultModel.getCode().equals(MarketBaseCode.ERROR_INVALID.getCode())){
				logger.error("[数据库修改无效:]" + JSONObject.toJSON(request.getData()));
				return Response.failure(MarketBaseCode.ERROR_INVALID, MarketBaseCode.ERROR_INVALID.getMessage());
			}else if(resultModel.getCode().equals(UserCode.USER_NAME_EXISTENCE_ERROR.getCode())){
				logger.error("[登录名称重复:]" + JSONObject.toJSON(request.getData()));
				return Response.failure(UserCode.USER_NAME_EXISTENCE_ERROR, UserCode.USER_NAME_EXISTENCE_ERROR.getMessage());
			}
			return Response.success(BaseCode.SUCCESS);
		} catch (Exception e) {
			logger.error("[系统运行错误:]" + e.getMessage(), e);
			return Response.failure(MarketBaseCode.ERROR_SYS, MarketBaseCode.ERROR_SYS.getMessage());
		}
	}

	@Override
	@ResponseBody
	public Response<ApproveSecurityUserResponse> editUser(@RequestBody Request<ApproveSecurityUserReq> request) {
		try {
			ResultModel resultModel = approveSecurityUserService.editUser(request.getData());
			if (resultModel.getCode().equals(MarketBaseCode.ERROR_INVALID.getCode())){
				logger.error("[数据库修改无效:]" + JSONObject.toJSON(request.getData()));
				return Response.failure(MarketBaseCode.ERROR_INVALID, MarketBaseCode.ERROR_INVALID.getMessage());
			}
			return Response.success(BaseCode.SUCCESS);
		} catch (Exception e) {
			logger.error("[系统运行错误:]" + e.getMessage(), e);
			return Response.failure(MarketBaseCode.ERROR_SYS, MarketBaseCode.ERROR_SYS.getMessage());
		}
	}

	@Override
	@ResponseBody
	public Response<ApproveSecurityUserResponse> select(@RequestBody Request<String> userCode) {
		try {
			if (StringUtils.isBlank(userCode.getData())){
				return Response.failure(UserCode.USER_CORE_NOT_ERROR, UserCode.USER_CORE_NOT_ERROR.getMessage());
			}
			ApproveSecurityUserResponse ls = approveSecurityUserService.getUserInfo(userCode.getData());
			return Response.success(BaseCode.SUCCESS,ls);
		} catch (Exception e) {
			logger.error("[系统运行错误:]" + e.getMessage(), e);
			return Response.failure(MarketBaseCode.ERROR_SYS, MarketBaseCode.ERROR_SYS.getMessage());
		}
	}
	
	@Override
	@ResponseBody
	public Response<String> delete(@RequestBody Request<String> req){
		String userCode = req.getData();
		if(StringUtils.isBlank(userCode)) {
			/**
			 * 用户编号为空
			 */
			return Response.failure(MarketBaseCode.USER_CODE_EMPTY, MarketBaseCode.USER_CODE_EMPTY.getMessage()); 
		}
		approveSecurityUserService.deleteByUserCode(userCode);
		return Response.success(BaseCode.SUCCESS);
	} 

	@Override
	@ResponseBody
	public Response<String> settingUserResource(@RequestBody Request<ZtreeRequest> request) {
		 Subject subject = SecurityUtils.getSubject();
		 ApproveSecurityUser user = (ApproveSecurityUser)subject.getSession().getAttribute("userSession");
		// if(!user.getUserName().equals("admin")) {
			 ZtreeRequest record =  request.getData();
			 approveSecurityUserResourceEntityService.settingUserResources(record);
		// }
		return Response.success(BaseCode.SUCCESS);
	}
	
	@Override
	@ResponseBody
	public Response<ZtreeResponse> roleZTree(@RequestBody Request<String> request) {
		String userCode = request.getData();
		ResultModel<ZtreeResponse> result = null;
		try {
			result = approveSecurityRoleEntityService.getzTreeAllForRole(userCode);
		} catch (Exception e) {
			logger.error(MarketBaseCode.ERROR_SYS.getMessage(),e,e.getMessage());
		}
		return Response.success(BaseCode.SUCCESS,result.getLs());
	}
	
	@Override
	@ResponseBody
	public Response<String> settingUserRole(@RequestBody Request<ZtreeRequest> request) {
		 Subject subject = SecurityUtils.getSubject();
		 ApproveSecurityUser user = (ApproveSecurityUser)subject.getSession().getAttribute("userSession");
		// if(!user.getUserName().equals("admin")) {
			 ZtreeRequest record =  request.getData();
			 approveSecurityUserRoleEntityService.settingRoleUser(record);
		// }
		return Response.success(BaseCode.SUCCESS);
	}

	@GetMapping("/user/menu")
	@ResponseBody
	public  List<MenuTree> menu() {
		 Subject subject = SecurityUtils.getSubject();
		 ApproveSecurityUser user = (ApproveSecurityUser)subject.getSession().getAttribute("userSession");
		 List<MenuTree> menuTrees = approveSecurityResourceEntityService.getMeun(user.getUserCode());
		 System.out.println(JsonTool.createJsonString(menuTrees));
		return menuTrees;
	}
	
}
