package site.leiwa.springframework.content;

import site.leiwa.springframework.beans.BeansException;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: SPI 接口配置应用上下文
 * @since 2022/11/20
 */
public interface ConfigurableApplicationContext extends ApplicationContext {
    /**
     * 刷新容器
     *
     * @throws BeansException BeansException
     */
    void refresh() throws BeansException;
}
