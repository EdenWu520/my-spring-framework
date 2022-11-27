package site.leiwa.springframework.beans.factory.config;

import lombok.Data;
import site.leiwa.springframework.beans.PropertyValues;

import java.util.Locale;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: Bean 对象信息定义
 * @since 2022/11/19
 */
@Data
public class BeanDefinition {
    private Class<?> beanClass;

    String SCOPE_SINGLETON = ConfigurableBeanFactory.SCOPE_SINGLETON;

    String SCOPE_PROTOTYPE = ConfigurableBeanFactory.SCOPE_PROTOTYPE;

    private boolean singleton = true;

    private boolean prototype = false;

    private String scope = SCOPE_SINGLETON;
    private PropertyValues propertyValues;

    private String initMethodName;

    private String destroyMethodName;

    public BeanDefinition(Class<?> bean) {
        this(bean, null);
    }

    public BeanDefinition(Class<?> beanClass, PropertyValues propertyValues) {
        this.beanClass = beanClass;
        this.propertyValues = propertyValues != null ? propertyValues : new PropertyValues();
    }

    public void setScope(String scope) {
        this.scope = scope;
        this.singleton = SCOPE_SINGLETON.equals(scope.toLowerCase(Locale.ROOT));
        this.prototype = SCOPE_PROTOTYPE.equals(scope.toLowerCase(Locale.ROOT));
    }
}
