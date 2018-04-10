/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.service.saler.service;

import java.util.List;

import cn.guludai.market.api.saler.response.BaseShopResp;
import cn.guludai.market.common.model.ResultModel;
import cn.guludai.market.web.response.TableResponse;
import cn.guludai.market.web.saler.request.BaseShopCompanyReq;
import cn.guludai.market.web.saler.response.AddressResponse;
import cn.guludai.market.web.saler.response.BaseShopCompanyResp;

/**
 * 
 * @ClassName: AddressService 
 * @Description: 省份、城市、地区远程调用服务类
 * @author: xiongshikang
 * @date: 2017年12月18日 下午4:10:43
 */
public interface BaseApiService {
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月18日 下午4:16:45
	 * @Title: getProvince 
	 * @Description: 省份
	 * @return
	 *
	 */
	 public List<AddressResponse> getProvince()throws Exception;
	 
	 /**
	  * 
	  * @author: xiongshikang
	  * @date: 2017年12月18日 下午4:18:11
	  * @Title: getProvince 
	  * @Description: 城市
	  * @return
	  *
	  */
	 public List<AddressResponse> getCity(String code)throws Exception;
	 
	 /**
	  * 
	  * @author: xiongshikang
	  * @date: 2017年12月18日 下午4:19:21
	  * @Title: getTown 
	  * @Description: 地区
	  * @param code
	  *
	  */
	 public List<AddressResponse> getTown(String code)throws Exception;
	 
	 /**
	  * 
	  * @author: xiongshikang
	  * @date: 2017年12月21日 下午1:59:18
	  * @Title: getcompaynList 
	  * @Description: 公司列表
	  * @return
	  * @throws Exception
	  *
	  */
	 public List<BaseShopCompanyResp> getcompaynList() throws Exception;
	 
	 /**
	  * 
	  * @author: xiongshikang
	  * @date: 2017年12月29日 上午11:19:31
	  * @Title: getcompaynListPage 
	  * @Description: 分页查询公司信息
	  * @param companyName
	  * @return
	  * @throws Exception
	  *
	  */
	 public TableResponse<BaseShopCompanyResp> getcompaynListPage(String companyName) throws Exception;
	 
	 /**
	  * 
	  * @author: xiongshikang
	  * @date: 2017年12月29日 上午11:31:07
	  * @Title: selectConpany 
	  * @Description: 通过编号查询公司信息
	  * @param companyCode
	  * @return
	  *
	  */
	 public ResultModel<BaseShopCompanyResp> selectConpany(String companyCode) throws Exception;
	 
	 /**
	  * 
	  * @author: xiongshikang
	  * @date: 2017年12月29日 上午11:46:13
	  * @Title: editCompany 
	  * @Description: 编辑公司信息
	  * @param req
	  * @return
	  *
	  */
	 public ResultModel<String> editCompany(BaseShopCompanyReq req)throws Exception;
	 
	 /**
	  * 
	  * @author: xiongshikang
	  * @date: 2017年12月29日 上午11:58:50
	  * @Title: addCompany 
	  * @Description: 添加公司
	  * @param req
	  * @return
	  * @throws Exception
	  *
	  */
	 public ResultModel<String> addCompany(BaseShopCompanyReq req)throws Exception;
	 
	 /**
	  * 
	  * @author: xiongshikang
	  * @date: 2017年12月29日 下午1:17:01
	  * @Title: deleteCompany 
	  * @Description: 
	  * @param req
	  * @return
	  * @throws Exception
	  *
	  */
	 public ResultModel<String> deleteCompany(String companyCode)throws Exception;
	 
	 /**
	  * 
	  * @author: xiongshikang
	  * @date: 2018年1月8日 上午10:34:44
	  * @Title: getBaseShopByShopCode 
	  * @Description: 通过门店编号查找门店列表
	  * @param shopCode 门店编号
	  * @return
	  *
	  */
	 public ResultModel<BaseShopResp> getBaseShopByShopCode(String shopCode) throws Exception;
}

