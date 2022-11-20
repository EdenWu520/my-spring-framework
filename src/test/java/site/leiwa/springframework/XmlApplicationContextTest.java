package site.leiwa.springframework;

import org.junit.jupiter.api.Test;
import site.leiwa.springframework.bean.UserService;
import site.leiwa.springframework.beans.factory.support.DefaultListableBeanFactory;
import site.leiwa.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import site.leiwa.springframework.common.MyBeanFactoryPostProcessor;
import site.leiwa.springframework.common.MyBeanPostProcessor;
import site.leiwa.springframework.content.support.ClassPathXmlApplicationContext;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: todo
 * @since 2022/11/20
 */
public class XmlApplicationContextTest {
    @Test
    public void test_BeanFactoryPostProcessorAndBeanPostProcessor() {
        // 1.初始化 BeanFactory
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();

        // 2. 读取配置文件&注册Bean
        XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(beanFactory);
        reader.loadBeanDefinitions("classpath:spring.xml");

        // 3. BeanDefinition 加载完成 & Bean实例化之前，修改 BeanDefinition 的属性值
        MyBeanFactoryPostProcessor beanFactoryPostProcessor = new MyBeanFactoryPostProcessor();
        beanFactoryPostProcessor.postProcessBeanFactory(beanFactory);

        // 4. Bean实例化之后，修改 Bean 属性信息
        MyBeanPostProcessor beanPostProcessor = new MyBeanPostProcessor();
        beanFactory.addBeanPostProcessor(beanPostProcessor);

        // 5. 获取Bean对象调用方法
        UserService userService = beanFactory.getBean("userService", UserService.class);
        String result = userService.queryUser();
        System.out.println("测试结果：" + result);
    }

    @Test
    public void test_xml() {
        // 1.初始化 BeanFactory
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:springPostProcessor.xml");

        // 2. 获取Bean对象调用方法
        UserService userService = applicationContext.getBean("userService", UserService.class);
        String result = userService.queryUser();
        System.out.println("测试结果：" + result);
    }

}
