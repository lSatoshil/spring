package hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduledTasks {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    private static  final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

    @Scheduled(fixedRate = 5000)
    //@Scheduled 注解定义了方法什么时候执行
    //fixedRate 指定了方法执行间隔
    //fixedDelay 指定了任务执行完后和下个任务开始之间的间隔
    //@Scheduled(cron=". . .") 还可以使用这个方式定义任务执行时间
    public void reportCurrentTime() {
        logger.info("The time is now {}",dateFormat.format(new Date()));
    }
}
