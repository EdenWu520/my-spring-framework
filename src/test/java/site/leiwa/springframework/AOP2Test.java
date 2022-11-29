package site.leiwa.springframework;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import org.aopalliance.intercept.MethodInterceptor;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import site.leiwa.springframework.aop.AdvisedSupport;
import site.leiwa.springframework.aop.ClassFilter;
import site.leiwa.springframework.aop.MethodMatcher;
import site.leiwa.springframework.aop.TargetSource;
import site.leiwa.springframework.aop.aspectj.AspectJExpressionPointcut;
import site.leiwa.springframework.aop.aspectj.AspectJExpressionPointcutAdvisor;
import site.leiwa.springframework.aop.framework.ProxyFactory;
import site.leiwa.springframework.aop.framework.ReflectiveMethodInvocation;
import site.leiwa.springframework.aop.framework.adapter.MethodBeforeAdviceInterceptor;
import site.leiwa.springframework.bean.IUserService;
import site.leiwa.springframework.bean.UserServiceImpl;
import site.leiwa.springframework.bean.UserServiceImplBeforeAdvice;
import site.leiwa.springframework.bean.UserServiceImplInterceptor;
import site.leiwa.springframework.content.support.ClassPathXmlApplicationContext;

/**
 * @desc: todo
 *
 * @author <a href="mailto:gcwulei@gmail.com">Lei Wu</a>
 * @since 2022/11/30
 */
public class AOP2Test {
    private AdvisedSupport advisedSupport;

    @BeforeEach
    public void init() {
        // 目标对象
        IUserService userService = new UserServiceImpl();
        // 组装代理信息
        advisedSupport = new AdvisedSupport();
        advisedSupport.setTargetSource(new TargetSource(userService));
        advisedSupport.setMethodInterceptor(new UserServiceImplInterceptor());
        advisedSupport.setMethodMatcher(
            new AspectJExpressionPointcut("execution(* site.leiwa.springframework.bean.IUserService.*(..))"));
    }

    @Test
    public void test_proxyFactory() {
        advisedSupport.setProxyTargetClass(false); // false/true，JDK动态代理、CGlib动态代理
        IUserService proxy = (IUserService)new ProxyFactory(advisedSupport).getProxy();

        System.out.println("测试结果：" + proxy.queryUserInfo());
    }

    @Test
    public void test_beforeAdvice() {
        UserServiceImplBeforeAdvice beforeAdvice = new UserServiceImplBeforeAdvice();
        MethodBeforeAdviceInterceptor interceptor = new MethodBeforeAdviceInterceptor(beforeAdvice);
        advisedSupport.setMethodInterceptor(interceptor);

        IUserService proxy = (IUserService)new ProxyFactory(advisedSupport).getProxy();
        System.out.println("测试结果：" + proxy.queryUserInfo());
    }

    @Test
    public void test_advisor() {
        // 目标对象
        IUserService userService = new UserServiceImpl();

        AspectJExpressionPointcutAdvisor advisor = new AspectJExpressionPointcutAdvisor();
        advisor.setExpression("execution(* site.leiwa.springframework.bean.IUserService.*(..))");
        advisor.setAdvice(new MethodBeforeAdviceInterceptor(new UserServiceImplBeforeAdvice()));

        ClassFilter classFilter = advisor.getPointcut().getClassFilter();
        if (classFilter.matches(userService.getClass())) {
            AdvisedSupport advisedSupport = new AdvisedSupport();

            TargetSource targetSource = new TargetSource(userService);
            advisedSupport.setTargetSource(targetSource);
            advisedSupport.setMethodInterceptor((MethodInterceptor)advisor.getAdvice());
            advisedSupport.setMethodMatcher(advisor.getPointcut().getMethodMatcher());
            advisedSupport.setProxyTargetClass(true); // false/true，JDK动态代理、CGlib动态代理

            IUserService proxy = (IUserService)new ProxyFactory(advisedSupport).getProxy();
            System.out.println("测试结果：" + proxy.queryUserInfo());
        }
    }

    @Test
    public void test_aop() {
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("classpath:spring.xml");

        IUserService userService = applicationContext.getBean("userService", IUserService.class);
        System.out.println("测试结果：" + userService.queryUserInfo());
    }

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

}
