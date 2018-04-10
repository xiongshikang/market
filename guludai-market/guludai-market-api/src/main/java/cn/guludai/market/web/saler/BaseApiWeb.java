/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.saler;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import cn.guludai.api.data.Request;
import cn.guludai.api.data.Response;
import cn.guludai.market.api.saler.response.BaseShopResp;
import cn.guludai.market.web.response.TableResponse;
import cn.guludai.market.web.saler.request.BaseShopCompanyReq;
import cn.guludai.market.web.saler.response.AddressResponse;
import cn.guludai.market.web.saler.response.BaseShopCompanyResp;

/**
 * 
 * @ClassName: AddressWeb 
 * @Description: 地区服务
 * @author: xiongshikang
 * @date: 2017年12月18日 下午4:25:48
 */
public interface BaseApiWeb {
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月16日 上午10:06:21
	 * @Title: BaseErpFactoryList 
	 * @Description: 
	 * @return
	 *
	 */
	@GetMapping("/web/province")
	public Response<AddressResponse>  provinceList();
	
	
	@GetMapping("/web/city")
	public Response<AddressResponse>  cityList(Request<String> request);
	
	
	@GetMapping("/web/town")
	public Response<AddressResponse>  townList(Request<String> request);
	
	/**
     * 
     * @author: xiongshikang
     * @date: 2017年12月21日 下午1:24:00
     * @Title: companyList 
     * @Description: 获取公司列表
     * @param req
     * @return
     *
     */
    @GetMapping("/web/companyList")
    public Response<BaseShopCompanyResp> companyList();
    
    /**
     * 
     * @author: xiongshikang
     * @date: 2017年12月29日 上午11:25:28
     * @Title: companyListPage 
     * @Description: 分页查询公司信息
     * @param request
     * @return
     *
     */
    @PostMapping("/web/company")
    public TableResponse<BaseShopCompanyResp> companyListPage(Request<BaseShopCompanyReq> request);
    
    /**
     * 
     * @author: xiongshikang
     * @date: 2017年12月29日 上午11:40:08
     * @Title: selectConpany 
     * @Description: 通过编号查询公司信息
     * @param req
     * @return
     *
     */
    @PostMapping("/web/company/select")
    public Response<BaseShopCompanyResp> selectConpany(Request<String> req);
    
    /**
     * 
     * @author: xiongshikang
     * @date: 2017年12月29日 上午11:54:37
     * @Title: editCompany 
     * @Description: 修改公司信息
     * @param req
     * @return
     *
     */
    @PostMapping("/web/company/edit")
    public Response<String> editCompany(Request<BaseShopCompanyReq> req);
    
    /**
     * 
     * @author: xiongshikang
     * @date: 2017年12月29日 下午12:50:09
     * @Title: addCompany 
     * @Description: 添加公司
     * @param req
     * @return
     *
     */
    @PostMapping("/web/company/add")
    public Response<String> addCompany(Request<BaseShopCompanyReq> req);
    
    
    /**
     * 
     * @author: xiongshikang
     * @date: 2017年12月29日 下午12:50:09
     * @Title: addCompany 
     * @Description: 添加公司
     * @param req
     * @return
     *
     */
    @PostMapping("/web/company/delete")
    public Response<String> deleteCompany(Request<String> req);
    
    /**
     * 
     * @author: xiongshikang
     * @date: 2017年12月29日 上午11:40:08
     * @Title: selectConpany 
     * @Description: 通过编号查询公司信息
     * @param req
     * @return
     *
     */
    @PostMapping("/web/shop/select")
    public Response<BaseShopResp> selectShop(Request<String> req);
    
}
