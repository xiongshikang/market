/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.controller.saler;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.guludai.api.code.BaseCode;
import cn.guludai.api.data.Request;
import cn.guludai.api.data.Response;
import cn.guludai.market.api.saler.response.BaseShopResp;
import cn.guludai.market.common.model.ResultModel;
import cn.guludai.market.service.saler.service.BaseApiService;
import cn.guludai.market.web.code.MarketBaseCode;
import cn.guludai.market.web.response.TableResponse;
import cn.guludai.market.web.saler.BaseApiWeb;
import cn.guludai.market.web.saler.request.BaseShopCompanyReq;
import cn.guludai.market.web.saler.response.AddressResponse;
import cn.guludai.market.web.saler.response.BaseShopCompanyResp;

@Controller
public class BaseApiController implements BaseApiWeb{
	
	private static final Logger logger = LoggerFactory.getLogger(BaseApiController.class);

	@Autowired
	private BaseApiService baseApiService;
	
	
	
	@Override
	@ResponseBody
	public Response<AddressResponse> provinceList() {
		List<AddressResponse> ls;
		try {
			ls = baseApiService.getProvince();
		} catch (Exception e) {
			logger.error("[系统运行错误:]" + e.getMessage(), e);
			return Response.failure(MarketBaseCode.ERROR_SYS, MarketBaseCode.ERROR_SYS.getMessage());
		}
		return Response.success(BaseCode.SUCCESS, ls);
	}

	@Override
	@ResponseBody
	public Response<AddressResponse> cityList(Request<String> request) {
		List<AddressResponse> ls;
		String code = request.getData();
		try {
			ls = baseApiService.getCity(code);
		} catch (Exception e) {
			logger.error("[系统运行错误:]" + e.getMessage(), e);
			return Response.failure(MarketBaseCode.ERROR_SYS, MarketBaseCode.ERROR_SYS.getMessage());
		}
		return Response.success(BaseCode.SUCCESS, ls);
	}

	@Override
	@ResponseBody
	public Response<AddressResponse> townList(Request<String> request) {
		List<AddressResponse> ls;
		String code = request.getData();
		try {
			ls = baseApiService.getTown(code);
		} catch (Exception e) {
			logger.error("[系统运行错误:]" + e.getMessage(), e);
			return Response.failure(MarketBaseCode.ERROR_SYS, MarketBaseCode.ERROR_SYS.getMessage());
		}
		return Response.success(BaseCode.SUCCESS, ls);
	}

	@Override
	@ResponseBody
	public Response<BaseShopCompanyResp> companyList() {
		List<BaseShopCompanyResp> ls;
		try {
			ls = baseApiService.getcompaynList();
		} catch (Exception e) {
			logger.error("[系统运行错误:]" + e.getMessage(), e);
			return Response.failure(MarketBaseCode.ERROR_SYS, MarketBaseCode.ERROR_SYS.getMessage());
		}
		return Response.success(BaseCode.SUCCESS, ls);
	}
	
	@Override
	@ResponseBody
	public TableResponse<BaseShopCompanyResp> companyListPage(@RequestBody Request<BaseShopCompanyReq> request) {
		TableResponse<BaseShopCompanyResp> result;
		try {
			result = baseApiService.getcompaynListPage(request.getData().getCompanyName());
		} catch (Exception e) {
			logger.error("[系统运行错误:]" + e.getMessage(), e);
			 return null;
		}
		return result;
	}

	@Override
	@ResponseBody
	public Response<BaseShopCompanyResp> selectConpany(@RequestBody Request<String> req){
		String companyCode = req.getData();
		try {
			ResultModel<BaseShopCompanyResp> result = baseApiService.selectConpany(companyCode);
			if(result.getCode().equals(MarketBaseCode.APP_USER_APPLY_SHOP_ERROR.getCode())) {
				/**
				 * 远程数据获取失败
				 */
				return Response.failure(MarketBaseCode.APP_USER_APPLY_SHOP_ERROR, MarketBaseCode.APP_USER_APPLY_SHOP_ERROR.getMessage());
			}
			return Response.success(MarketBaseCode.SUCCESS, result);
		} catch (Exception e) {
			logger.error("[系统运行错误:]" + e.getMessage(), e);
			return Response.failure(MarketBaseCode.ERROR_SYS, MarketBaseCode.ERROR_SYS.getMessage());
		}
	}
	
	@Override
	@ResponseBody
	public Response<String> editCompany(@RequestBody Request<BaseShopCompanyReq> req) {
		BaseShopCompanyReq request = req.getData();
		try {
			 ResultModel<String> result = baseApiService.editCompany(request);
			 if(result.getCode().equals(MarketBaseCode.COMPANY_LIST_ERROR.getCode())) {
				 return Response.failure(MarketBaseCode.COMPANY_LIST_ERROR, MarketBaseCode.COMPANY_LIST_ERROR.getMessage());
			 }
			return Response.success(MarketBaseCode.SUCCESS);
		} catch (Exception e) {
			logger.error("[系统运行错误:]" + e.getMessage(), e);
			return Response.failure(MarketBaseCode.ERROR_SYS, MarketBaseCode.ERROR_SYS.getMessage());
		}
	}
	
	@Override
	@ResponseBody
	public Response<String> addCompany(@RequestBody Request<BaseShopCompanyReq> req) {
		BaseShopCompanyReq request = req.getData();
		try {
			 ResultModel<String> result = baseApiService.addCompany(request);
			 if(result.getCode().equals(MarketBaseCode.COMPANY_INSERT_ERROR.getCode())) {
				 return Response.failure(MarketBaseCode.COMPANY_INSERT_ERROR, MarketBaseCode.COMPANY_INSERT_ERROR.getMessage());
			 }
			return Response.success(MarketBaseCode.SUCCESS);
		} catch (Exception e) {
			logger.error("[系统运行错误:]" + e.getMessage(), e);
			return Response.failure(MarketBaseCode.ERROR_SYS, MarketBaseCode.ERROR_SYS.getMessage());
		}
	}
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月29日 下午1:09:03
	 * @Title: editCompany 
	 * @Description: 公司信息编辑页面
	 * @return
	 *
	 */
	@GetMapping("/company")
	public String company() {
		return "admin/shopCompany/list";
	}
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月29日 下午1:13:25
	 * @Title: editCompany 
	 * @Description: 编辑公司信息
	 * @return
	 *
	 */
	@GetMapping("/company/edit")
	public String editCompany() {
		 return "admin/shopCompany/edit";
	}

	@Override
	@ResponseBody
	public Response<String> deleteCompany(@RequestBody Request<String> req) {
		String companyCode = req.getData();
		try {
			 ResultModel<String> result = baseApiService.deleteCompany(companyCode);
			 if(result.getCode().equals(MarketBaseCode.ERROR_SYS.getCode())) {
				 return Response.failure(MarketBaseCode.ERROR_SYS, MarketBaseCode.ERROR_SYS.getMessage());
			 }
			return Response.success(MarketBaseCode.SUCCESS);
		} catch (Exception e) {
			logger.error("[系统运行错误:]" + e.getMessage(), e);
			return Response.failure(MarketBaseCode.ERROR_SYS, MarketBaseCode.ERROR_SYS.getMessage());
		}
	}

	@Override
	@ResponseBody
	public Response<BaseShopResp> selectShop(@RequestBody Request<String> req) {
		String shopCode = req.getData();
		ResultModel<BaseShopResp> result ;
		try {
			result = baseApiService.getBaseShopByShopCode(shopCode);
			return Response.success(MarketBaseCode.SUCCESS,result.getResult());
		} catch (Exception e) {
			logger.error("[系统运行错误:]" + e.getMessage(), e);
			return Response.failure(MarketBaseCode.ERROR_SYS, MarketBaseCode.ERROR_SYS.getMessage());
		}
	}
	
}
