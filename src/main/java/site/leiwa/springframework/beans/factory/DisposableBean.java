package site.leiwa.springframework.beans.factory;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: 销毁方法接口
 * @since 2022/11/21
 */
public interface DisposableBean {
    void destroy() throws Exception;
}
