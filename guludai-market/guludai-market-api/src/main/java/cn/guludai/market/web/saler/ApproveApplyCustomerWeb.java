/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.saler;

import org.springframework.web.bind.annotation.PostMapping;

import cn.guludai.api.data.Request;
import cn.guludai.api.data.Response;
import cn.guludai.market.web.saler.response.ApproveApplyCustomerResponse;

/**
 * 
 * @ClassName: ApproveApplyCustomerWeb 
 * @Description: 申请审批客户信息控制器
 * @author: xiongshikang
 * @date: 2018年1月6日 下午1:37:45
 */
public interface ApproveApplyCustomerWeb {
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月7日 下午4:45:08
	 * @Title: selectPluginLicenseAllList 
	 * @Description: 通过流水号申请审批客户信
	 * @param request
	 * @return
	 *
	 */
	@PostMapping("/web/selectApplyCustomerByApplyCode")
	public Response<ApproveApplyCustomerResponse> selectApplyCustomerByApplyCode(Request<String> request);
}
