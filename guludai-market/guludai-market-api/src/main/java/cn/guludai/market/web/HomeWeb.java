/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web;


import org.springframework.web.bind.annotation.GetMapping;
/**
 * 
 * @ClassName: HomeWeb 
 * @Description: 页面跳转控制类
 * @author: xiongshikang
 * @date: 2017年11月26日 下午4:19:48
 */
public interface HomeWeb {
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月26日 下午4:17:27
	 * @Title: login 
	 * @Description: 登录页
	 * @return
	 *
	 */
	@GetMapping(value = "/login")
	public String login();
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2018年2月27日 下午2:07:12
	 * @Title: icon 
	 * @Description: 图标展示
	 * @return
	 *
	 */
	@GetMapping(value = "/icon")
	public String icon();
 
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月26日 下午4:19:28
	 * @Title: index 
	 * @Description: 页面
	 * @return
	 *
	 */
	@GetMapping(value = "index")
	public String index();
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年11月26日 下午4:19:28
	 * @Title: index 
	 * @Description: 首页
	 * @return
	 *
	 */
	@GetMapping(value = "main")
	public String main();
	
	/**
	 * 
	 * @author: xiongshikang
	 * @date: 2017年12月15日 下午4:25:23
	 * @Title: forbidden 
	 * @Description: 无权页面
	 * @return
	 *
	 */
	@GetMapping("/403")
    public String forbidden();
	
}
