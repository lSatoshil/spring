package hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
//Spring4 新的注解，
//标志这个类是个控制类，
//是 @controller 和 @ResponseBody 的缩写
public class GreetingController {

    private static final String template = "Hello,%s!";

    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("greeting")
    //RequestMapping 注解确保所有的 /greeting 请求映射到方法 greeting()
    //上述例子并没有指明HTTP请求方式 get put post 等等，
    // RequestMapping默认映射所有的请求方式，
    // 可以使用RequestMapping(method=get),来指定请求方式
    public Greeting greeting(@RequestParam(value = "name" , defaultValue = "World") String name) {
    //@RequestParam将请求参数name和greeting()方法的name参数绑定，
    //默认值为 World
        return new Greeting(counter.incrementAndGet(),String.format(template,name));
        //返回对象 Greeting 必须转变为 JSON 格式，
        //但是 Spring 的 HTTP 消息转换器的支持，我们无需手动镜像转换，
        //Spring 的 MappingJackson2HttpMessageConverter 会帮我们进行转换
    }
}
