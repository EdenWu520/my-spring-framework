package site.leiwa.springframework.event;

import site.leiwa.springframework.content.ApplicationListener;
import site.leiwa.springframework.content.event.ContextRefreshedEvent;

public class ContextRefreshedEventListener implements ApplicationListener<ContextRefreshedEvent> {

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        System.out.println("刷新事件：" + this.getClass().getName());
    }

}
