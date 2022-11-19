package site.leiwa.springframework.beans;

import site.leiwa.springframework.BeansException;

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
}
