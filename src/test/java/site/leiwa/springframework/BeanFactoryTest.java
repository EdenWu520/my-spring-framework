package site.leiwa.springframework;


import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import site.leiwa.springframework.bean.UserService;
import site.leiwa.springframework.beans.config.BeanDefinition;
import site.leiwa.springframework.beans.support.DefaultListableBeanFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

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
        Assertions.assertEquals(userService.queryUser(), "Eden");

        // 2. 有参注入Bean
        beanDefinition = new BeanDefinition(UserService.class);
        beanFactory.registerBeanDefinition("userService1", beanDefinition);

        // 5. 校验两个对象时候是同一个
        userService = (UserService) beanFactory.getBean("userService1", "张三");
        Assertions.assertEquals(userService.queryUser(), "张三");
    }

    @Test
    public void test_cglib() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(UserService.class);
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        Object obj = enhancer.create(new Class[]{String.class}, new Object[]{"张三"});
        System.out.println(obj);
    }

    @Test
    public void test_newInstance() throws IllegalAccessException, InstantiationException {
        UserService userService = UserService.class.newInstance();
        System.out.println(userService);
    }

    @Test
    public void test_constructor() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<UserService> userServiceClass = UserService.class;
        Constructor<UserService> declaredConstructor = userServiceClass.getDeclaredConstructor(String.class);
        UserService userService = declaredConstructor.newInstance("张三");
        System.out.println(userService);
    }

    @Test
    public void test_parameterTypes() throws Exception {
        Class<UserService> beanClass = UserService.class;
        Constructor<?>[] declaredConstructors = beanClass.getDeclaredConstructors();
        Constructor<?> constructor = declaredConstructors[0];
        Constructor<UserService> declaredConstructor = beanClass.getDeclaredConstructor(constructor.getParameterTypes());
        UserService userService = declaredConstructor.newInstance("张三");
        System.out.println(userService);
    }

}