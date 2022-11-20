package site.leiwa.springframework.bean;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: 模拟 Business Bean
 * @since 2022/11/19
 */
public class UserService {

    private String name;

    public UserService() {
    }

    public UserService(String name) {
        this.name = name;
    }

    public String queryUser() {
        if (name != null) {
            return name;
        }
        return "Eden";
    }
}
