package site.leiwa.springframework.bean;

/**
 * @desc: todo
 *
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @since 2022/11/28
 */
public interface IUserService {
    String queryUserInfo();

    String register(String userName);
}
