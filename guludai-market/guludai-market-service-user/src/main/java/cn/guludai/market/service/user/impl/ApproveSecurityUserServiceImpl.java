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
import cn.guludai.market.common.util.PasswordHelper;
import cn.guludai.market.domain.dao.ApproveSecurityUserMapper;
import cn.guludai.market.domain.entity.ApproveSecurityUser;
import cn.guludai.market.domain.model.ApproveSecurityUserModel;
import cn.guludai.market.service.user.ApproveSecurityUserService;
import cn.guludai.market.web.code.MarketBaseCode;
import cn.guludai.market.web.code.UserCode;
import cn.guludai.market.web.response.ApproveSecurityUserResponse;
import cn.guludai.market.web.response.TableResponse;
import cn.guludai.market.web.user.request.ApproveSecurityUserReq;
@Service
public class ApproveSecurityUserServiceImpl implements ApproveSecurityUserService{
	
	@Autowired
	private ApproveSecurityUserMapper approveSecurityUserMapper;
 
	public ApproveSecurityUser getUserByUserName(String userName) {
		ApproveSecurityUser model = approveSecurityUserMapper.selectUserByUserName(userName);
		 return model ;
	}
	
	public List<ApproveSecurityUserResponse> getAll() throws Exception{
		/**
		 * 获取所有的用户信息
		 */
		List<ApproveSecurityUser> ls = approveSecurityUserMapper.selectAll();
		List<ApproveSecurityUserResponse> resultLs = new ArrayList<ApproveSecurityUserResponse>();
		for (ApproveSecurityUser entity : ls) {
			ApproveSecurityUserResponse req = new ApproveSecurityUserResponse();
			BeanUtils.copyProperties(req, entity);
			resultLs.add(req);
		}
		return resultLs;
	}

	@Override
	public ResultModel register(ApproveSecurityUserReq data)throws Exception {
		ResultModel resultModel = new ResultModel();
		if (approveSecurityUserMapper.selectUserByUserName(data.getUserName()) != null){
			resultModel.setCode(UserCode.USER_NAME_EXISTENCE_ERROR.getCode());
			return resultModel;
		}
		if (registerUser(data) < 1){
			resultModel.setCode(MarketBaseCode.ERROR_INVALID.getCode());
			return resultModel;
		}
		resultModel.setCode(BaseCode.SUCCESS.getCode());
		return resultModel;
	}

	@Override
	public ResultModel  editUser(ApproveSecurityUserReq data) throws Exception{
		ResultModel resultModel = new ResultModel();
		ApproveSecurityUser checkUserPwd = approveSecurityUserMapper.selectUserByUserCode(data.getUserCode());
		/** 如果密码一致， 则不修改密码字段*/
		if (checkUserPwd != null && checkUserPwd.getPassword().equals(data.getPassword())){
			data.setPassword(null);
		}else{
			/** 使用盐值加密 密码存入数据库*/
			data.setPassword(PasswordHelper.encryptPassword(data.getPassword(),checkUserPwd.getSalt()));
		}
		ApproveSecurityUser approveSecurityUser = new ApproveSecurityUser();
		BeanUtils.copyProperties(approveSecurityUser , data);
		if(approveSecurityUserMapper.updateByPrimaryKeySelective(approveSecurityUser)<1){
			resultModel.setCode(MarketBaseCode.ERROR_INVALID.getCode());
			return resultModel;
		}
		resultModel.setCode(BaseCode.SUCCESS.getCode());
		return resultModel;
	}

	@Override
	public ApproveSecurityUserResponse getUserInfo(String userCode)  throws Exception{
		ApproveSecurityUser approveSecurityUser = approveSecurityUserMapper.selectUserByUserCode(userCode);
		ApproveSecurityUserResponse approveSecurityUserResponse = new ApproveSecurityUserResponse();
		BeanUtils.copyProperties(approveSecurityUserResponse , approveSecurityUser);
		return approveSecurityUserResponse;
	}

	@Override
	public TableResponse<ApproveSecurityUserResponse> selectSecurityUserList(ApproveSecurityUserReq req) throws Exception{
		TableResponse<ApproveSecurityUserResponse> table = new TableResponse<>();
		TableResponse<ApproveSecurityUserResponse> applyShopPage = getSecurityUserListPage(req,req.getOffset(), req.getLimit());
		List<ApproveSecurityUserResponse> ls = applyShopPage.getRows();
		long total = applyShopPage.getTotal();
		table.setRows(ls);
		table.setTotal(total);
		return table;
	}

	private TableResponse<ApproveSecurityUserResponse> getSecurityUserListPage(ApproveSecurityUserReq req, int offset, int limit) throws Exception {
		TableResponse<ApproveSecurityUserResponse> tableResultResponse = new TableResponse<>();
		ApproveSecurityUserModel approveSecurityUserModel = new ApproveSecurityUserModel();
		BeanUtils.copyProperties(approveSecurityUserModel , req);
		approveSecurityUserModel.setDataStatus(BaseConstant.DATA_STATUS_Y);
		approveSecurityUserModel.setDiskStatus(BaseConstant.DISK_STATUS_Y);
		approveSecurityUserModel.setLimit(limit);
		approveSecurityUserModel.setOffset(offset);
		List<ApproveSecurityUserResponse> securityUserList = approveSecurityUserMapper.selectSecurityUserListPage(approveSecurityUserModel);
		tableResultResponse.setRows(securityUserList);
		tableResultResponse.setTotal(approveSecurityUserMapper.selectSecurityUserListNum(approveSecurityUserModel));
		return tableResultResponse;
	}


	/** 注册用户信息到数据库的方法*/
	private int registerUser(ApproveSecurityUserReq req) throws Exception{
		ApproveSecurityUser approveSecurityUser = new ApproveSecurityUser();
		BeanUtils.copyProperties(approveSecurityUser , req);
		String salt = PasswordHelper.generateKey();
		approveSecurityUser.setUserCode(GUID.randomGUID());
		approveSecurityUser.setParentCode("NIL");
		approveSecurityUser.setSalt(salt);
		approveSecurityUser.setPassword(PasswordHelper.encryptPassword(approveSecurityUser.getPassword(),salt));
		approveSecurityUser.setVersion(1L);
		approveSecurityUser.setDataStatus(BaseConstant.DATA_STATUS_Y);
		approveSecurityUser.setDiskStatus(BaseConstant.DISK_STATUS_Y);
		approveSecurityUser.setCreateTime(new Date());
		approveSecurityUser.setUpdateTime(new Date());
		return approveSecurityUserMapper.insertSelective(approveSecurityUser);
	}

	@Override
	public ResultModel<String> deleteByUserCode(String userCode) {
		ResultModel<String> result = new ResultModel<String>();
		ApproveSecurityUser model = new ApproveSecurityUser();
		model.setUserCode(userCode);
		model.setDataStatus(BaseConstant.DATA_STATUS_N);
		approveSecurityUserMapper.updateByPrimaryKeySelective(model);
		result.setCode(BaseCode.SUCCESS.getCode());
		return result;
	}
}
