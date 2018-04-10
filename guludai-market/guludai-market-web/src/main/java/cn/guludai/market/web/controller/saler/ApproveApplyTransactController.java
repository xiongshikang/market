/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.controller.saler;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.guludai.api.data.Request;
import cn.guludai.market.domain.entity.ApproveSecurityUser;
import cn.guludai.market.service.saler.service.ApproveApplyTransactService;
import cn.guludai.market.web.request.ApproveApplyResultReq;
import cn.guludai.market.web.response.ApproveApplyResultResponse;
import cn.guludai.market.web.response.TableResponse;
import cn.guludai.market.web.saler.ApproveApplyTransactWeb;

@Controller
public class ApproveApplyTransactController implements ApproveApplyTransactWeb{

	private static final Logger logger = LoggerFactory.getLogger(ApproveApplyTransactController.class);
	
	@Autowired
	private ApproveApplyTransactService approveApplyTransactService;
	
	@Override
	@ResponseBody
	public TableResponse<ApproveApplyResultResponse> myHistoryTask(@RequestBody Request<ApproveApplyResultReq> request) {
		TableResponse<ApproveApplyResultResponse> result;
		try {
			 Subject subject = SecurityUtils.getSubject();
			 ApproveSecurityUser user = (ApproveSecurityUser)subject.getSession().getAttribute("userSession");
			 ApproveApplyResultReq param = request.getData();
			 param.setTransactUser(user.getUserCode());
			 result = approveApplyTransactService.findTaskListByTransactUser(param);
		} catch (Exception e) {
			logger.error("[系统运行错误:]" + e.getMessage(), e);
			return null;
		}
		 return result;
	}
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月27日 下午4:16:21
	 * @Title: approveApplyresult 
	 * @Description: 个人任务列表
	 * @return
	 *
	 */
	@GetMapping(value = "hisMytask")
	public String hisMytask() {
		return "admin/hisMytask/list";
	}
	
	
}
