package com.example.demo.demo1.springIOCTest;

import com.example.demo.demo1.entity.Car;
import com.example.demo.demo1.entity.Wheel;

public class SimpleIOCTest {
    public static void main(String[] args) {
        SimpleIOCTest iocTest = new SimpleIOCTest();
        try {
            iocTest.getBean();
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }
    public void getBean() throws Exception {
        String location = SimpleIOC.class.getClassLoader().getResource("ioc.xml").getFile();
        SimpleIOC bf = new SimpleIOC(location);
        Wheel wheel = (Wheel) bf.getBean("wheel");
        System.out.println(wheel);
        Car car = (Car) bf.getBean("car");
        System.out.println(car);
    }
}
