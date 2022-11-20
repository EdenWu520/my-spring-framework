package site.leiwa.springframework.bean;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: 模拟 Business Bean
 * @since 2022/11/19
 */
public class UserService {

    private String id;

    private UserDao userDao;

    public String queryUser() {
        if (id != null) {
            return userDao.queryUserName(id);
        }
        return "Eden";
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
