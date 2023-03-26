package com.wzh.spring.proxy;

public class CalculatorStaticProxy implements Calculator{

    private Calculator target;

    public CalculatorStaticProxy(Calculator target) {
        this.target = target;
    }

    public int add(int i, int j) {
        System.out.println("日志,方法:add 参数:"+i+","+j);
        int result = target.add(i,j);

        return result;
    }

    public int sub(int i, int j) {
        System.out.println("日志,方法:sub 参数:"+i+","+j);
        int result = target.sub(i,j);

        return result;
    }

    public int mul(int i, int j) {
        System.out.println("日志,方法:mul 参数:"+i+","+j);
        int result = target.mul(i,j);

        return result;
    }

    public int div(int i, int j) {
        System.out.println("日志,方法:div 参数:"+i+","+j);
        int result = target.div(i,j);

        return result;
    }
}
