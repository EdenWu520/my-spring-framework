package site.leiwa.springframework.beans.factory;

import site.leiwa.springframework.beans.BeansException;

import java.util.Map;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: 定义 Bean 工厂接口
 * @since 2022/11/19
 */
public interface BeanFactory {
    /**
     * 返回 Bean 的实例对象
     *
     * @param name 要检索的bean的名称
     * @return 实例化的 Bean 对象
     * @throws BeansException 不能获取 Bean 对象，则抛出异常
     */
    Object getBean(String name) throws BeansException;

    /**
     * 返回含构造函数的 Bean 实例对象
     *
     * @param name 要检索的bean的名称
     * @param args 构造函数入参
     * @return 实例化的 Bean 对象
     * @throws BeansException 不能获取 Bean 对象，则抛出异常
     */
    Object getBean(String name, Object... args) throws BeansException;

    /**
     * 返回指定泛型的对象
     *
     * @param name         要检索的bean的名称
     * @param requiredType 类型
     * @param <T>          泛型
     * @return 实例化的 Bean 对象
     * @throws BeansException 不能获取 Bean 对象，则抛出异常
     */
    <T> T getBean(String name, Class<T> requiredType) throws BeansException;
}
