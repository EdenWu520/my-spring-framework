package site.leiwa.springframework.beans.factory;

import site.leiwa.springframework.beans.BeansException;
import site.leiwa.springframework.beans.factory.config.AutowireCapableBeanFactory;
import site.leiwa.springframework.beans.factory.config.BeanDefinition;
import site.leiwa.springframework.beans.factory.config.ConfigurableBeanFactory;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: 提供分析和修改Bean对象与预计实例化的接口
 * @since 2022/11/20
 */
public interface ConfigurableListableBeanFactory
    extends ListableBeanFactory, AutowireCapableBeanFactory, ConfigurableBeanFactory {
    BeanDefinition getBeanDefinition(String beanName) throws BeansException;
}
