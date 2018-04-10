package cn.guludai.market.service.saler.api;

import cn.guludai.api.data.Request;
import cn.guludai.api.data.Response;
import cn.guludai.market.api.saler.request.SalerRequest;
import cn.guludai.market.api.saler.response.ApproveApplyLoanResp;
import cn.guludai.market.api.saler.response.ApproveApplyResultResp;
import cn.guludai.market.api.saler.response.FlowNodeModel;
import cn.guludai.market.api.saler.response.FlowNodeParentModel;
import cn.guludai.market.api.saler.response.SalerResponse;
import cn.guludai.market.common.model.ResultModel;



public interface ReciveApplyShopService {
	
	/**
	 * 
	 * @author: nijichao
	 * @date: 2017年11月13日 上午10:14:32
	 * @Title: getApplyShopList 
	 * @Description: 提供APP销售系统申请接口，然后插入数据库申请编号
	 * @param request
	 * @return
	 *
	 */
	
	public Response<SalerResponse>  insertApplyShop(Request<SalerRequest> request );
	
	/**
	 * 
	 * @author: nijichao
	 * @date: 2017年11月16日 下午5:23:27
	 * @Title: queryFlowListByApplycode 
	 * @Description: 根据applyCode查询流程列表
	 * @param request
	 * @return
	 *
	 */
	
	public ResultModel<FlowNodeParentModel> queryFlowListByApplycode(Request<SalerRequest> request) throws Exception;
	
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
	public ResultModel<ApproveApplyLoanResp> selectApplyLoanByApplyCode(String applyCode);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月2日 下午5:13:04
	 * @Title: selectApplyCustomerByCustomerIdcard 
	 * @Description: 通过身份证查询流水单信息（有多少）
	 * @param customerIdcard 身份证
	 * @return
	 *
	 */
	public ResultModel<ApproveApplyResultResp> selectApplyCustomerByCustomerIdcard(String customerIdcard);

	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月29日 上午9:54:33
	 * @Title: queryApplyRecordByApplyCode 
	 * @Description: 通过流程编号，获取流程结果
	 * @param request
	 * @return
	 *
	 */
    ResultModel<FlowNodeModel> queryApplyRecordByApplyCode(Request<SalerRequest> request);
}
		
	
