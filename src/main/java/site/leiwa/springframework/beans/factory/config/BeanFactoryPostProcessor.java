package site.leiwa.springframework.beans.factory.config;

import site.leiwa.springframework.beans.BeansException;
import site.leiwa.springframework.beans.factory.ConfigurableListableBeanFactory;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: 允许自定义修改 BeanDefinition 属性信息
 * @since 2022/11/20
 */
public interface BeanFactoryPostProcessor {
    /**
     * 在所有的 BeanDefinition 加载完成后，实例化 Bean 对象之前，提供修改 BeanDefinition 属性的机制
     *
     * @param beanFactory
     * @throws BeansException
     */
    void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException;
}
