package com.example.demo.demo1.springAOPTest;

import com.example.demo.demo1.entity.HelloService;
import com.example.demo.demo1.entity.HelloServiceImpl;

public class SimpleAOPTest {
    public static void main(String[] args) {
        SimpleAOPTest aopTest = new SimpleAOPTest();
        try {
            aopTest.getProxy();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

    public void getProxy() throws Exception {
        // 1. 创建一个 MethodInvocation 实现类
        MethodInvocation logTask = () -> System.out.println("log task start");
        HelloServiceImpl helloServiceImpl = new HelloServiceImpl();

        // 2. 创建一个 Advice
        Advice beforeAdvice = new BeforeAdvice(helloServiceImpl, logTask);

        // 3. 为目标对象生成代理
        HelloService helloServiceImplProxy = (HelloService) SimpleAOP.getProxy(helloServiceImpl,beforeAdvice);

        helloServiceImplProxy.sayHelloWorld();
    }
}
