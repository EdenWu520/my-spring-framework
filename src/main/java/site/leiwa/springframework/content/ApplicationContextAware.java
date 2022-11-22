package site.leiwa.springframework.content;

import site.leiwa.springframework.beans.BeansException;
import site.leiwa.springframework.beans.factory.Aware;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: todo
 * @since 2022/11/22
 */
public interface ApplicationContextAware extends Aware {
    void setApplicationContext(ApplicationContext applicationContext) throws BeansException;
}
