package site.leiwa.springframework;

import org.junit.jupiter.api.Test;

import site.leiwa.springframework.bean.IUserService;
import site.leiwa.springframework.content.support.ClassPathXmlApplicationContext;

/**
 * @desc: todo
 *
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @since 2022/12/2
 */
public class AnnotationTest {

    @Test
    public void test_scan() {
        ClassPathXmlApplicationContext applicationContext =
            new ClassPathXmlApplicationContext("classpath:spring-scan" + ".xml");
        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }
}
