/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.service.user.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.guludai.market.common.constants.BaseConstant;
import cn.guludai.market.domain.dao.ApproveSecurityUserLoginLogEntityMapper;
import cn.guludai.market.domain.entity.ApproveSecurityUserLoginLogEntity;
import cn.guludai.market.service.user.ApproveSecurityUserLoginLogService;
@Service
public class ApproveSecurityUserLoginLogServiceImpl implements ApproveSecurityUserLoginLogService{

	@Autowired
	private ApproveSecurityUserLoginLogEntityMapper approveSecurityUserLoginLogEntityMapper;
	
	@Override
	public void add(ApproveSecurityUserLoginLogEntity entity) {
		entity.setLoginTime(new Date());
		entity.setCreateTime(new Date());
		entity.setUpdateTime(new Date());
		entity.setVersion(1L);
		entity.setDataStatus(BaseConstant.DATA_STATUS_Y);
		entity.setDiskStatus(BaseConstant.DISK_STATUS_Y);
		approveSecurityUserLoginLogEntityMapper.insert(entity);
	}
	
}
