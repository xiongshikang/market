/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.api.saler;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.guludai.api.data.Request;
import cn.guludai.api.data.Response;
import cn.guludai.market.api.saler.request.ApplyShopRequest;
import cn.guludai.market.api.saler.request.ApproveApplyCustomerReq;
import cn.guludai.market.api.saler.request.SalerRequest;
import cn.guludai.market.api.saler.response.ApproveApplyLoanResp;
import cn.guludai.market.api.saler.response.ApproveApplyResultResp;
import cn.guludai.market.api.saler.response.FlowNodeModel;
import cn.guludai.market.api.saler.response.FlowNodeParentModel;
import cn.guludai.market.api.saler.response.SalerResponse;

/**
 * @author gaopeng
 */
@FeignClient(name = "market-service", path = "/market")
@RequestMapping(path = "/api/shop")
public interface SalerApi {

	/**
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(path = "/apply", method = RequestMethod.POST)
	Response<SalerResponse> applyShop( Request<SalerRequest> request);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月22日 下午7:53:53
	 * @Title: queryFlowListByApplyCode 
	 * @Description: 查询流程进度集合
	 * @param request
	 * @return
	 *
	 */
	@RequestMapping(path = "/queryFlowListByApplycode", method = RequestMethod.POST)
	Response<FlowNodeParentModel> queryFlowListByApplyCode( Request<SalerRequest> request);


	/**
	 *
	 * @author: qiao.he
	 * @date: 2017年11月22日 下午7:53:53
	 * @Title: queryApplyRecordByApplyCode
	 * @Description: 查询流程进度
	 * @param request
	 * @return
	 *
	 */
	@RequestMapping(path = "/queryApplyRecordByApplyCode", method = RequestMethod.POST)
	Response<FlowNodeModel> queryApplyRecordByApplyCode( Request<SalerRequest> request);


	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月2日 上午11:55:49
	 * @Title: selectApplyResultByApplyCode 
	 * @Description: 通过流水号查找流水信息
	 * @param request
	 * @return
	 *
	 */
	@RequestMapping(path = "/selectApplyResultByApplyCode", method = RequestMethod.POST)
	public Response<ApproveApplyLoanResp> selectApplyLoanByApplyCode(Request<ApplyShopRequest> request);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月2日 下午5:14:35
	 * @Title: selectApplyCustomerByCustomerIdcard 
	 * @Description: 通过身份证查询流水单信息
	 * @param request
	 * @return
	 *
	 */
	@RequestMapping(path = "/selectApplyCustomerByCustomerIdcard", method = RequestMethod.POST)
	public Response<List<ApproveApplyResultResp>> selectApplyCustomerByCustomerIdcard(Request<ApproveApplyCustomerReq> request);

}
