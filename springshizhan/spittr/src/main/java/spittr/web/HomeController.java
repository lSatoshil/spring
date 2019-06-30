package spittr.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

//申明一个控制器
@Controller
@RequestMapping({"/","/homepage"})
public class HomeController {

    //处理对 "/" 的 GET 请求
    @RequestMapping(method = GET)
    public String home(){
        //视图名为 home
        return "home";
    }
}
