package site.leiwa.springframework.bean;

import java.util.Random;

import site.leiwa.springframework.beans.factory.annotation.Autowired;
import site.leiwa.springframework.beans.factory.annotation.Value;
import site.leiwa.springframework.stereotype.Component;

/**
 * @desc: todo
 *
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @since 2022/11/28
 */
@Component("userService")
public class UserServiceImpl implements IUserService {

    @Value("${token}")
    private String token;

    @Autowired
    private UserDao userDao;

    public String queryUserInfo() {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Eden，100001，深圳";
    }

    public String register(String userName) {
        try {
            Thread.sleep(new Random(1).nextInt(100));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "注册用户：" + userName + " success！";
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return "UserServiceImpl{" + "token='" + token + '\'' + '}';
    }
}
