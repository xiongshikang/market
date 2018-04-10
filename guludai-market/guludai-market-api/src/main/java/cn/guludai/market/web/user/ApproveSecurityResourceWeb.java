/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.user;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.guludai.api.data.Request;
import cn.guludai.api.data.Response;
import cn.guludai.market.web.user.request.ApproveSecurityResourceEntityReq;
import cn.guludai.market.web.user.response.ApproveSecurityResourceEntityRep;
import cn.guludai.market.web.user.response.ZtreeResponse;
/**
 * 
 * @ClassName: ApproveSecurityResourceWeb 
 * @Description: 资源控制器
 * @author: xiongshikang
 * @date: 2017年12月13日 下午6:42:42
 */
public interface ApproveSecurityResourceWeb {
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月12日 下午4:09:42
	 * @Title: meunList 
	 * @Description: 资源tree
	 * @return
	 *
	 */
	@GetMapping("/web/resource/list")
	public  List<ApproveSecurityResourceEntityRep> meunList(Request<ApproveSecurityResourceEntityReq> request);

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
	@PostMapping("/web/resource/add")
	public Response<String> add(Request<ApproveSecurityResourceEntityReq> request);
	
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
	@PostMapping("/web/resource/edit")
	public Response<String> edit(Request<ApproveSecurityResourceEntityReq> request);
	
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
	@PostMapping("/web/resource/select")
	public Response<ApproveSecurityResourceEntityRep> select(@RequestBody Request<ApproveSecurityResourceEntityReq> request);
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月13日 下午12:12:31
	 * @Title: parentAll 
	 * @Description: 
	 * @return
	 *
	 */
	@GetMapping("/web/resource/all")
	public Response<ApproveSecurityResourceEntityRep> parentAll();
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月20日 下午4:37:36
	 * @Title: delete 
	 * @Description: 册除资源
	 * @param request
	 * @return
	 *
	 */
	@PostMapping("/web/resource/del")
	public Response<String> delete(Request<String> request) ;
}
