package site.leiwa.springframework.beans.factory.support;

import site.leiwa.springframework.beans.BeansException;
import site.leiwa.springframework.core.io.Resource;
import site.leiwa.springframework.core.io.ResourceLoader;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: Bean Bean对象定义读取接口
 * @since 2022/11/20
 */
public interface BeanDefinitionReader {
    BeanDefinitionRegistry getRegistry();

    ResourceLoader getResourceLoader();

    void loadBeanDefinitions(Resource resource) throws BeansException;

    void loadBeanDefinitions(Resource... resources) throws BeansException;

    void loadBeanDefinitions(String location) throws BeansException;

    void loadBeanDefinitions(String... locations) throws BeansException;
}
