package hzy.advice;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


@Aspect
public class mylog{

    public void beforeRun(){
        System.out.println("前置增强");
    }

    public void afterRun(){
        System.out.println("后置增强");
    }
    public Object aroundRun(ProceedingJoinPoint pjp) throws Throwable {
        Object ob[] = pjp.getArgs();
        System.out.println("环绕前置增强"+ob[0]);
        Object object = pjp.proceed();
        System.out.println("环绕后置增强");
        return object;
    }

}
