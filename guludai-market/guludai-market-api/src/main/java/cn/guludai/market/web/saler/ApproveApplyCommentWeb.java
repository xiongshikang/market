/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.saler;

import org.springframework.web.bind.annotation.PostMapping;

import cn.guludai.api.data.Request;
import cn.guludai.api.data.Response;
import cn.guludai.market.web.request.ApproveApplyCommentReq;
import cn.guludai.market.web.response.ApproveApplyCommentResponse;

/**
 * 
 * @ClassName: ApproveApplyCommentWeb 
 * @Description: 任务备注控制器
 * @author: xiongshikang
 * @date: 2018年1月17日 下午3:21:51
 */
public interface ApproveApplyCommentWeb {
	 
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月17日 下午3:23:37
	 * @Title: selectApplyCustomerByApplyCode 
	 * @Description: 通过流水编号，获取流程所有的注备信息
	 * @param request 
	 * @return
	 *
	 */
	@PostMapping("/web/approveApplyCommentResponse/List")
	public Response<ApproveApplyCommentResponse> list(Request<String> request);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月17日 下午3:24:58
	 * @Title: add 
	 * @Description: 添加注备
	 * @param request
	 * @return
	 *
	 */
	@PostMapping("/web/approveApplyCommentResponse/add")
	public Response<ApproveApplyCommentResponse> add(Request<ApproveApplyCommentReq> request);
	
}
