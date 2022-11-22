package site.leiwa.springframework.bean;

import lombok.Data;
import site.leiwa.springframework.beans.BeansException;
import site.leiwa.springframework.beans.factory.BeanClassLoaderAware;
import site.leiwa.springframework.beans.factory.BeanFactory;
import site.leiwa.springframework.beans.factory.BeanFactoryAware;
import site.leiwa.springframework.beans.factory.BeanNameAware;
import site.leiwa.springframework.beans.factory.DisposableBean;
import site.leiwa.springframework.beans.factory.InitializingBean;
import site.leiwa.springframework.content.ApplicationContext;
import site.leiwa.springframework.content.ApplicationContextAware;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: 模拟 Business Bean
 * @since 2022/11/19
 */
@Data
public class UserService
    implements InitializingBean, DisposableBean, BeanNameAware, BeanClassLoaderAware, ApplicationContextAware,
    BeanFactoryAware {
    private ApplicationContext applicationContext;
    private BeanFactory beanFactory;

    private String id;
    private String company;
    private String location;
    private UserDao userDao;

    public String queryUser() {
        if (id != null) {
            return userDao.queryUserName(id) + "," + company + "," + location;
        }
        return "Eden";
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("执行：UserService.destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("执行：UserService.afterPropertiesSet");
    }

    @Override
    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("ClassLoader：" + classLoader);
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("beanFactory");
        this.beanFactory = beanFactory;
    }

    @Override
    public void setBeanName(String name) {
        System.out.println("Bean Name is：" + name);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContext");
        this.applicationContext = applicationContext;
    }
}
