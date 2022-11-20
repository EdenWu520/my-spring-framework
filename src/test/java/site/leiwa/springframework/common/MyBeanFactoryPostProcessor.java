package site.leiwa.springframework.common;

import site.leiwa.springframework.beans.BeansException;
import site.leiwa.springframework.beans.PropertyValue;
import site.leiwa.springframework.beans.PropertyValues;
import site.leiwa.springframework.beans.factory.ConfigurableListableBeanFactory;
import site.leiwa.springframework.beans.factory.config.BeanDefinition;
import site.leiwa.springframework.beans.factory.config.BeanFactoryPostProcessor;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: BeanFactoryPostProcessor 实例化 Bean 对象之前，修改 BeanDefinition 属性
 * @since 2022/11/20
 */
public class MyBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
        BeanDefinition beanDefinition = beanFactory.getBeanDefinition("userService");
        PropertyValues propertyValues = beanDefinition.getPropertyValues();
        propertyValues.addPropertyValue(new PropertyValue("company", "改为：字节跳动"));
    }
}
