package site.leiwa.springframework.aop;

import java.lang.reflect.Method;

/**
 * @desc: 方法匹配接口用于找到表达式范围内匹配的目标和方法
 *
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @since 2022/11/28
 */
public interface MethodMatcher {
    /**
     * Perform static checking whether the given method matches. If this
     * 
     * @return whether this method matches statically
     */
    boolean matches(Method method, Class<?> targetClass);
}
