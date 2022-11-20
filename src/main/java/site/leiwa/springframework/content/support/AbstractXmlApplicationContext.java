package site.leiwa.springframework.content.support;

import site.leiwa.springframework.beans.factory.support.DefaultListableBeanFactory;
import site.leiwa.springframework.beans.factory.xml.XmlBeanDefinitionReader;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: 抽象基类 XML 上下文
 * @since 2022/11/20
 */
public abstract class AbstractXmlApplicationContext extends AbstractRefreshableApplicationContext {
    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) {
        XmlBeanDefinitionReader beanDefinitionReader = new XmlBeanDefinitionReader(beanFactory, this);
        String[] configLocations = getConfigLocations();
        if (configLocations != null) {
            beanDefinitionReader.loadBeanDefinitions(configLocations);
        }

    }

    protected abstract String[] getConfigLocations();
}
