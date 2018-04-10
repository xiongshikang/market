package cn.guludai.market.web.controller.saler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页控制器
 *
 * @author HenryYan
 */
@Controller
@RequestMapping("/main")
public class MainController {

    @RequestMapping(value = "/index")
    public String index() {
        return "admin/shop/shopList";
    }

    @RequestMapping(value = "/welcome")
    public String welcome() {
        return "/main/welcome";
    }

}
