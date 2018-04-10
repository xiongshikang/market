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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.guludai.api.code.BaseCode;
import cn.guludai.api.data.Request;
import cn.guludai.api.data.Response;
import cn.guludai.market.common.model.ResultModel;
import cn.guludai.market.common.util.JsonTool;
import cn.guludai.market.domain.entity.ApproveSecurityUser;
import cn.guludai.market.service.saler.service.ApproveApplyResultService;
import cn.guludai.market.service.saler.service.WorkflowTraceService;
import cn.guludai.market.web.code.MarketBaseCode;
import cn.guludai.market.web.request.ApproveApplyResultReq;
import cn.guludai.market.web.response.ApproveApplyResultResponse;
import cn.guludai.market.web.response.TableResponse;
import cn.guludai.market.web.saler.ApproveApplyResultWeb;
import cn.guludai.market.web.saler.request.ApplyExcelModelRequest;
import cn.guludai.market.web.saler.response.ApplyExcelModelResponse;

@Controller
public class ApproveApplyResultController implements ApproveApplyResultWeb {

	private static final Logger logger = LoggerFactory.getLogger(ApproveApplyResultController.class);
	
	@Autowired
	private ApproveApplyResultService approveApplyResultService;
	@Autowired
	private WorkflowTraceService workflowTraceService;
	
    /**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月27日 下午4:16:21
	 * @Title: approveApplyresult 
	 * @Description: 申请审批列表页
	 * @return
	 *
	 */
	@GetMapping(value = "applyExcel")
	public String applyExcel() {
		return "admin/applyExcel/list";
	}
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月27日 下午4:16:21
	 * @Title: approveApplyresult 
	 * @Description: 申请审批列表页
	 * @return
	 *
	 */
	@GetMapping(value = "approveApplyresult")
	public String approveApplyresult() {
		return "admin/approveApplyResult/list";
	}

	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月28日 上午11:24:51
	 * @Title: pluginRunningStatEdit 
	 * @Description: 跳转到申请信息详情页
	 * @return
	 *
	 */
    @GetMapping("/approveApplyresult/edit")
	public String pluginRunningStatEdit() {
		 return "admin/approveApplyResult/edit";
	}
    
    /**
     * 
     * @author: xiongshikang
     * @date: 2017年11月30日 下午2:02:12
     * @Title: pluginRunningStatEdit 
     * @Description: 个人任务页
     * @return
     *
     */
    @GetMapping("/mytask")
	public String mytask() {
		 return "admin/mytask/list";
	}

    /**
     * 
     * @author: xiongshikang
     * @date: 2017年11月30日 下午2:04:22
     * @Title: mytaskEdit 
     * @Description: 办理个人任务
     * @return
     *
     */
    @GetMapping("/mytask/edit")
	public String mytaskEdit() {
		 return "admin/mytask/edit";
	}
	
    /**
     * 
     * @author: xiongshikang
     * @date: 2017年12月1日 下午6:18:34
     * @Title: mytaskEdit2 
     * @Description: 转交任务页面
     * @return
     *
     */
    @GetMapping("/mytask/edit2")
	public String mytaskEdit2() {
		 return "admin/mytask/edit2";
	}

    /**
     * 
     * @author: xiongshikang
     * @date: 2017年12月4日 下午1:11:53
     * @Title: callBack 
     * @Description: 电话回访页
     * @return
     *
     */
    @GetMapping("/mytask/callBack")
    public String callBack() {
		return "admin/mytask/callback";
	}
  
    /**
     * 
     * @author: xiongshikang
     * @date: 2017年12月4日 下午1:13:30
     * @Title: preloanreview 
     * @Description: 贷前审核
     * @return
     *
     */
    @GetMapping("/mytask/preloanreview")
	public String preloanreview() {
		return "admin/mytask/preloanreview";
	}

    /**
     * 
     * @author: xiongshikang
     * @date: 2017年12月4日 下午1:13:42
     * @Title: closetothedoor 
     * @Description: 上门尽调
     * @return
     *
     */
    @GetMapping("/mytask/closetothedoor")
	public String closetothedoor() {
		return "admin/mytask/closetothedoor";
	}

    /**
     * 
     * @author: xiongshikang
     * @date: 2017年12月4日 下午1:14:26
     * @Title: materialapproval 
     * @Description: 材料审批
     * @return
     *
     */
    @GetMapping("/mytask/materialapproval")
	public String materialapproval() {
		return "admin/mytask/materialapproval";
	}

    /**
     * 
     * @author: xiongshikang
     * @date: 2017年12月4日 下午1:15:19
     * @Title: bothpartiessignedacontract 
     * @Description: 双方签约
     * @return
     *
     */
    @GetMapping("/mytask/bothpartiessignedacontract")
	public String bothpartiessignedacontract() {
		return "admin/mytask/bothpartiessignedacontract";
	}

    /**
     * 
     * @author: xiongshikang
     * @date: 2017年12月4日 下午1:16:01
     * @Title: fundsappropriation 
     * @Description: 资金拨款
     * @return
     *
     */
    @GetMapping("/mytask/fundsappropriation")
	public String fundsappropriation() {
		return "admin/mytask/fundsappropriation";
	}
    
	@Override
	@ResponseBody
	public TableResponse<ApproveApplyResultResponse> approveApplyresult(@RequestBody Request<ApproveApplyResultReq> request) {
		ApproveApplyResultReq req = request.getData() ;
		TableResponse<ApproveApplyResultResponse> result;
		try {
			 result = approveApplyResultService.selectPluginLicenseList(req);
		} catch (Exception e) {
			logger.error("[系统运行错误:]" + e.getMessage(), e);
			return null;
		}
		 return result;
	}
 
	@Override
	@ResponseBody
	public Response<ApproveApplyResultResponse> edit(@RequestBody Request<ApproveApplyResultReq> req) {
		try {
			 Subject subject = SecurityUtils.getSubject();
			 ApproveSecurityUser user = (ApproveSecurityUser)subject.getSession().getAttribute("userSession");
			 ResultModel<String> result = approveApplyResultService.acceptApplicatiYon(req, user.getUserCode());
			 if(result.getCode().equals(MarketBaseCode.ACTIVITY_ID_NOT_EMPTY.getCode())) {
				 return Response.failure(MarketBaseCode.ACTIVITY_ID_NOT_EMPTY, MarketBaseCode.ACTIVITY_ID_NOT_EMPTY.getMessage());
			 }
			return Response.success(MarketBaseCode.SUCCESS);
		} catch (Exception e) {
			logger.error("[系统运行错误:]" + e.getMessage(), e);
			return Response.failure(MarketBaseCode.ERROR_SYS, e.getMessage());
		}
	}
	
	@Override
	@ResponseBody
	public Response<ApproveApplyResultResponse> edit2(@RequestBody Request<ApproveApplyResultReq> req) {
		try {
			ApproveApplyResultReq model = req.getData();
			 Subject subject = SecurityUtils.getSubject();
			 ApproveSecurityUser user = (ApproveSecurityUser)subject.getSession().getAttribute("userSession");
			workflowTraceService.setAssignee(model,user.getUserCode());	
			return Response.success(MarketBaseCode.SUCCESS);
		} catch (Exception e) {
			logger.error("[系统运行错误:]" + e.getMessage(), e);
			return Response.failure(MarketBaseCode.ERROR_SYS, MarketBaseCode.ERROR_SYS.getMessage());
		}
	}

	@Override
	@ResponseBody
	public Response<ApproveApplyResultResponse> select(@RequestBody Request<ApproveApplyResultReq> req) {
		ApproveApplyResultReq param = req.getData();
		try {
			ResultModel<ApproveApplyResultResponse> result = approveApplyResultService.select(param);
			if(result.getCode().equals(MarketBaseCode.APP_USER_APPLY_SHOP_ERROR.getCode())) {
				/**
				 * 远程数据获取失败
				 */
				return Response.failure(MarketBaseCode.APP_USER_APPLY_SHOP_ERROR, MarketBaseCode.APP_USER_APPLY_SHOP_ERROR.getMessage());
			}
			return Response.success(MarketBaseCode.SUCCESS, result);
		} catch (Exception e) {
			logger.error("[系统运行错误:]" + e.getMessage(), e);
			return Response.failure(MarketBaseCode.ERROR_SYS, MarketBaseCode.ERROR_SYS.getMessage());
		}
	}
 
	 /**
     * 
     * @author: xiongshikang
     * @date: 2017年11月29日 下午2:06:57
     * @Title: deploymentProcessDefinition 
     * @Description: 部署流程定义
     * @return
     *
     */
    @GetMapping("/process")
    public String deploymentProcessDefinition() {
    	workflowTraceService.deploymentProcessDefinition();
    	return "success";
    }
    
    @Override
    @ResponseBody
    public TableResponse<ApproveApplyResultResponse> getMyTaskList(@RequestBody Request<ApproveApplyResultReq> request){
    	Subject subject = SecurityUtils.getSubject();
    	ApproveSecurityUser user = (ApproveSecurityUser)subject.getSession().getAttribute("userSession");
    	TableResponse<ApproveApplyResultResponse> result;
		try {
			 result = workflowTraceService.findTaskListByUserCode(request,user.getUserCode());
		} catch (Exception e) {
			logger.error("[系统运行错误:]" + e.getMessage(), e);
			return null;
		}
		 return result;
    }
    
    @Override
    @ResponseBody
    public Response<String> receiveTask(@RequestBody Request<String> req){
    	Subject subject = SecurityUtils.getSubject();
    	ApproveSecurityUser user = (ApproveSecurityUser)subject.getSession().getAttribute("userSession");
    	ResultModel<String> result = workflowTraceService.receiveTask(user.getUserCode(),req.getData());
    	if(null==result) {
    		return Response.failure(BaseCode.ERROR, BaseCode.ERROR.getMessage());
    	}else if(result.getCode().equals(BaseCode.SUCCESS.getCode())) {
    		return Response.success(BaseCode.SUCCESS, result.getResult());
    	}else if(result.getCode().equals(MarketBaseCode.PROCESSINSTANCE_IS_NOT_EMPTY.getCode())){
    		return Response.failure(MarketBaseCode.PROCESSINSTANCE_IS_NOT_EMPTY, MarketBaseCode.PROCESSINSTANCE_IS_NOT_EMPTY.getMessage());
    	}else {
    		return Response.failure(BaseCode.ERROR, BaseCode.ERROR.getMessage());
    	}
    }
    
    
    
    /**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月3日 下午5:05:56
	 * @Title: applyExcel 
	 * @Description: 数据展示
	 * @param request
	 * @return
	 *
	 */
	@GetMapping("/web/applyExcel/list")
	@ResponseBody
	public List<ApplyExcelModelResponse> applyExcel(String dataJson) {
    	if(StringUtils.isBlank(dataJson)) {
    		return null;
    	}
    	ApplyExcelModelRequest model = JsonTool.json2povo(dataJson, ApplyExcelModelRequest.class);
    	List<ApplyExcelModelResponse> ls = null;
		try { 
			ls = approveApplyResultService.applyExcel(model);
		} catch (Exception e) {
			logger.error(MarketBaseCode.ERROR_SYS.getMessage(),e.getMessage(),e);
		}
		return ls;
	}
    
}
