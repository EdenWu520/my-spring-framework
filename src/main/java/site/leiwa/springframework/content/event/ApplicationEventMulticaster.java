package site.leiwa.springframework.content.event;

import site.leiwa.springframework.content.ApplicationEvent;
import site.leiwa.springframework.content.ApplicationListener;

/**
 * @desc: 事件广播器
 * 
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @since 2022/11/27
 */
public interface ApplicationEventMulticaster {
    /**
     * Add a listener to be notified of all events.
     * 
     * @param listener the listener to add
     */
    void addApplicationListener(ApplicationListener<?> listener);

    /**
     * Remove a listener from the notification list.
     * 
     * @param listener the listener to remove
     */
    void removeApplicationListener(ApplicationListener<?> listener);

    /**
     * Multicast the given application event to appropriate listeners.
     * 
     * @param event the event to multicast
     */
    void multicastEvent(ApplicationEvent event);
}
