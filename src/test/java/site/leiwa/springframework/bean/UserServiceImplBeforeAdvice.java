package site.leiwa.springframework.bean;

import java.lang.reflect.Method;

import site.leiwa.springframework.aop.MethodBeforeAdvice;

/**
 * @desc: todo
 *
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @since 2022/11/29
 */
public class UserServiceImplBeforeAdvice implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] args, Object target) throws Throwable {
        System.out.println("拦截方法：" + method.getName());
    }
}
