/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.service.user.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.guludai.api.code.BaseCode;
import cn.guludai.framework.toolkit.id.GUID;
import cn.guludai.market.common.constants.BaseConstant;
import cn.guludai.market.common.model.ResultModel;
import cn.guludai.market.domain.dao.ApproveSecurityResourceEntityMapper;
import cn.guludai.market.domain.dao.ApproveSecurityRoleResourceEntityMapper;
import cn.guludai.market.domain.dao.ApproveSecurityUserMapper;
import cn.guludai.market.domain.dao.ApproveSecurityUserResourceEntityMapper;
import cn.guludai.market.domain.entity.ApproveSecurityResourceEntity;
import cn.guludai.market.domain.entity.ApproveSecurityRoleResourceEntity;
import cn.guludai.market.domain.entity.ApproveSecurityUser;
import cn.guludai.market.domain.entity.ApproveSecurityUserResourceEntity;
import cn.guludai.market.service.user.ApproveSecurityResourceEntityService;
import cn.guludai.market.web.user.request.ApproveSecurityResourceEntityReq;
import cn.guludai.market.web.user.response.ApproveSecurityResourceEntityRep;
import cn.guludai.market.web.user.response.MenuTree;
import cn.guludai.market.web.user.response.ZtreeResponse;

@Service
public class ApproveSecurityResourceEntityServiceImpl implements ApproveSecurityResourceEntityService {

	/**
	 * 从配置文件中读取超管用户名(账户)
	 */
	@Value("${security.admin}")
	private String admin;

	@Autowired
	private ApproveSecurityResourceEntityMapper approveSecurityResourceEntityMapper;
	@Autowired
	private ApproveSecurityUserMapper approveSecurityUserMapper;
	@Autowired
	private ApproveSecurityUserResourceEntityMapper approveSecurityUserResourceEntityMapper;
	@Autowired
	private ApproveSecurityRoleResourceEntityMapper approveSecurityRoleResourceEntityMapper;
	@Autowired
	private ShiroService shiroService;

	@Override
	@Transactional
	public ResultModel<ApproveSecurityResourceEntityRep> getResourceAll(ApproveSecurityResourceEntityReq record) throws Exception {
		ResultModel<ApproveSecurityResourceEntityRep> result = new ResultModel<ApproveSecurityResourceEntityRep>();
		/**
		 * 获取所有资源
		 */
		List<ApproveSecurityResourceEntity> ls = approveSecurityResourceEntityMapper.selectProveSecurityResourceEntity(record);
		List<ApproveSecurityResourceEntityRep> reps = new ArrayList<ApproveSecurityResourceEntityRep>();
		/**
		 * 转互成可以输出到页面展示的类
		 */
		for (ApproveSecurityResourceEntity a : ls) {
			ApproveSecurityResourceEntityRep rep = new ApproveSecurityResourceEntityRep();
			BeanUtils.copyProperties(rep, a);
			if (rep.getResourceType() == 0) {
				rep.setResourceTypeStr("功能");
			} else {
				rep.setResourceTypeStr("菜单");
			}
			reps.add(rep);
		}
		result.setLs(reps);
		result.setCode(BaseCode.SUCCESS.getCode());
		return result;
	}

	@Override
	public ResultModel<String> insert(ApproveSecurityResourceEntityReq req) throws Exception {
		ResultModel<String> result = new ResultModel<String>();
		ApproveSecurityResourceEntity entity = new ApproveSecurityResourceEntity();
		/**
		 * 添加资源，copy属性
		 */
		BeanUtils.copyProperties(entity, req);
		/**
		 * 生成唯一id
		 */
		String resourceCode = GUID.randomGUID();
		entity.setResourceCode(resourceCode);
		entity.setCreateTime(new Date());
		entity.setUpdateTime(new Date());
		entity.setVersion(1L);
		entity.setDataStatus(BaseConstant.DATA_STATUS_Y);
		entity.setDiskStatus(BaseConstant.DISK_STATUS_Y);
		approveSecurityResourceEntityMapper.insert(entity);
		/**
		 * 当添加新功能资源路径时，自动给超管管理员增加此路径权限
		 */
		addResourceForAdmin(admin, resourceCode);
		result.setCode(BaseCode.SUCCESS.getCode());
		return result;
	}

	@Override
	public ResultModel<String> edit(ApproveSecurityResourceEntityReq record) throws Exception {
		ResultModel<String> result = new ResultModel<String>();
		ApproveSecurityResourceEntity entity = new ApproveSecurityResourceEntity();
		BeanUtils.copyProperties(entity, record);
		/**
		 * 修改资源
		 */
		approveSecurityResourceEntityMapper.edit(entity);
		result.setCode(BaseCode.SUCCESS.getCode());
		return result;
	}

	@Override
	public ResultModel<ApproveSecurityResourceEntityRep> select(ApproveSecurityResourceEntityReq record) throws Exception {
		ResultModel<ApproveSecurityResourceEntityRep> result = new ResultModel<ApproveSecurityResourceEntityRep>();
		/**
		 * 通过资源编号查询资源信息
		 */
		ApproveSecurityResourceEntity entity = approveSecurityResourceEntityMapper.select(record.getResourceCode());
		ApproveSecurityResourceEntityRep rep = new ApproveSecurityResourceEntityRep();
		BeanUtils.copyProperties(rep, entity);
		result.setResult(rep);
		result.setCode(BaseCode.SUCCESS.getCode());
		return result;
	}

	@Override
	public ResultModel<ApproveSecurityResourceEntityRep> parentAll() throws Exception {
		ResultModel<ApproveSecurityResourceEntityRep> result = new ResultModel<ApproveSecurityResourceEntityRep>();
		/**
		 * 查询类型为菜单的资源信息
		 */
		List<ApproveSecurityResourceEntity> ls = approveSecurityResourceEntityMapper.resourceAllByResourceType(1);
		List<ApproveSecurityResourceEntityRep> reps = new ArrayList<ApproveSecurityResourceEntityRep>();
		for (ApproveSecurityResourceEntity a : ls) {
			ApproveSecurityResourceEntityRep rep = new ApproveSecurityResourceEntityRep();
			BeanUtils.copyProperties(rep, a);
			reps.add(rep);
		}
		result.setLs(reps);
		result.setCode(BaseCode.SUCCESS.getCode());
		return result;
	}

	@Override
	public ResultModel<ZtreeResponse> getzTreeAll(String roleCode) {
		ResultModel<ZtreeResponse> result = new ResultModel<ZtreeResponse>();
		List<ApproveSecurityRoleResourceEntity> roleSources = approveSecurityRoleResourceEntityMapper.getRoleResourcesByRocleCode(roleCode);
		List<ApproveSecurityResourceEntity> ls = approveSecurityResourceEntityMapper.selectProveSecurityResourceEntity(new ApproveSecurityResourceEntityReq());
		List<ZtreeResponse> reps = new ArrayList<ZtreeResponse>();
		for (ApproveSecurityResourceEntity a : ls) {
			boolean bl = true;
			for (ApproveSecurityRoleResourceEntity r : roleSources) {
				if (r.getResourceCode().equals(a.getResourceCode())) {
					/**
					 * 角色已有的权限,展示树节点为，选中状态
					 */
					ZtreeResponse rep = new ZtreeResponse();
					rep.setId(a.getResourceCode());
					rep.setName(a.getResourceName());
					rep.setpId(a.getResourceParentCode());
					rep.setChecked(true);
					rep.setOpen(true);
					reps.add(rep);
					bl = false;
					break;
				}
			}
			if (bl == true) {
				/**
				 * 角色未有的权限,展示树节点为，未选中状态
				 */
				ZtreeResponse rep = new ZtreeResponse();
				rep.setId(a.getResourceCode());
				rep.setName(a.getResourceName());
				rep.setpId(a.getResourceParentCode());
				rep.setChecked(false);
				rep.setOpen(true);
				reps.add(rep);
			}
		}
		result.setLs(reps);
		result.setCode(BaseCode.SUCCESS.getCode());
		return result;
	}

	@Override
	public ResultModel<ZtreeResponse> getzTreeAllForUser(String userCode) {
		ResultModel<ZtreeResponse> result = new ResultModel<ZtreeResponse>();
		List<ApproveSecurityResourceEntity> roleSources = approveSecurityResourceEntityMapper.getResourceByUserCode(userCode, null);
		List<ApproveSecurityResourceEntity> ls = approveSecurityResourceEntityMapper.selectProveSecurityResourceEntity(new ApproveSecurityResourceEntityReq());
		List<ZtreeResponse> reps = new ArrayList<ZtreeResponse>();
		for (ApproveSecurityResourceEntity a : ls) {
			boolean bl = true;
			for (ApproveSecurityResourceEntity r : roleSources) {
				if (r.getResourceCode().equals(a.getResourceCode())) {
					/**
					 * 用户已有的权限,展示树节点为，选中状态
					 */
					ZtreeResponse rep = new ZtreeResponse();
					rep.setId(a.getResourceCode());
					rep.setName(a.getResourceName());
					rep.setpId(a.getResourceParentCode());
					rep.setChecked(true);
					rep.setOpen(true);
					reps.add(rep);
					bl = false;
					break;
				}
			}
			if (bl == true) {
				/**
				 * 用户未有的权限,展示树节点为，未选中状态
				 */
				ZtreeResponse rep = new ZtreeResponse();
				rep.setId(a.getResourceCode());
				rep.setName(a.getResourceName());
				rep.setpId(a.getResourceParentCode());
				rep.setChecked(false);
				rep.setOpen(true);
				reps.add(rep);
			}
		}
		result.setLs(reps);
		result.setCode(BaseCode.SUCCESS.getCode());
		return result;
	}

	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月15日 上午11:03:44
	 * @Title: addResourceForAdmin
	 * @Description: 为超管添加权限
	 * @param userName
	 * @param resourceCode
	 *
	 */
	private void addResourceForAdmin(String userName, String resourceCode) {
		/**
		 * 每次添加资源的时候，给超管添加权限
		 */
		ApproveSecurityUser user = approveSecurityUserMapper.selectUserByUserName(userName);
		String userCode = user.getUserCode();
		ApproveSecurityUserResourceEntity entity = new ApproveSecurityUserResourceEntity();
		entity.setResourceCode(resourceCode);
		entity.setUserCode(userCode);
		entity.setCreateTime(new Date());
		entity.setUpdateTime(new Date());
		entity.setVersion(1L);
		entity.setDataStatus(BaseConstant.DATA_STATUS_Y);
		entity.setDiskStatus(BaseConstant.DISK_STATUS_Y);
		approveSecurityUserResourceEntityMapper.insert(entity);
	}

	@Override
	public List<MenuTree> getMeun(String userCode) {
		/**
		 * 通过用户权限关联表查出菜单资源
		 */
		List<ApproveSecurityResourceEntity> ls = approveSecurityResourceEntityMapper.getResourceByUserCode(userCode, 1);
		List<MenuTree> menuTrees = new ArrayList<MenuTree>();
		for (int i = 0; i < ls.size(); i++) {
			ApproveSecurityResourceEntity entity = ls.get(i);
			if (entity.getResourceParentCode().equals(BaseConstant.FAST_PARENT_ID)) {
				/**
				 * 如果是顶级节点
				 */
				MenuTree m = new MenuTree();
				m.setTitle(entity.getResourceName());
				m.setIcon(entity.getResourceIcon());
				m.setHref(entity.getResourceHref());
				m.setId(entity.getResourceCode());
				if (i == 0) {
					/**
					 * 展开第一个顶级节点
					 */
					m.setSpread(true);
				} else {
					/**
					 * 其它节点闭合,不展示下级
					 */
					m.setSpread(false);
				}
				menuTrees.add(m);
			}
		}
		for (MenuTree m : menuTrees) {
			List<MenuTree> mt = new ArrayList<MenuTree>();
			for (ApproveSecurityResourceEntity a : ls) {
				/**
				 * 添加子节点
				 */
				if (m.getId().equals(a.getResourceParentCode())) {
					MenuTree mm = new MenuTree();
					mm.setTitle(a.getResourceName());
					mm.setIcon(a.getResourceIcon());
					mm.setHref(a.getResourceHref());
					mt.add(mm);
				}
			}
			m.setChildren(mt);
		}
		return menuTrees;
	}

	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月20日 下午4:31:48
	 * @Title: deleteResourceByCode
	 * @Description: 册除权限，册除关联人员
	 * @param resourceCode
	 *
	 */
	@Transactional
	public ResultModel<String> deleteResourceByCode(String resourceCode) {
		ResultModel<String> result = new ResultModel<String>();
		approveSecurityResourceEntityMapper.deleteResourceByResourceCode(resourceCode);
		approveSecurityUserResourceEntityMapper.deleteUserResourceByResourceCode(resourceCode);
		approveSecurityRoleResourceEntityMapper.deleteRoleResourceByResourceCode(resourceCode);
		/**
		 * 更新权限
		 */
		shiroService.updatePermission();
		result.setCode(BaseCode.SUCCESS.getCode());
		return result;
	}
}
