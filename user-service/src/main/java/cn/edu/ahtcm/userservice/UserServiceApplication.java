package cn.edu.ahtcm.userservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class UserServiceApplication {
    @Bean
    RestTemplate restTemplate(){return new RestTemplate();}
    public static void main(String[] args) {
        SpringApplication.run(UserServiceApplication.class, args);
    }

}
