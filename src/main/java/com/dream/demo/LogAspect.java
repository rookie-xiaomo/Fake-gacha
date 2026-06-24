package com.dream.demo;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect     //这是一个切面类
@Component  //交给Spring管理
public class LogAspect {

    @Around("execution(* com.dream.demo.Service.CharacterService.*(..))")
    public Object LogTime(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();    //记录开始时间

        System.out.println("==== [AOP监控] 玩家开始请求接口: " + joinPoint.getSignature().getName());

        //执行原本逻辑
        Object result = joinPoint.proceed();
        long end = System.currentTimeMillis();      //记录结束时间

        System.out.println("==== [AOP监控] 请求处理完毕，耗时: " + (end - start) + "ms");
        return result;
    }
}
