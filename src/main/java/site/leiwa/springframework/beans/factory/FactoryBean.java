package site.leiwa.springframework.beans.factory;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: todo
 * @since 2022/11/23
 */
public interface FactoryBean<T> {
    T getObject() throws Exception;

    Class<?> getObjectType();

    boolean isSingleton();
}
