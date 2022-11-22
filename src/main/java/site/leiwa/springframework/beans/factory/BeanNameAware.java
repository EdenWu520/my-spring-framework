package site.leiwa.springframework.beans.factory;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: todo
 * @since 2022/11/22
 */
public interface BeanNameAware extends Aware {
    void setBeanName(String name);
}
