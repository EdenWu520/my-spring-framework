package site.leiwa.springframework.beans.config;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: Bean 对象信息定义
 * @since 2022/11/19
 */
public class BeanDefinition {
    private Class<?> beanClass;

    public BeanDefinition(Class<?> bean) {
        this.beanClass = bean;
    }

    public Class<?> getBeanClass() {
        return beanClass;
    }

    public void setBeanClass(Class<?> beanClass) {
        this.beanClass = beanClass;
    }
}
