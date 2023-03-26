package com.wzh.spring.aop.xml;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class LoggerAspect {


    public void beforeAdviceMethod(JoinPoint joinPoint) {

        //获取连接点对应方法的签名 即声明
        Signature r = joinPoint.getSignature();
        //获取方法名
        String name = r.getName();
        //获取连接点对应方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect前置,方法:" + name + Arrays.toString(args));

    }

    public void afterAdviceMethod(JoinPoint joinPoint) {
        Signature r = joinPoint.getSignature();
        //获取方法名
        String name = r.getName();
        System.out.println("LoggerAspect后置,方法:" + name + "执行完毕");
    }

    public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result) {
        //接收方法返回值  设置注解属性returning="参数名" 参数列表Object 参数名 即可
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法:" + signature.getName() + "结果:" + result);
    }

    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Exception exception) {
        //接收异常 设置注解属性throwing="" 设置异常参数 打印异常信息
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法:" + signature.getName() + "异常:" + exception.getMessage());
    }

    public Object aroundAdviceMethod(ProceedingJoinPoint joinPoint) {
        Object proceed = null;
        try {
            System.out.println("环绕通知->前置通知");
            //表示目标对象方法的执行 要保证返回值和目标对象的返回值一致
            proceed = joinPoint.proceed();
            System.out.println("环绕通知->返回通知");
        } catch (Throwable throwable) {
            throwable.printStackTrace();
            System.out.println("环绕通知->异常通知");
        }finally {
            System.out.println("环绕通知->后置通知");
        }
        return proceed;
    }
}
