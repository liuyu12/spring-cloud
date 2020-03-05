package cn.edu.ahtcm.eurekauserservice.configurg;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
@EnableJpaRepositories("cn.edu.ahtcm.**.dao")
@EntityScan("cn.edu.ahtcm.**.entity")
@ComponentScan(basePackages = "cn.edu.ahtcm")
public class SpringConfig {
    @Bean
    @LoadBalanced
    RestTemplate restTemplate(){
        SimpleClientHttpRequestFactory factory = new SimpleClientHttpRequestFactory();
        factory.setConnectTimeout(1000);
        factory.setReadTimeout(1000);
        return new RestTemplate();
    }
}
