package hello;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {

    @JmsListener(destination = "mailbox", containerFactory = "myFactory")
    //@JmsListener 注解定义了该方法应该监听的目标名称
    //创建底层监听容器对 JmsListenerContainerFactory 的引用
    //最后一个属性可以在自定义 Spring Boot 注册默认工厂时构建容器的方式
    public void receiveMessage(Email email) {
        System.out.println("Received <" + email + ">");
    }
}
