package site.leiwa.springframework.beans.factory.config;

import site.leiwa.springframework.beans.factory.BeanFactory;

/**
 * @desc: todo
 *
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @since 2022/11/20
 */
public interface ConfigurableBeanFactory extends BeanFactory {
    String SCOPE_SINGLETON = "singleton";

    String SCOPE_PROTOTYPE = "prototype";

    void addBeanPostProcessor(BeanPostProcessor beanPostProcessor);

    /**
     * 销毁单例对象
     */
    void destroySingletons();
}
