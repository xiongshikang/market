/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.service.user.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.guludai.api.code.BaseCode;
import cn.guludai.market.common.constants.BaseConstant;
import cn.guludai.market.common.model.ResultModel;
import cn.guludai.market.domain.dao.ApproveSecurityUserResourceEntityMapper;
import cn.guludai.market.domain.entity.ApproveSecurityUserResourceEntity;
import cn.guludai.market.service.user.ApproveSecurityUserResourceEntityService;
import cn.guludai.market.web.user.request.ZtreeRequest;
@Service
public class ApproveSecurityUserResourceEntityServiceImpl implements ApproveSecurityUserResourceEntityService{
	
	@Autowired
	private ApproveSecurityUserResourceEntityMapper aproveSecurityUserResourceEntityMapper;
	@Autowired
	private ApproveSecurityUserResourceEntityMapper approveSecurityUserResourceEntityMapper;
	
	@Override
	public ResultModel<String> settingUserResources(ZtreeRequest record) {
		ResultModel<String> result = new ResultModel<String>();
		String resourceCodes = record.getCodeStr();
		String userCode = record.getUserCode();
		String[] resources = resourceCodes.split(",");
		/**
		 * 在设置之前，先把之前的权限清空
		 */
		aproveSecurityUserResourceEntityMapper.deleteByUserCode(userCode);
		/**
		 * 批量添加角色权限
		 */
		for (String s : resources) {
			/**
			 * 是否存在
			 */
			Integer count = approveSecurityUserResourceEntityMapper.selectCountByResourceCodeAndUserCode(s,userCode);
			if(count!=null && count>0) {
				approveSecurityUserResourceEntityMapper.insertUserResource(s,userCode);
			}else {
				ApproveSecurityUserResourceEntity entity = new ApproveSecurityUserResourceEntity();
				entity.setResourceCode(s);
				entity.setUserCode(userCode);
				entity.setCreateTime(new Date());
				entity.setUpdateTime(new Date());
				entity.setVersion(1L);
				entity.setDataStatus(BaseConstant.DATA_STATUS_Y);
				entity.setDiskStatus(BaseConstant.DISK_STATUS_Y);
				approveSecurityUserResourceEntityMapper.insert(entity);
			}
		}
		result.setCode(BaseCode.SUCCESS.getCode());
		return result;
	}
}