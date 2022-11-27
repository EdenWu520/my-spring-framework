package site.leiwa.springframework.content;

import site.leiwa.springframework.beans.factory.HierarchicalBeanFactory;
import site.leiwa.springframework.beans.factory.ListableBeanFactory;
import site.leiwa.springframework.core.io.ResourceLoader;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: 应用上下文接口
 * @since 2022/11/20
 */
public interface ApplicationContext
    extends ListableBeanFactory, HierarchicalBeanFactory, ResourceLoader, ApplicationEventPublisher {}
