package site.leiwa.springframework;

import org.junit.jupiter.api.Test;
import site.leiwa.springframework.bean.UserService;
import site.leiwa.springframework.content.support.ClassPathXmlApplicationContext;

/**
 * @desc: Bean初始化的销毁
 *
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @since 2022/11/21
 */
public class InitDestroyMethodTest {
    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");
        applicationContext.registerShutdownHook();

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUser();
        System.out.println("测试结果：" + result);
    }


    @Test
    public void test_hook() {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> System.out.println("close！")));
    }
}
