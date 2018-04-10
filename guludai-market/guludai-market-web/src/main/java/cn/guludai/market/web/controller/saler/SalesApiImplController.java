package cn.guludai.market.web.controller.saler;


import java.text.ParseException;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import cn.guludai.api.code.BaseCode;
import cn.guludai.api.data.Request;
import cn.guludai.api.data.Response;
import cn.guludai.market.api.saler.SalerApi;
import cn.guludai.market.api.saler.code.SalerCode;
import cn.guludai.market.api.saler.request.ApplyShopRequest;
import cn.guludai.market.api.saler.request.ApproveApplyCustomerReq;
import cn.guludai.market.api.saler.request.SalerRequest;
import cn.guludai.market.api.saler.response.ApproveApplyLoanResp;
import cn.guludai.market.api.saler.response.ApproveApplyResultResp;
import cn.guludai.market.api.saler.response.FlowNodeModel;
import cn.guludai.market.api.saler.response.FlowNodeParentModel;
import cn.guludai.market.api.saler.response.SalerResponse;
import cn.guludai.market.common.model.ResultModel;
import cn.guludai.market.service.saler.api.ReciveApplyShopService;

@RestController
public class SalesApiImplController implements SalerApi{
	
	private static final Logger logger = LoggerFactory.getLogger(SalesApiImplController.class);
	
	@Resource
	private ReciveApplyShopService reciveApplyShopApi;
	
	@Override
	public Response<SalerResponse> applyShop(@RequestBody Request<SalerRequest> request) {
		// TODO Auto-generated method stub
		return reciveApplyShopApi.insertApplyShop(request);
	}
	
	@Override
	public Response<FlowNodeParentModel> queryFlowListByApplyCode(@RequestBody Request<SalerRequest> request) {
 
		try {
			ResultModel<FlowNodeParentModel> result =  reciveApplyShopApi.queryFlowListByApplycode(request);
			if(result.getCode().equals(SalerCode.DATA_EMPTY.getCode())) {
				/**
				 * 无数据
				 */
				return Response.failure(SalerCode.DATA_EMPTY, SalerCode.DATA_EMPTY.getMessage());
			}else if(result.getCode().equals(SalerCode.APPLY_CODE_EMPTY.getCode())){
				/**
				 * 流水号参数错误
				 */
				return Response.failure(SalerCode.APPLY_CODE_EMPTY, SalerCode.APPLY_CODE_EMPTY.getMessage());
			}else {
				return Response.success(BaseCode.SUCCESS, result.getResult());
			}
		} catch (Exception e) {
			 logger.error("[日期转化错误:]" + e.getMessage(), e);
			 return Response.failure(BaseCode.ERROR);
		}
		
	}

	@Override
	public Response<FlowNodeModel> queryApplyRecordByApplyCode(@RequestBody Request<SalerRequest> request) {
		ResultModel<FlowNodeModel> result =  reciveApplyShopApi.queryApplyRecordByApplyCode(request);
        if(result.getCode().equals(SalerCode.APPLY_CODE_EMPTY.getCode())){
            /**
             * 流水号参数错误
             */
            return Response.failure(SalerCode.APPLY_CODE_EMPTY, SalerCode.APPLY_CODE_EMPTY.getMessage());
        }else {
            return Response.success(BaseCode.SUCCESS, result.getResult());
        }
    }

	@Override
	public Response<ApproveApplyLoanResp> selectApplyLoanByApplyCode(@RequestBody Request<ApplyShopRequest> request) {
		String applyCode = request.getData().getApplyCode();
		if(StringUtils.isBlank(applyCode)) {
			/**
			 * 流水单编号为空
			 */
			return Response.failure(SalerCode.APPLY_CODE_EMPTY, SalerCode.APPLY_CODE_EMPTY.getMessage());
		}
		ResultModel<ApproveApplyLoanResp> result = reciveApplyShopApi.selectApplyLoanByApplyCode(applyCode);
		if(result.getCode().equals(BaseCode.SUCCESS.getCode())) {
			return Response.success(BaseCode.SUCCESS, result.getResult());
		}
		return Response.failure(BaseCode.ERROR);
	}

	@Override
	public Response<List<ApproveApplyResultResp>> selectApplyCustomerByCustomerIdcard(@RequestBody
			Request<ApproveApplyCustomerReq> request) {
		  String customerIdcard = request.getData().getCustomerIdcard();
		if(StringUtils.isBlank(customerIdcard)) {
			/**
			 * 流水单编号为空
			 */
			return Response.failure(SalerCode.CUSTOMER_ID_CARD_EMPTY, SalerCode.CUSTOMER_ID_CARD_EMPTY.getMessage());
		}
		ResultModel<ApproveApplyResultResp> result = reciveApplyShopApi.selectApplyCustomerByCustomerIdcard(customerIdcard);
		if(result.getCode().equals(BaseCode.SUCCESS.getCode())) {
			return Response.success(BaseCode.SUCCESS, result.getLs());
		}
		return Response.failure(BaseCode.ERROR);
	}
	
}
