/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.saler;

import org.springframework.web.bind.annotation.PostMapping;

import cn.guludai.api.data.Request;
import cn.guludai.market.web.request.ApproveApplyResultReq;
import cn.guludai.market.web.response.ApproveApplyResultResponse;
import cn.guludai.market.web.response.TableResponse;

/**
 * 
 * @ClassName: ApproveApplyTransactWeb 
 * @Description: 历吏任务与转交任务查询控制器
 * @author: xiongshikang
 * @date: 2018年1月19日 上午10:19:26
 */
public interface ApproveApplyTransactWeb {
	
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月16日 下午7:42:14
	 * @Title: selectUserByNodeCode 
	 * @Description:  个人历吏任务
	 * @param request
	 * @return
	 *
	 */
	@PostMapping("/web/approveApplyTransact/page")
	public TableResponse<ApproveApplyResultResponse> myHistoryTask(Request<ApproveApplyResultReq> request);
}
