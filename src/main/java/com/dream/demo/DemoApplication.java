package com.dream.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
// 重点：因为你的 entity 文件夹在 com.dream 下，和 demo 是平级的
// 我们需要确保 Spring 能扫描到它
@ComponentScan(basePackages = {"com.dream"})
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}