package site.leiwa.springframework.beans.support;

import site.leiwa.springframework.BeansException;
import site.leiwa.springframework.beans.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: Bean 实例化接口 这里使用了策略模式（这里主要有两种实现，Cglib和JDK的）
 * @since 2022/11/19
 */
public interface InstantiationStrategy {

    Object instantiate(String beanName, BeanDefinition beanDefinition, Constructor<?> ctor, Object[] args)
        throws BeansException;
}
