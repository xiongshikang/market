/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.domain.dao;

import java.util.List;

import cn.guludai.market.domain.entity.ApproveSecurityUser;
import cn.guludai.market.domain.model.ApproveSecurityUserModel;
import cn.guludai.market.web.response.ApproveSecurityUserResponse;

/**
 * 
 * @ClassName: ApproveSecurityUserMapper 
 * @Description: 管理员dao类
 * @author: xiongshikang
 * @date: 2017年11月26日 下午6:18:28
 */
public interface ApproveSecurityUserMapper {
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月26日 下午6:13:42
	 * @Title: selectUserByUserName 
	 * @Description: 通过用户名查找用户信息 
	 * @param userName 用户名
	 * @return
	 *
	 */
	ApproveSecurityUser selectUserByUserName(String userName);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月30日 上午11:35:12
	 * @Title: selectAll 
	 * @Description: 查询所有人员
	 * @return
	 *
	 */
	List<ApproveSecurityUser> selectAll();
	
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月30日 下午5:01:20
	 * @Title: selectUserByUserName 
	 * @Description: 用户编号找用户名
	 * @param userCode 用户编号
	 * @return
	 *
	 */
	ApproveSecurityUser selectUserByUserCode(String userCode);

	/**
	 *
	 * @author: qiao.he
	 * @date: 2017年11月30日 下午5:01:20
	 * @Title: insertSelective
	 * @Description: 用户注册
	 * @return
	 *
	 */
	int insertSelective(ApproveSecurityUser approveSecurityUser);

	/**
	 *
	 * @author: qiao.he
	 * @date: 2017年11月30日 下午5:01:20
	 * @Title: insertSelective
	 * @Description: 根据唯一键修改用户信息
	 * @return
	 *
	 */
	int updateByPrimaryKeySelective(ApproveSecurityUser approveSecurityUser);

	/**
	 *
	 * @author: qiao.he
	 * @date: 2017年11月30日 下午5:01:20
	 * @Title: insertSelective
	 * @Description: 分页查询
	 * @return
	 *
	 */
	List<ApproveSecurityUserResponse> selectSecurityUserListPage(ApproveSecurityUserModel approveSecurityUserModel);

	/**
	 *
	 * @author: qiao.he
	 * @date: 2017年11月30日 下午5:01:20
	 * @Title: insertSelective
	 * @Description: 查询总条数
	 * @return
	 *
	 */
	int selectSecurityUserListNum(ApproveSecurityUserModel approveSecurityUser);
}