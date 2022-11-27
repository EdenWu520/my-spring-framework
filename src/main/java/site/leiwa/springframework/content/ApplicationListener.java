package site.leiwa.springframework.content;

import java.util.EventListener;

/**
 * @desc: Interface to be implemented by application event listeners. Based on the standard
 *        <code>java.util.EventListener</code> interface for the Observer design pattern.
 *
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @since 2022/11/27
 */
public interface ApplicationListener<E extends ApplicationEvent> extends EventListener {
    /**
     * Handle an application event.
     * 
     * @param event the event to respond to
     */
    void onApplicationEvent(E event);
}
