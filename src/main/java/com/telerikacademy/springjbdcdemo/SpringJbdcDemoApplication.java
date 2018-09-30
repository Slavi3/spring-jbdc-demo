package com.telerikacademy.springjbdcdemo;

import com.telerikacademy.springjbdcdemo.models.Address;
import com.telerikacademy.springjbdcdemo.models.Employee;
import org.hibernate.SessionFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringJbdcDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringJbdcDemoApplication.class, args);

    }
    @Bean
    SessionFactory sessionFactory(){
        return new org.hibernate.cfg.Configuration()
                .configure("hibernate.cfn.xml")
                .addAnnotatedClass(Employee.class)
                .addAnnotatedClass(Address.class)
                .buildSessionFactory();
    }

}
