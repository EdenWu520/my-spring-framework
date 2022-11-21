package site.leiwa.springframework.bean;

import lombok.Data;
import site.leiwa.springframework.beans.factory.DisposableBean;
import site.leiwa.springframework.beans.factory.InitializingBean;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: 模拟 Business Bean
 * @since 2022/11/19
 */
@Data
public class UserService implements InitializingBean, DisposableBean {

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
}
