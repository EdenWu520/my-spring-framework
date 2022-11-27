package site.leiwa.springframework;

import org.junit.jupiter.api.Test;

import site.leiwa.springframework.content.support.ClassPathXmlApplicationContext;
import site.leiwa.springframework.event.CustomEvent;

/**
 * @desc: todo
 *
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @since 2022/11/27
 */
public class EventTest {
    @Test
    public void test_event() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.publishEvent(new CustomEvent(applicationContext, 1019129009086763L, "成功了！"));

        applicationContext.registerShutdownHook();
    }
}
