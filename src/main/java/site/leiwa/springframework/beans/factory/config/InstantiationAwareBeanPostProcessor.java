package site.leiwa.springframework.beans.factory.config;

import site.leiwa.springframework.beans.BeansException;
import site.leiwa.springframework.beans.PropertyValues;

/**
 * @desc: todo
 *
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @since 2022/11/29
 */
public interface InstantiationAwareBeanPostProcessor extends BeanPostProcessor {
    /**
     * Apply this BeanPostProcessor <i>before the target bean gets instantiated</i>. The returned bean object may be a
     * proxy to use instead of the target bean, effectively suppressing default instantiation of the target bean. ... ..
     * 在 Bean 对象执行初始化方法之前，执行此方法
     *
     * @param beanClass
     * @param beanName
     * @return
     * @throws BeansException
     */
    Object postProcessBeforeInstantiation(Class<?> beanClass, String beanName) throws BeansException;

    /**
     * Post-process the given property values before the factory applies them to the given bean. Allows for checking
     * whether all dependencies have been satisfied, for example based on a "Required" annotation on bean property
     * setters.
     * 
     * 在 Bean 对象实例化完成后，设置属性操作之前执行此方法
     * 
     * @param pvs
     * @param bean
     * @param beanName
     * @return
     * @throws BeansException
     */
    PropertyValues postProcessPropertyValues(PropertyValues pvs, Object bean, String beanName) throws BeansException;
}
