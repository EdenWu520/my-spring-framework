package site.leiwa.springframework;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import site.leiwa.springframework.bean.UserService;

class BeanFactoryTest {

    @Test
    public void testBeanFactory() {
        // 1. 初始化BeanFactory
        BeanFactory beanFactory = new BeanFactory();

        // 2. 注入Bean
        BeanDefinition beanDefinition = new BeanDefinition(new UserService());
        beanFactory.registerBeanDefinition("userService", beanDefinition);

        // 3. 获取使用Bean
        UserService userService = (UserService) beanFactory.getBean("userService");
        Assertions.assertEquals(userService.queryUser(), "用户信息");
    }
}