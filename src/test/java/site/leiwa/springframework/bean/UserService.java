package site.leiwa.springframework.bean;

import lombok.Data;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: 模拟 Business Bean
 * @since 2022/11/19
 */
@Data
public class UserService {

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
}
