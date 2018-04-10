/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.service.saler.service;

import cn.guludai.market.common.model.ResultModel;
import cn.guludai.market.web.saler.response.ApproveApplyCustomerResponse;

/**
 * 
 * @ClassName: ApproveApplyCustomerService 
 * @Description: 申请审批客户信息服务类
 * @author: xiongshikang
 * @date: 2018年1月6日 下午1:23:43
 */
public interface ApproveApplyCustomerService {
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年1月6日 下午1:32:40
	 * @Title: selectApplyCustomerByApplyCode 
	 * @Description: 通过流水号查询申请审批客户信息
	 * @param applyCode 流水号
	 * @return
	 *
	 */
	public ResultModel<ApproveApplyCustomerResponse> selectApplyCustomerByApplyCode(String applyCode)throws Exception;
}
