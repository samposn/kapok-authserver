package com.kapokframework.authserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@EnableJpaRepositories
//@EnableTransactionManagement
public class AuthserverApplicationBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(AuthserverApplicationBootstrap.class, args);
    }

}
