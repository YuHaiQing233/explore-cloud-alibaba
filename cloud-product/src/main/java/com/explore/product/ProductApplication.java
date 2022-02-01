package com.explore.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * 产品服务 启动类
 *
 * @author: YuHaiQing
 * @time: 2022/2/1 19:00
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ProductApplication {
    public static void main(String[] args) {
        SpringApplication.run(ProductApplication.class,args);
    }
}
