package com.example.demo.demo1.springAOPTest;

import java.lang.reflect.Method;

public class BeforeAdvice implements Advice {

    private Object bean;
    private MethodInvocation methodInvocation;

    public BeforeAdvice(Object bean, MethodInvocation methodInvocation) {
        this.bean = bean;
        this.methodInvocation = methodInvocation;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        Object invoke = method.invoke(bean, args);
        // 在目标方法执行后调用通知
        methodInvocation.invoke();
        return invoke;

      /*  // 在目标方法执行前调用通知
        methodInvocation.invoke();
        return method.invoke(bean, args);*/
    }
}
