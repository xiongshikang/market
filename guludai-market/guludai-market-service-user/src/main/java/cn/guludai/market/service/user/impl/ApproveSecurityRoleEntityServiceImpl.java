/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.service.user.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.guludai.api.code.BaseCode;
import cn.guludai.framework.toolkit.id.GUID;
import cn.guludai.market.common.constants.BaseConstant;
import cn.guludai.market.common.model.ResultModel;
import cn.guludai.market.domain.dao.ApproveSecurityRoleEntityMapper;
import cn.guludai.market.domain.dao.ApproveSecurityUserRoleEntityMapper;
import cn.guludai.market.domain.entity.ApproveSecurityRoleEntity;
import cn.guludai.market.domain.entity.ApproveSecurityUserRoleEntity;
import cn.guludai.market.service.user.ApproveSecurityRoleEntityService;
import cn.guludai.market.web.response.TableResponse;
import cn.guludai.market.web.user.request.ApproveSecurityRoleEntityReq;
import cn.guludai.market.web.user.response.ApproveSecurityRoleEntityRep;
import cn.guludai.market.web.user.response.ZtreeResponse;
@Service
public class ApproveSecurityRoleEntityServiceImpl implements ApproveSecurityRoleEntityService{
	
	@Autowired
	private ApproveSecurityRoleEntityMapper approveSecurityRoleEntityMapper;
	@Autowired
	private ApproveSecurityUserRoleEntityMapper approveSecurityUserRoleEntityMapper;
	
	@Override
	public TableResponse<ApproveSecurityRoleEntityRep> getRoleAll(ApproveSecurityRoleEntityReq record) throws Exception {
		TableResponse<ApproveSecurityRoleEntityRep> table = new TableResponse<ApproveSecurityRoleEntityRep>();
		List<ApproveSecurityRoleEntity> ls = approveSecurityRoleEntityMapper.selectApproveSecurityRoleEntity(record);
		Integer total = approveSecurityRoleEntityMapper.selectApproveSecurityRoleEntityCount(record);
		List<ApproveSecurityRoleEntityRep> reps = new ArrayList<ApproveSecurityRoleEntityRep>();
		for (ApproveSecurityRoleEntity a : ls) {
			ApproveSecurityRoleEntityRep rep = new ApproveSecurityRoleEntityRep();
			BeanUtils.copyProperties(rep,a);
			reps.add(rep);
		}
		table.setRows(reps);
		table.setTotal(total);
		return table;
	}
	
	@Override
	public ResultModel<String> insert(ApproveSecurityRoleEntityReq req) throws Exception{
		ResultModel<String> result = new ResultModel<String>();
		ApproveSecurityRoleEntity entity = new ApproveSecurityRoleEntity();
		BeanUtils.copyProperties(entity,req);
		entity.setRoleCode(GUID.randomGUID());
		entity.setCreateTime(new Date());
		entity.setUpdateTime(new Date());
		entity.setVersion(1L);
		entity.setDataStatus(BaseConstant.DATA_STATUS_Y);
		entity.setDiskStatus(BaseConstant.DISK_STATUS_Y);
		approveSecurityRoleEntityMapper.insert(entity);
		result.setCode(BaseCode.SUCCESS.getCode());
		return result;
	}
	
	@Override
	public ResultModel<String> edit(ApproveSecurityRoleEntityReq record) throws Exception{
		ResultModel<String> result = new ResultModel<String>();
		ApproveSecurityRoleEntity entity = new ApproveSecurityRoleEntity();
		BeanUtils.copyProperties(entity,record);
		/**
		 * 修改角色
		 */
		approveSecurityRoleEntityMapper.edit(entity);
		result.setCode(BaseCode.SUCCESS.getCode());
		return result;
	}

	@Override
	public ResultModel<ApproveSecurityRoleEntityRep> select(ApproveSecurityRoleEntityReq record)throws Exception {
		ResultModel<ApproveSecurityRoleEntityRep> result = new ResultModel<ApproveSecurityRoleEntityRep>();
		ApproveSecurityRoleEntity entity = approveSecurityRoleEntityMapper.select(record.getRoleCode());
		ApproveSecurityRoleEntityRep rep = new ApproveSecurityRoleEntityRep();
		BeanUtils.copyProperties(rep,entity);
		result.setResult(rep);
		result.setCode(BaseCode.SUCCESS.getCode());
		return result;
	}

	@Override
	public ResultModel<ZtreeResponse> getzTreeAllForRole(String userCode) {
		ResultModel<ZtreeResponse> result = new ResultModel<ZtreeResponse>();
		List<ApproveSecurityRoleEntity> ls = approveSecurityRoleEntityMapper.selectApproveSecurityRoleEntity(new ApproveSecurityRoleEntityReq());
		List<ApproveSecurityUserRoleEntity> userRoleLs = approveSecurityUserRoleEntityMapper.selectUserRoleByUserCode(userCode);
		List<ZtreeResponse> reps = new ArrayList<ZtreeResponse>();
		for (ApproveSecurityRoleEntity a : ls) {
			boolean bl = true;
			for (ApproveSecurityUserRoleEntity b : userRoleLs) {
				if(a.getRoleCode().equals(b.getRoleCode())) {
					/**
					 * 用户已有角色,展示树节点为，选中状态
					 */
					ZtreeResponse rep = new ZtreeResponse();
					 rep.setId(a.getRoleCode());
					 rep.setName(a.getRoleName());
					 rep.setpId("-1");
					 rep.setChecked(true);
					 rep.setOpen(true);
					 reps.add(rep);
					 bl = false;
					 break;
				}
			}
			if(bl==true) {
				/**
				 * 用户未有角色,展示树节点为，未选中状态
				 */
				ZtreeResponse rep = new ZtreeResponse();
				 rep.setId(a.getRoleCode());
				 rep.setName(a.getRoleName());
				 rep.setpId("-1");
				 rep.setChecked(false);
				 rep.setOpen(true);
				 reps.add(rep);
			}
		}
		result.setLs(reps);
		result.setCode(BaseCode.SUCCESS.getCode());
		return result;
	}
	
}