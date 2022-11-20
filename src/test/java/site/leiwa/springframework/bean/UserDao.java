package site.leiwa.springframework.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @desc: 模拟用户DAO类
 * @since 2022/11/20
 */
public class UserDao {
    private static Map<String, String> hashMap = new HashMap<>();

    static {
        hashMap.put("10001", "Eden");
        hashMap.put("10002", "张三");
        hashMap.put("10003", "阿毛");
    }

    public String queryUserName(String id) {
        return hashMap.get(id);
    }
}
