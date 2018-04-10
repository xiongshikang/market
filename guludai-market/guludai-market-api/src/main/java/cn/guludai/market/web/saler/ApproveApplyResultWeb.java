/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.saler;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cn.guludai.api.data.Request;
import cn.guludai.api.data.Response;
import cn.guludai.market.web.request.ApproveApplyResultReq;
import cn.guludai.market.web.response.ApproveApplyResultResponse;
import cn.guludai.market.web.response.TableResponse;

/**
 * 
 * @ClassName: ApproveApplyResultWeb 
 * @Description: 申请审批结果控制器
 * @author: xiongshikang
 * @date: 2017年11月27日 下午2:39:24
 */
public interface ApproveApplyResultWeb {
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月28日 上午11:04:50
	 * @Title: approveApplyresult 
	 * @Description: 查询申请信息列表
	 * @param request
	 * @return
	 *
	 */
	@PostMapping("/web/approveApplyresult")
	public TableResponse<ApproveApplyResultResponse> approveApplyresult(Request<ApproveApplyResultReq> request);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月28日 上午11:05:15
	 * @Title: edit 
	 * @Description: 修改申请信息
	 * @param req
	 * @return
	 *
	 */
	@PostMapping("/web/approveApplyresult/edit") 
	public Response<ApproveApplyResultResponse> edit(Request<ApproveApplyResultReq> req);
	
	 /**
	  * 
	  * @author: xiongshikang
	  * @date: 2017年11月28日 上午11:05:25
	  * @Title: select 
	  * @Description: 查询申请信息
	  * @param req
	  * @return
	  *
	  */
	@PostMapping("/web/approveApplyresult/select")
	public Response<ApproveApplyResultResponse> select(Request<ApproveApplyResultReq> req);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月30日 下午1:21:11
	 * @Title: getMyTaskList 
	 * @Description: 个人任务列表
	 * @return
	 *
	 */
	@PostMapping("/web/approveApplyresult/getMyTaskList")
	public TableResponse<ApproveApplyResultResponse> getMyTaskList(@RequestBody Request<ApproveApplyResultReq> request);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月30日 下午1:32:26
	 * @Title: receiveTask 
	 * @Description: 领取任务
	 * @return
	 *
	 */
	@PostMapping("/web/approveApplyresult/receiveTask")
	public Response<String> receiveTask(Request<String> req);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月1日 下午6:20:58
	 * @Title: edit2 
	 * @Description: 转交任务
	 * @param req
	 * @return
	 *
	 */
	@PostMapping("/web/approveApplyresult/edit2") 
	public Response<ApproveApplyResultResponse> edit2(@RequestBody Request<ApproveApplyResultReq> req);
	
}
