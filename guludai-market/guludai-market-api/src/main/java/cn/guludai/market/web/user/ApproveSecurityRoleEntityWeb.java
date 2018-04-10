/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.user;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import cn.guludai.api.data.Request;
import cn.guludai.api.data.Response;
import cn.guludai.market.web.response.TableResponse;
import cn.guludai.market.web.user.request.ApproveSecurityRoleEntityReq;
import cn.guludai.market.web.user.request.ZtreeRequest;
import cn.guludai.market.web.user.response.ApproveSecurityRoleEntityRep;
import cn.guludai.market.web.user.response.ZtreeResponse;

/**
 * 
 * @ClassName: ApproveSecurityRoleEntityWeb 
 * @Description: 角色控制器
 * @author: xiongshikang
 * @date: 2017年12月13日 下午6:42:36
 */
public interface ApproveSecurityRoleEntityWeb {
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月12日 下午4:09:42
	 * @Title: meunList 
	 * @Description: 角色列表
	 * @return
	 *
	 */
	@PostMapping("/web/role/list")
	public  TableResponse<ApproveSecurityRoleEntityRep> meunList(Request<ApproveSecurityRoleEntityReq> request);

	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月12日 下午5:09:27
	 * @Title: add 
	 * @Description: 添加 
	 * @param request
	 * @return
	 *
	 */
	@PostMapping("/web/role/add")
	public Response<String> add(Request<ApproveSecurityRoleEntityReq> request);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月12日 下午5:09:59
	 * @Title: edit 
	 * @Description: 修改
	 * @param request
	 * @return
	 *
	 */
	@PostMapping("/web/role/edit")
	public Response<String> edit(Request<ApproveSecurityRoleEntityReq> request);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月12日 下午5:47:31
	 * @Title: select 
	 * @Description: 查询单个资源数据
	 * @param request
	 * @return
	 *
	 */
	@PostMapping("/web/role/select")
	public Response<ApproveSecurityRoleEntityRep> select(@RequestBody Request<ApproveSecurityRoleEntityReq> request);
 
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
	@PostMapping("/web/role/zTree")
	public Response<ZtreeResponse> zTree(Request<String> request);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月14日 下午3:33:25
	 * @Title: setting 
	 * @Description: 设置角色资源
	 * @param request
	 * @return
	 *
	 */
	@PostMapping("/web/role/setting")
	public Response<String> setting(Request<ZtreeRequest> request);
	
}
