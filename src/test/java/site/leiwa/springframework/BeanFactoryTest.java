package site.leiwa.springframework;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import site.leiwa.springframework.bean.UserService;
import site.leiwa.springframework.beans.config.BeanDefinition;
import site.leiwa.springframework.beans.support.DefaultListableBeanFactory;

class BeanFactoryTest {

    @Test
    public void testBeanFactory() {
        // 1. 初始化BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 注入Bean
        BeanDefinition beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3. 获取使用Bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        Assertions.assertEquals(userService.queryUser(), "用户信息");

        // 4. 第二次获取 bean from Singleton
        UserService userServiceSingleton = (UserService) beanFactory.getBean("userService");
        Assertions.assertEquals(userServiceSingleton.queryUser(), "用户信息");

        // 5. 校验两个对象时候是同一个
        Assertions.assertEquals(System.identityHashCode(userService), System.identityHashCode(userServiceSingleton));
    }
}