/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.guludai.api.data.Request;
import cn.guludai.api.data.Response;
import cn.guludai.market.web.response.ApproveSecurityUserResponse;
import cn.guludai.market.web.response.TableResponse;
import cn.guludai.market.web.user.request.ApproveSecurityUserReq;
import cn.guludai.market.web.user.request.ZtreeRequest;
import cn.guludai.market.web.user.response.ZtreeResponse;

/**
 *
 * @ClassName: SecurityUserWeb
 * @Description: 管理员控制器
 * @author: xiongshikang
 * @date: 2017年12月1日 下午5:46:34
 */
public interface SecurityUserWeb {


	/**
	 *
	 * @author: xiongshikang
	 * @date: 2017年12月1日 下午5:41:46
	 * @Title: list
	 * @Description: 查询所有管理员
	 * @return
	 *
	 */
	@PostMapping("/web/user")
	public Response<ApproveSecurityUserResponse> list();

	/**
	 *
	 * @author: qiao.he
	 * @date: 2017年12月1日 下午5:41:46
	 * @Title: approveSecurityUserResult
	 * @Description: 分页查询查询所有管理员
	 * @return
	 *
	 */
	@PostMapping("/web/user/page")
	TableResponse<ApproveSecurityUserResponse> approveSecurityUserResult(Request<ApproveSecurityUserReq> request);
	/**
	 *
	 * @author: qiao.he
	 * @date: 2017年12月4日 下午5:41:46
	 * @Title: register
	 * @Description: 用户注册
	 * @return
	 *
	 */
	@PostMapping("/web/user/add")
	public Response<ApproveSecurityUserResponse> add(Request<ApproveSecurityUserReq> request);


	/**
	 * Author: qiao.he
	 * Description: 修改用户信息
	 * Date: 2017/11/2 13:50
	 * param Request<UserRequest> 用户请求信息
	 */
	@RequestMapping(path = "/web/user/edit", method = RequestMethod.POST)
	Response<ApproveSecurityUserResponse> editUser(Request<ApproveSecurityUserReq> request);


	/**
	 * Author: qiao.he
	 * Description: 获取用户信息
	 * Date: 2017/11/2 13:50
	 * param Request<UserRequest> 用户请求信息
	 */
	@RequestMapping(path = "/web/user/select", method = RequestMethod.POST)
	Response<ApproveSecurityUserResponse> select(Request<String> request);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月5日 上午11:23:14
	 * @Title: delete 
	 * @Description: 逻辑册除
	 * @param req
	 * @return
	 *
	 */
	@RequestMapping(path = "/web/user/delete", method = RequestMethod.POST)
	public Response<String> delete(@RequestBody Request<String> req);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月14日 下午3:28:43
	 * @Title: zTree 
	 * @Description: 角色设置资源页
	 * @param request
	 * @return
	 *
	 */
	@PostMapping("/web/user/zTree")
	public Response<ZtreeResponse> zTree(Request<String> request);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月14日 下午6:04:33
	 * @Title: setting 
	 * @Description: 设置用户--资源
	 * @param request
	 * @return
	 *
	 */
	@PostMapping("/web/user/settingUserResource")
	public Response<String> settingUserResource(@RequestBody Request<ZtreeRequest> request);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月14日 下午7:10:20
	 * @Title: roleZTree 
	 * @Description: 角色树
	 * @return
	 *
	 */
	@PostMapping("/web/user/roleZTree")
	public Response<ZtreeResponse> roleZTree(@RequestBody Request<String> request);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月15日 上午10:38:51
	 * @Title: settingUserRole 
	 * @Description: 设置用户角色
	 * @param request
	 * @return
	 *
	 */
	@PostMapping("/web/user/settingUserRole")
	public Response<String> settingUserRole(@RequestBody Request<ZtreeRequest> request);
	
}
