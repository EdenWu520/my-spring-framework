package site.leiwa.springframework.beans.support;

import site.leiwa.springframework.beans.config.BeanDefinition;
import site.leiwa.springframework.BeansException;
import site.leiwa.springframework.beans.BeanFactory;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: todo
 * @since 2022/11/19
 */
// 全称是模板方法设计模式。模板模式主要是用来解决复用和扩展两个问题
// https://time.geekbang.org/column/article/212049
public abstract class AbstractBeanFactory extends DefaultSingletonBeanRegistry implements BeanFactory {
    @Override
    public Object getBean(String name) throws BeansException {
        Object bean = getSingleton(name);
        if (bean != null) {
            return bean;
        }
        BeanDefinition beanDefinition = getBeanDefinition(name);
        return createBean(name, beanDefinition);
    }

    protected abstract BeanDefinition getBeanDefinition(String beanName);

    protected abstract Object createBean(String beanName, BeanDefinition beanDefinition);
}
