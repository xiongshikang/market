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
import cn.guludai.market.domain.dao.ApproveSecurityUserRoleEntityMapper;
import cn.guludai.market.domain.entity.ApproveSecurityUserRoleEntity;
import cn.guludai.market.service.user.ApproveSecurityUserRoleEntityService;
import cn.guludai.market.web.user.request.ZtreeRequest;
@Service
public class ApproveSecurityUserRoleEntityServiceImpl implements ApproveSecurityUserRoleEntityService{
	
	@Autowired
	private ApproveSecurityUserRoleEntityMapper approveSecurityUserRoleEntityMapper;
	
	@Override
	public ResultModel<String> settingRoleUser(ZtreeRequest record) {
		ResultModel<String> result = new ResultModel<String>();
		String roleCodes = record.getCodeStr();
		String userCode = record.getUserCode();
		String[] roles = roleCodes.split(",");
		/**
		 * 在设置之前，先把之前的角色清空
		 */
		approveSecurityUserRoleEntityMapper.deleteByUserCode(userCode);
		/**
		 * 批量添加角色权限
		 */
		for (String s : roles) {
			/**
			 * 是否存在
			 */
			int count = approveSecurityUserRoleEntityMapper.selectCountByRoleCodeAndUserCode(s,userCode);
			if(count>0) {
				approveSecurityUserRoleEntityMapper.insertUserRole(s,userCode);
			}else {
				ApproveSecurityUserRoleEntity entity = new ApproveSecurityUserRoleEntity();
				entity.setRoleCode(s);
				entity.setUserCode(userCode);
				entity.setCreateTime(new Date());
				entity.setUpdateTime(new Date());
				entity.setVersion(1L);
				entity.setDataStatus(BaseConstant.DATA_STATUS_Y);
				entity.setDiskStatus(BaseConstant.DISK_STATUS_Y);
				approveSecurityUserRoleEntityMapper.insert(entity);
			}
		}
		result.setCode(BaseCode.SUCCESS.getCode());
		return result;
	}
}