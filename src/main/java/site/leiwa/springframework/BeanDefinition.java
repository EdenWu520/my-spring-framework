package site.leiwa.springframework;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: Bean 对象信息定义
 * @since 2022/11/19
 */
public class BeanDefinition {
    private Object bean;

    public BeanDefinition(Object bean) {
        this.bean = bean;
    }

    public Object getBean() {
        return bean;
    }
}
