package cn.edu.ahtcm.eurekauserservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;

@EnableCircuitBreaker
@SpringBootApplication
public class EurekaUserHystrixServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaUserHystrixServiceApplication.class, args);
    }

}
