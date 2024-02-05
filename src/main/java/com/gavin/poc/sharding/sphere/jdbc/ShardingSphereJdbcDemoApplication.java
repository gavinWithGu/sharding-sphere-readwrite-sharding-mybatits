package com.gavin.poc.sharding.sphere.jdbc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Gavin
 */
@ComponentScan(basePackages = "com.gavin.poc.sharding.sphere.jdbc")
@MapperScan("com.gavin.poc.sharding.sphere.jdbc.demo.mapper")
@EntityScan(basePackages = "com.gavin.poc.sharding.sphere.jdbc.demo.mapper.domain.entity")
@SpringBootApplication
public class ShardingSphereJdbcDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShardingSphereJdbcDemoApplication.class, args);
    }

}
