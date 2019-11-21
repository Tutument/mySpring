package com.example.demo;

import com.example.demo.demo2.runtest.RuntestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.ApplicationListener;

@SpringBootApplication
public class MyspringApplication {


    public static void main(String[] args) {
        SpringApplication.run(MyspringApplication.class, args);
       /* String msg = new RuntestController().getMsg();
        System.out.println(msg);*/
    }
   /* public class GlmapperApplicationStartingEventListener implements ApplicationListener<ApplicationStartingEvent> {
        @Override
        public void onApplicationEvent(ApplicationStartingEvent applicationStartingEvent) {
            System.out.println("execute ApplicationStartingEvent ...");
        }
    }*/


}
