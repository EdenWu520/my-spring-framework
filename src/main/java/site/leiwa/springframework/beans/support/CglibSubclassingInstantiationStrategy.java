package site.leiwa.springframework.beans.support;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.NoOp;
import site.leiwa.springframework.BeansException;
import site.leiwa.springframework.beans.config.BeanDefinition;

import java.lang.reflect.Constructor;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: Cglib 实例化策略
 * @since 2022/11/19
 */
public class CglibSubclassingInstantiationStrategy implements InstantiationStrategy {
    @Override
    public Object instantiate(String beanName, BeanDefinition beanDefinition, Constructor<?> ctor, Object[] args)
        throws BeansException {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(beanDefinition.getBeanClass());
        enhancer.setCallback(new NoOp() {
            @Override
            public int hashCode() {
                return super.hashCode();
            }
        });
        if (ctor != null) {
            return enhancer.create(ctor.getParameterTypes(), args);
        }
        return enhancer.create();
    }
}
