package io.my.featureservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class FeatureServiceApplication {
    public static void main(String[] args){
        SpringApplication.run(FeatureServiceApplication.class, args);
    }
}
