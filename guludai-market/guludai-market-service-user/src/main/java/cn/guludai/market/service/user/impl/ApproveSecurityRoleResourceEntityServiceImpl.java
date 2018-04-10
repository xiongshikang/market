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
import cn.guludai.market.domain.dao.ApproveSecurityRoleResourceEntityMapper;
import cn.guludai.market.domain.entity.ApproveSecurityRoleResourceEntity;
import cn.guludai.market.service.user.ApproveSecurityRoleResourceEntityService;
import cn.guludai.market.web.user.request.ZtreeRequest;
@Service
public class ApproveSecurityRoleResourceEntityServiceImpl implements ApproveSecurityRoleResourceEntityService{

	@Autowired
	private ApproveSecurityRoleResourceEntityMapper approveSecurityRoleResourceEntityMapper;
	
	@Override
	public ResultModel<String> settingRoleResources(ZtreeRequest record) {
		ResultModel<String> result = new ResultModel<String>();
		String resourceCodes = record.getCodeStr();
		String roleCode = record.getRoleCode();
		String[] resources = resourceCodes.split(",");
		/**
		 * 在设置之前，先把之前的权限清空
		 */
		approveSecurityRoleResourceEntityMapper.deleteByRoleCode(roleCode);
		/**
		 * 批量添加角色权限
		 */
		for (String s : resources) {
			/**
			 * 是否存在
			 */
			int count = approveSecurityRoleResourceEntityMapper.selectRoleResourceByResourceCodeAndRoleCode(s,roleCode);
			if(count>0) {
				approveSecurityRoleResourceEntityMapper.insertRoleResource(s,roleCode);
			}else {
				ApproveSecurityRoleResourceEntity entity = new ApproveSecurityRoleResourceEntity();
				entity.setResourceCode(s);
				entity.setRoleCode(roleCode);
				entity.setCreateTime(new Date());
				entity.setUpdateTime(new Date());
				entity.setVersion(1L);
				entity.setDataStatus(BaseConstant.DATA_STATUS_Y);
				entity.setDiskStatus(BaseConstant.DISK_STATUS_Y);
				approveSecurityRoleResourceEntityMapper.insert(entity);
			}
		}
		result.setCode(BaseCode.SUCCESS.getCode());
		return result;
	}
	
	
	
}