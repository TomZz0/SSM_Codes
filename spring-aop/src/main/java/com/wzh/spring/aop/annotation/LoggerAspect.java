package com.wzh.spring.aop.annotation;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect //将当前组件标识为切面
public class LoggerAspect {
    /**
     * 1 通知类型的设置 在切面中 需要使用注解将方法标识为通知方法
     *
     * @Before前置通知
     * @After 后置通知 finally中执行
     * @AfterReturning 返回通知 在目标对象方法的返回值后执行
     * @AfterThrowing 异常通知 在目标对象方法的catch块中执行
     * @Around 环绕通知
     * 2切入点表达式如下 访问修饰符 方法名的全路径
     * execution(public int com.wzh.spring.aop.annotation.CalculatorImpl.add(int,int))
     * "execution(* com.wzh.spring.aop.annotation.Calculator.*(..))"
     * 表示不限修饰符和返回类型 类下的任意方法且不限参数类型
     * 在类的位置也可以使用*表示包下所有的类
     * 3 获取连接点的信息
     * 在通知方法的参数位置 设置JoinPoint joinPoint参数 就可以获取信息
     * 4 复用切入点表达式
     * @Pointcut("execution(* com.wzh.spring.aop.annotation.Calculator.*(..))")
     * public void pointCut(){}
     * @Before("pointCut()")
     * 5 切面的优先级
     * 可以通过@Order注解的value属性设置优先级 默认值为Integer.MAX_VALUE
     * value越小 优先级越大
     */
    @Pointcut("execution(* com.wzh.spring.aop.annotation.Calculator.*(..))")
    public void pointCut() {
    }

    //    @Before("execution(public int com.wzh.spring.aop.annotation.CalculatorImpl.add(int,int))")
    @Before("pointCut()")
    public void beforeAdviceMethod(JoinPoint joinPoint) {

        //获取连接点对应方法的签名 即声明
        Signature r = joinPoint.getSignature();
        //获取方法名
        String name = r.getName();
        //获取连接点对应方法的参数
        Object[] args = joinPoint.getArgs();
        System.out.println("LoggerAspect前置,方法:" + name + Arrays.toString(args));

    }

    /**
     * 后置通知
     *
     * @param joinPoint
     */
    @After("pointCut()")
    //finally中执行
    public void afterAdviceMethod(JoinPoint joinPoint) {
        Signature r = joinPoint.getSignature();
        //获取方法名
        String name = r.getName();
        System.out.println("LoggerAspect后置,方法:" + name + "执行完毕");
    }

    /**
     * 返回通知
     *
     * @param joinPoint
     * @param result
     */
    @AfterReturning(value = "pointCut()", returning = "result")
    public void afterReturningAdviceMethod(JoinPoint joinPoint, Object result) {
        //接收方法返回值  设置注解属性returning="参数名" 参数列表Object 参数名 即可
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法:" + signature.getName() + "结果:" + result);
    }

    /**
     * 异常通知
     *
     * @param joinPoint
     * @param exception
     */
    @AfterThrowing(value = "pointCut()", throwing = "exception")
    public void afterThrowingAdviceMethod(JoinPoint joinPoint, Exception exception) {
        //接收异常 设置注解属性throwing="" 设置异常参数 打印异常信息
        Signature signature = joinPoint.getSignature();
        System.out.println("LoggerAspect,方法:" + signature.getName() + "异常:" + exception.getMessage());
    }

    /**
     * 环绕通知
     *
     * @param joinPoint
     */
    @Around("pointCut()")
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
