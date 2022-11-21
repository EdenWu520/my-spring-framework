package site.leiwa.springframework.beans.factory.support;

import cn.hutool.core.util.StrUtil;
import site.leiwa.springframework.beans.BeansException;
import site.leiwa.springframework.beans.factory.DisposableBean;
import site.leiwa.springframework.beans.factory.config.BeanDefinition;

import java.lang.reflect.Method;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: 定义销毁方法适配器
 * @since 2022/11/21
 */
// 适配器 https://time.geekbang.org/column/article/205912
public class DisposableBeanAdapter implements DisposableBean {
    private final Object bean;

    private final String beanName;

    private final String destroyMethodName;

    public  DisposableBeanAdapter(Object bean, String beanName, BeanDefinition beanDefinition) {
        this.bean = bean;
        this.beanName = beanName;
        this.destroyMethodName = beanDefinition.getDestroyMethodName();
    }

    @Override
    public void destroy() throws Exception {
        // 1. 实现接口 DisposableBean
        if (bean instanceof DisposableBean) {
            ((DisposableBean)bean).destroy();
        }

        // 2. 注解配置 destroy-method {判断是为了避免二次执行销毁}
        if (StrUtil.isNotEmpty(destroyMethodName) && !(bean instanceof DisposableBean && "destroy".equals(
            this.destroyMethodName))) {
            Method destroyMethod = bean.getClass().getMethod(destroyMethodName);
            if (null == destroyMethod) {
                throw new BeansException(
                    "Couldn't find a destroy method named '" + destroyMethodName + "' on bean with name '" + beanName + "'");
            }
            destroyMethod.invoke(bean);
        }
    }
}
