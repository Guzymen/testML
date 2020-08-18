package com.testML;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.testML.services.IMutantService;
import com.testML.services.impl.MutantService;

@SpringBootApplication
@ComponentScan("com.*")
public class TestMlApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(TestMlApplication.class, args);
    }

    @Bean
    public IMutantService getMutantService() {
        return new MutantService();
    }
}
