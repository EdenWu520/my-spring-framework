package site.leiwa.springframework.beans.factory.support;

import site.leiwa.springframework.beans.BeansException;
import site.leiwa.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: Bean 实例化接口 这里使用了策略模式（这里主要有两种实现，Cglib和JDK的）
 * @since 2022/11/19
 */
// 策略模式适用于根据不同类型的动态，决定使用哪种策略这样一种应用场景
// https://time.geekbang.org/column/article/214014
public interface InstantiationStrategy {

    Object instantiate(String beanName, BeanDefinition beanDefinition, Constructor<?> ctor, Object[] args)
        throws BeansException;
}
