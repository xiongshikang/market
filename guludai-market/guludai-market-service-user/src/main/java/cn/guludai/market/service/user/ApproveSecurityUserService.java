/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.service.user;

import java.util.List;

import cn.guludai.market.common.model.ResultModel;
import cn.guludai.market.domain.entity.ApproveSecurityUser;
import cn.guludai.market.web.response.ApproveSecurityUserResponse;
import cn.guludai.market.web.response.TableResponse;
import cn.guludai.market.web.user.request.ApproveSecurityUserReq;

/**
 * 
 * @ClassName: ApproveSecurityUserService 
 * @Description: 管理员服务类
 * @author: xiongshikang
 * @date: 2017年11月26日 下午6:19:20
 */
public interface ApproveSecurityUserService {
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月30日 上午11:44:10
	 * @Title: getUserByUserName 
	 * @Description:  通过用户登录名查找用户
	 * @param userName 用户登录名
	 * @return
	 *
	 */
	public ApproveSecurityUser getUserByUserName(String userName);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月30日 上午11:44:07
	 * @Title: getAll 
	 * @Description: 查找所有用户信息
	 * @return
	 * @throws Exception
	 *
	 */
	public List<ApproveSecurityUserResponse> getAll() throws Exception;

	/**
	 *
	 * @author: qiao.he
	 * @date: 2017年12月4日 下午5:41:46
	 * @Title: register
	 * @Description: 用户注册
	 * @return
	 *
	 */
	public ResultModel register(ApproveSecurityUserReq data) throws Exception;

	/**
	 * Author: qiao.he
	 * Description: 修改用户信息
	 * Date: 2017/11/2 13:50
	 * param Request<UserRequest> 用户请求信息
	 */
	public ResultModel  editUser(ApproveSecurityUserReq data) throws Exception;

	/**
	 * Author: qiao.he
	 * Description: 获取用户信息
	 * Date: 2017/11/2 13:50
	 * param Request<UserRequest> 用户请求信息
	 */
	public ApproveSecurityUserResponse getUserInfo(String  userCode) throws Exception;

	/**
	 *
	 * @author: qiao.he
	 * @date: 2017年12月4日 下午4:07:30
	 * @Title: selectSecurityUserList
	 * @Description: 通过多条件查询用戶信息数据
	 * @param req
	 * @return
	 * @throws Exception
	 *
	 */
	public TableResponse<ApproveSecurityUserResponse> selectSecurityUserList(ApproveSecurityUserReq req) throws Exception;
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月5日 上午11:14:11
	 * @Title: deleteByUserCode 
	 * @Description: 逻辑册除用户
	 * @param userCode
	 *
	 */
	public ResultModel<String> deleteByUserCode(String userCode);
}
