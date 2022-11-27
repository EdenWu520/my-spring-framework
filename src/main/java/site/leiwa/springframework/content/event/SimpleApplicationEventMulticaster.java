package site.leiwa.springframework.content.event;

import site.leiwa.springframework.beans.factory.BeanFactory;
import site.leiwa.springframework.content.ApplicationEvent;
import site.leiwa.springframework.content.ApplicationListener;

/**
 * @desc: Simple implementation of the {@link ApplicationEventMulticaster} interface.
 *
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @since 2022/11/27
 */
public class SimpleApplicationEventMulticaster extends AbstractApplicationEventMulticaster {
    public SimpleApplicationEventMulticaster(BeanFactory beanFactory) {
        setBeanFactory(beanFactory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public void multicastEvent(final ApplicationEvent event) {
        for (final ApplicationListener listener : getApplicationListeners(event)) {
            listener.onApplicationEvent(event);
        }
    }
}
