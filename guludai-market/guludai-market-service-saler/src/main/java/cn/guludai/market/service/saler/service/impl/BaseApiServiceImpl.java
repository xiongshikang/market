/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.service.saler.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.guludai.api.code.BaseCode;
import cn.guludai.api.data.Request;
import cn.guludai.api.data.Response;
import cn.guludai.framework.toolkit.id.GUID;
import cn.guludai.market.api.saler.response.BaseShopResp;
import cn.guludai.market.common.model.ResultModel;
import cn.guludai.market.service.saler.service.BaseApiService;
import cn.guludai.market.web.code.MarketBaseCode;
import cn.guludai.market.web.response.TableResponse;
import cn.guludai.market.web.saler.request.BaseShopCompanyReq;
import cn.guludai.market.web.saler.response.AddressResponse;
import cn.guludai.market.web.saler.response.BaseShopCompanyResp;
import cn.guludai.resource.api.BaseAreaApi;
import cn.guludai.resource.api.BaseShopApi;
import cn.guludai.resource.api.request.BaseShopCompanyRequest;
import cn.guludai.resource.api.request.BaseShopRequest;
import cn.guludai.resource.api.response.AreaResponse;
import cn.guludai.resource.api.response.BaseShopCompanyResponse;
import cn.guludai.resource.api.response.BaseShopResponse;
import cn.guludai.resource.api.response.ResourcePage;

@Service
public class BaseApiServiceImpl implements BaseApiService{

	@Autowired
	private BaseAreaApi baseAreaApi;
	@Autowired
	private BaseShopApi baseShopApi;
	
	@Override
	public List<AddressResponse> getProvince() throws Exception {
		Response<List<AreaResponse>> response =baseAreaApi.getProvince();
		List<AddressResponse> ls = new ArrayList<AddressResponse>();
		 for (AreaResponse a : response.getData()) {
			 AddressResponse b = new AddressResponse();
			 BeanUtils.copyProperties(b, a);
			 ls.add(b);
		 }
		return ls;
	}

	@Override
	public List<AddressResponse> getCity(String provinceNo) throws Exception{
		Response<List<AreaResponse>> response =baseAreaApi.getCity(provinceNo);
		List<AddressResponse> ls = new ArrayList<AddressResponse>();
		 for (AreaResponse a : response.getData()) {
			 AddressResponse b = new AddressResponse();
			 BeanUtils.copyProperties(b, a);
			 ls.add(b);
		 }
		return ls;
	}

	@Override
	public List<AddressResponse> getTown(String cityNo) throws Exception{
		Response<List<AreaResponse>> response =baseAreaApi.getTown(cityNo);
		List<AddressResponse> ls = new ArrayList<AddressResponse>();
		 for (AreaResponse a : response.getData()) {
			 AddressResponse b = new AddressResponse();
			 BeanUtils.copyProperties(b, a);
			 ls.add(b);
		 }
		 return ls;
	}
	

	@Override
	public List<BaseShopCompanyResp> getcompaynList() throws Exception{
		Request<BaseShopCompanyRequest> request = new Request<BaseShopCompanyRequest>();
		BaseShopCompanyRequest param = new BaseShopCompanyRequest();
		request.setData(param);
		Response<List<BaseShopCompanyResponse>> response =baseShopApi.findBaseShopCompany(request);
		List<BaseShopCompanyResp> ls = new ArrayList<BaseShopCompanyResp>();
		 for (BaseShopCompanyResponse a : response.getData()) {
			 BaseShopCompanyResp b = new BaseShopCompanyResp();
			 BeanUtils.copyProperties(b, a);
			 ls.add(b);
		 }
		 return ls;
	}
	
	@Override
	public TableResponse<BaseShopCompanyResp> getcompaynListPage(String companyName) throws Exception{
		Request<BaseShopCompanyRequest> request = new Request<BaseShopCompanyRequest>();
		TableResponse<BaseShopCompanyResp> result = new TableResponse<BaseShopCompanyResp>();
		BaseShopCompanyRequest param = new BaseShopCompanyRequest();
		param.setCompanyName(companyName);
		request.setData(param);
		Response<ResourcePage<BaseShopCompanyResponse>> response =baseShopApi.findBaseShopCompanyPage(request);
		if(response.getCode().equals(BaseCode.SUCCESS.getCode())) {
			List<BaseShopCompanyResp> ls = new ArrayList<BaseShopCompanyResp>();
			 for (BaseShopCompanyResponse a : response.getData().getList()) {
				 BaseShopCompanyResp b = new BaseShopCompanyResp();
				 BeanUtils.copyProperties(b, a);
				 ls.add(b);
			 }
			 result.setRows(ls);
			 result.setTotal(response.getData().getTotalCount());
		}
		
		 return result;
	}

	@Override
	public ResultModel<BaseShopCompanyResp> selectConpany(String companyCode) throws Exception{
		ResultModel<BaseShopCompanyResp> result = new ResultModel<BaseShopCompanyResp>();
		Request<BaseShopCompanyRequest> request = new Request<>();
		BaseShopCompanyRequest param = new BaseShopCompanyRequest();
		param.setCompanyCode(companyCode);
		request.setData(param);
		Response<BaseShopCompanyResponse> response = baseShopApi.findBaseShopCompanyDetail(request);
		BaseShopCompanyResp b = new BaseShopCompanyResp();
		if(response.getCode().equals(BaseCode.SUCCESS.getCode())) {
			BeanUtils.copyProperties(b, response.getData());
			 result.setCode(BaseCode.SUCCESS.getCode());
			 result.setResult(b);
			 return result;
		}else {
			result.setCode(MarketBaseCode.APP_USER_APPLY_SHOP_ERROR.getCode());
			return result;
		}
	}

	@Override
	public ResultModel<String> editCompany(BaseShopCompanyReq req)throws Exception {
		ResultModel<String> result = new ResultModel<String>();
		 Request<BaseShopCompanyRequest> request = new Request<BaseShopCompanyRequest>();
		 BaseShopCompanyRequest param = new BaseShopCompanyRequest();
		 BeanUtils.copyProperties(param, req);
		 request.setData(param);
		 Response<Void> response = baseShopApi.updateBaseShopCompany(request);
		if(response.getCode().equals(BaseCode.SUCCESS.getCode())) {
			result.setCode(BaseCode.SUCCESS.getCode());
			return result;
		}else {
			result.setCode(MarketBaseCode.COMPANY_LIST_ERROR.getCode());
			return result;
		}
	}
	
	@Override
	public ResultModel<String> addCompany(BaseShopCompanyReq req)throws Exception {
		ResultModel<String> result = new ResultModel<String>();
		Request<BaseShopCompanyRequest> request = new Request<BaseShopCompanyRequest>();
		BaseShopCompanyRequest param = new BaseShopCompanyRequest();
		BeanUtils.copyProperties(param, req);
		param.setCompanyCode(GUID.randomGUID());
		request.setData(param);
		Response<Void> response = baseShopApi.insertBaseShopCompany(request);
		if(response.getCode().equals(BaseCode.SUCCESS.getCode())) {
			result.setCode(BaseCode.SUCCESS.getCode());
			return result;
		}else {
			result.setCode(MarketBaseCode.COMPANY_INSERT_ERROR.getCode());
			return result;
		}
	}

	@Override
	public ResultModel<String> deleteCompany(String companyCode) throws Exception {
		ResultModel<String> result = new ResultModel<String>();
		Request<String> request = new Request<String>();
		request.setData(companyCode);
		Response<Void> response = baseShopApi.deleteBaseShopCompany(request);
		if(response.getCode().equals(BaseCode.SUCCESS.getCode())) {
			result.setCode(BaseCode.SUCCESS.getCode());
			return result;
		}else {
			result.setCode(MarketBaseCode.ERROR_SYS.getCode());
			return result;
		}
	}

	@Override
	public ResultModel<BaseShopResp> getBaseShopByShopCode(String shopCode) throws Exception{
		ResultModel<BaseShopResp> result = new ResultModel<BaseShopResp>();
		Request<BaseShopRequest> request = new Request<BaseShopRequest>();
		BaseShopRequest param = new BaseShopRequest();
	    param.setShopCode(shopCode);
	    request.setData(param);
	    Response<BaseShopResponse> response = baseShopApi.findBaseShopDetail(request);
	    if(response.getCode().equals(BaseCode.SUCCESS.getCode())) {
			result.setCode(BaseCode.SUCCESS.getCode());
			BaseShopResp resp = new BaseShopResp();
			BeanUtils.copyProperties(resp, response.getData());
			result.setResult(resp);
			return result;
		}else {
			result.setCode(MarketBaseCode.ERROR_SYS.getCode());
			return result;
		}
	}
	
	
}
