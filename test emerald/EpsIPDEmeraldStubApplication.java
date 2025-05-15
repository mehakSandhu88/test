package com.rbc.ipdEmerald.stub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication & Venkat +1
@Configuration
public class EpsIPDEmeraldStubApplication {

public static void main(String[] args) { 
    System.setProperty("com.ibm.mq.cfg.use IBMCipherMappings", "false");
    SpringApplication application = new SpringApplication (Eps IPDEmeraldStubApplication.class);
    application.addListeners((ApplicationListener<ApplicationEnvironment PreparedEvent>) event -> 
    application.run(args);
}

}
