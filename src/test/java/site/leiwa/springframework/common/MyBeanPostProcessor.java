package site.leiwa.springframework.common;

import site.leiwa.springframework.bean.UserService;
import site.leiwa.springframework.beans.BeansException;
import site.leiwa.springframework.beans.factory.config.BeanPostProcessor;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: BeanPostProcessor 在 Bean 对象执行初始化方法前后进行扩展
 * @since 2022/11/20
 */
public class MyBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        if ("userService".equals(beanName)) {
            UserService userService = (UserService) bean;
            userService.setLocation("改为：北京");
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }
}
