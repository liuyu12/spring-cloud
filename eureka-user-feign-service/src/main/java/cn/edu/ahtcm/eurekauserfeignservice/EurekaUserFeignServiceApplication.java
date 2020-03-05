package cn.edu.ahtcm.eurekauserfeignservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;import org.springframework.cloud.client.SpringCloudApplication;import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;import org.springframework.cloud.openfeign.EnableFeignClients;
@EnableFeignClients
@SpringBootApplication
public class EurekaUserFeignServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaUserFeignServiceApplication.class, args);
    }
}
