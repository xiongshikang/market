/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.saler;

import java.util.List;

import org.springframework.web.bind.annotation.PostMapping;

import cn.guludai.api.data.Request;
import cn.guludai.api.data.Response;
import cn.guludai.market.api.saler.request.SalerRequest;
import cn.guludai.market.api.saler.response.FlowNodeModel;
import cn.guludai.market.web.request.ApplyShopReq;
import cn.guludai.market.web.response.ApproveApplyResultResponse;
import cn.guludai.market.web.response.TableResponse;

/**
 * 
 * @ClassName: ApproveApplyRecordWeb 
 * @Description: 查看各各节点状态
 * @author: xiongshikang
 * @date: 2017年12月7日 下午4:50:05
 */
public interface ApproveApplyRecordWeb {
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月7日 下午4:45:08
	 * @Title: selectPluginLicenseAllList 
	 * @Description: 查看所有的未册除的流水信息
	 * @param request
	 * @return
	 *
	 */
	@PostMapping("/web/approveApplyRecord")
	public TableResponse<ApproveApplyResultResponse> selectPluginLicenseAllList(Request<ApplyShopReq> request);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月7日 下午5:16:37
	 * @Title: queryFlowListByApplyCodeForBs 
	 * @Description: 
	 * @param request
	 * @return
	 *
	 */
	@PostMapping("/web/approveApplyRecord/nodeList")
	public Response<List<FlowNodeModel>> queryFlowListByApplyCodeForBs(Request<SalerRequest> request);
}
