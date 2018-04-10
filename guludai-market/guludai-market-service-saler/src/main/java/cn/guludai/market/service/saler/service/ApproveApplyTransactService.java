/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.service.saler.service;

import cn.guludai.market.web.request.ApproveApplyResultReq;
import cn.guludai.market.web.response.ApproveApplyResultResponse;
import cn.guludai.market.web.response.TableResponse;

/**
 * 
 * @ClassName: ApproveApplyTransactService 
 * @Description: 办理或转交任务关服务类
 * @author: xiongshikang
 * @date: 2018年1月18日 下午7:13:15
 */
public interface ApproveApplyTransactService {
 
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月19日 上午10:16:58
	 * @Title: findTaskListByTransactUser 
	 * @Description: 查询办理过的历吏任务
	 * @param request
	 * @return
	 * @throws Exception
	 *
	 */
	public TableResponse<ApproveApplyResultResponse> findTaskListByTransactUser(
			ApproveApplyResultReq request) throws Exception ;
	
}
