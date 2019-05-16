package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.concurrent.CountDownLatch;

//Receiver 是一个简单的 POJO ，他定义了接收消息的方法
//当你把 Receiver 注册为一个消息监视器时，你可以随意命名消息处理方法
public class Receiver {

    private static final Logger logger = LoggerFactory.getLogger(Receiver.class);

    private CountDownLatch latch;

    @Autowired
    public Receiver(CountDownLatch latch) {
        this.latch = latch;
    }

    public void receiveMessage(String message) {
        logger.info("Received <" + message + ">");
        latch.countDown();
    }
}
