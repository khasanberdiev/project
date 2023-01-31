package io.my.categoryservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCaching
//208 msootApplication
public class CategoryServiceApplication {
    public static void main(String[] args){
        SpringApplication.run(CategoryServiceApplication.class, args);
    }
}
