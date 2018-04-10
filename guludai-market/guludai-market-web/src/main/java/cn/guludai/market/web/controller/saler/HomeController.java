/**
 * 上海谨微数据服务有限公司
 */
package cn.guludai.market.web.controller.saler;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import cn.guludai.market.common.util.ClientIpUtil;
import cn.guludai.market.domain.entity.ApproveSecurityUser;
import cn.guludai.market.domain.entity.ApproveSecurityUserLoginLogEntity;
import cn.guludai.market.service.user.ApproveSecurityUserLoginLogService;
import cn.guludai.market.web.HomeWeb;

/**
 * 登录页面
 *
 * @author HenryYan
 */
@Controller
public class HomeController implements HomeWeb {
	
	@Autowired
	private ApproveSecurityUserLoginLogService approveSecurityUserLoginLogService;

	@Override
	public String login() {
		return "login";
	}
	
	@Override
	public String icon() {
		return "icon/icon";
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
    public String login(HttpServletRequest request, ApproveSecurityUser user, Model model){
        if (StringUtils.isEmpty(user.getUserName()) || StringUtils.isEmpty(user.getPassword())) {

            request.setAttribute("msg", "用户名或密码不能为空！");
            return "login";
        }
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(user.getUserName(),user.getPassword());
        try {
            subject.login(token);
            ApproveSecurityUserLoginLogEntity entity = new ApproveSecurityUserLoginLogEntity();
            entity.setClientIp(ClientIpUtil.getIpAddress(request));
            entity.setUserName(user.getUserName());
            entity.setUserCode(subject.getSession().getAttribute("userSessionId").toString());
            approveSecurityUserLoginLogService.add(entity);
            return "redirect:index";
        }catch (AuthenticationException e) {
            token.clear();
            request.setAttribute("msg", "用户或密码不正确！");
            return "login";
        }
    }
 
	@Override
	public String index() {
		return "index";
	}

	@Override
	public String main() {
		return "main";
	}
	
	@Override
    public String forbidden(){
        return "403";
    }
 
}
