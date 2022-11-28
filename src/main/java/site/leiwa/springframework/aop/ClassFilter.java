package site.leiwa.springframework.aop;

/**
 * @desc: 定义匹配类接口，用于帮助切点找到给定的接口和目标类
 *
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @since 2022/11/28
 */
public interface ClassFilter {
    /**
     * Should the pointcut apply to the given interface or target class?
     * 
     * @param clazz the candidate target class
     * @return whether the advice should apply to the given target class
     */
    boolean matches(Class<?> clazz);
}
