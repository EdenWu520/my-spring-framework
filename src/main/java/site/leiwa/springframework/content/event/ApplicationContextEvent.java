package site.leiwa.springframework.content.event;

import site.leiwa.springframework.content.ApplicationContext;
import site.leiwa.springframework.content.ApplicationEvent;

/**
 * @desc: 事件的关闭，刷新及用户自己实现的事件基类
 *
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @since 2022/11/27
 */
public class ApplicationContextEvent extends ApplicationEvent {
    /**
     * Constructs a prototypical Event.
     *
     * @param source the object on which the Event initially occurred
     * @throws IllegalArgumentException if source is null
     */
    public ApplicationContextEvent(Object source) {
        super(source);
    }

    /**
     * Get the <code>ApplicationContext</code> that the event was raised for.
     */
    public final ApplicationContext getApplicationContext() {
        return (ApplicationContext)getSource();
    }
}
