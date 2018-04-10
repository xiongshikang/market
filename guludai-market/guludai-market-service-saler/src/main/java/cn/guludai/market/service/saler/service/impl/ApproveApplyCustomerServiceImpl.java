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
import cn.guludai.market.common.model.ResultModel;
import cn.guludai.market.domain.dao.ApproveApplyCustomerEntityMapper;
import cn.guludai.market.domain.entity.ApproveApplyCustomerEntity;
import cn.guludai.market.service.saler.service.ApproveApplyCustomerService;
import cn.guludai.market.web.saler.response.ApproveApplyCustomerResponse;

@Service
public class ApproveApplyCustomerServiceImpl implements ApproveApplyCustomerService{
	
	@Autowired
	private ApproveApplyCustomerEntityMapper approveApplyCustomerEntityMapper;
	
	public ResultModel<ApproveApplyCustomerResponse> selectApplyCustomerByApplyCode(String applyCode) throws Exception {
		 ResultModel<ApproveApplyCustomerResponse> result = new  ResultModel<ApproveApplyCustomerResponse>();
		List<ApproveApplyCustomerEntity> ls = approveApplyCustomerEntityMapper.selectApplyCustomerByApplyCode(applyCode);
		List<ApproveApplyCustomerResponse> arr = new ArrayList<ApproveApplyCustomerResponse>();
		for(ApproveApplyCustomerEntity entity:ls) {
			ApproveApplyCustomerResponse response = new ApproveApplyCustomerResponse();
			BeanUtils.copyProperties(response, entity);
			arr.add(response);
		}
		result.setCode(BaseCode.SUCCESS.getCode());
		result.setLs(arr);
		return result;
	}
}
