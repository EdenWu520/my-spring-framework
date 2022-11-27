package site.leiwa.springframework.event;

import site.leiwa.springframework.content.ApplicationListener;
import site.leiwa.springframework.content.event.ContextClosedEvent;

public class ContextClosedEventListener implements ApplicationListener<ContextClosedEvent> {

    @Override
    public void onApplicationEvent(ContextClosedEvent event) {
        System.out.println("关闭事件：" + this.getClass().getName());
    }

}
