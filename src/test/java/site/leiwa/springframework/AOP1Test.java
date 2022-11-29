package site.leiwa.springframework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.junit.jupiter.api.Test;

import site.leiwa.springframework.aop.AdvisedSupport;
import site.leiwa.springframework.aop.MethodMatcher;
import site.leiwa.springframework.aop.TargetSource;
import site.leiwa.springframework.aop.aspectj.AspectJExpressionPointcut;
import site.leiwa.springframework.aop.framework.Cglib2AopProxy;
import site.leiwa.springframework.aop.framework.JdkDynamicAopProxy;
import site.leiwa.springframework.aop.framework.ReflectiveMethodInvocation;
import site.leiwa.springframework.bean.IUserService;
import site.leiwa.springframework.bean.UserServiceImpl;
import site.leiwa.springframework.bean.UserServiceImplInterceptor;

/**
 * @desc: todo
 *
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @since 2022/11/28
 */
public class AOP1Test {

    @Test
    public void test_proxy_method() {
        // 目标对象(可以替换成任何的目标对象)
        Object targetObj = new UserServiceImpl();

        // AOP 代理
        IUserService proxy = (IUserService)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
            targetObj.getClass().getInterfaces(), new InvocationHandler() {
                // 方法匹配器
                MethodMatcher methodMatcher =
                    new AspectJExpressionPointcut("execution(* site.leiwa.springframework.bean.IUserService.*(..))");

                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    if (methodMatcher.matches(method, targetObj.getClass())) {
                        // 方法拦截器
                        MethodInterceptor methodInterceptor = invocation -> {
                            long start = System.currentTimeMillis();
                            try {
                                return invocation.proceed();
                            } finally {
                                System.out.println("监控 - Begin By AOP");
                                System.out.println("方法名称：" + invocation.getMethod().getName());
                                System.out.println("方法耗时：" + (System.currentTimeMillis() - start) + "ms");
                                System.out.println("监控 - End\r\n");
                            }
                        };
                        // 反射调用
                        return methodInterceptor.invoke(new ReflectiveMethodInvocation(targetObj, method, args));
                    }
                    return method.invoke(targetObj, args);
                }
            });
        String result = proxy.queryUserInfo();
        System.out.println("测试结果：" + result);
    }

    @Test
    public void test_aop() throws NoSuchMethodException {
        AspectJExpressionPointcut pointcut =
            new AspectJExpressionPointcut("execution(* site.leiwa.springframework.bean.UserServiceImpl.*(..))");

        Class<UserServiceImpl> clazz = UserServiceImpl.class;
        Method method = clazz.getDeclaredMethod("queryUserInfo");

        System.out.println(pointcut.matches(clazz));
        System.out.println(pointcut.matches(method, clazz));
    }

    @Test
    public void test_dynamic() {
        // 目标对象
        IUserService userService = new UserServiceImpl();
        // 组装代理信息
        AdvisedSupport advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceImplInterceptor());
        advisedSupport.setMethodMatcher(
            new AspectJExpressionPointcut("execution(* site.leiwa.springframework.bean.IUserService.*(..))"));

        // 代理对象(JdkDynamicAopProxy)
        IUserService proxy_jdk = (IUserService)new JdkDynamicAopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_jdk.queryUserInfo());

        // 代理对象(Cglib2AopProxy)
        IUserService proxy_cglib = (IUserService)new Cglib2AopProxy(advisedSupport).getProxy();
        // 测试调用
        System.out.println("测试结果：" + proxy_cglib.register("花花"));
    }

    @Test
    public void test_proxy_class() {
        IUserService userService = (IUserService)Proxy.newProxyInstance(Thread.currentThread().getContextClassLoader(),
            new Class[] {IUserService.class}, (proxy, method, args) -> "你被代理了！");
        String result = userService.queryUserInfo();
        System.out.println("测试结果：" + result);
    }
}
