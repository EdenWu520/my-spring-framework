package site.leiwa.springframework.beans.factory.config;

import lombok.Data;
import site.leiwa.springframework.beans.PropertyValues;
import site.leiwa.springframework.beans.factory.InitializingBean;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: Bean 对象信息定义
 * @since 2022/11/19
 */
@Data
public class BeanDefinition {
    private Class<?> beanClass;

    private PropertyValues propertyValues;

    private String initMethodName;

    private String destroyMethodName;

    public BeanDefinition(Class<?> bean) {
        this.beanClass = bean;
        this.propertyValues = new PropertyValues();
    }

    public BeanDefinition(Class<?> beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }
}
