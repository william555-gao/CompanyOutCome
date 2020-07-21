package com.company.example.springbootdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.net.InetAddress;
import java.net.UnknownHostException;


@SpringBootApplication
@MapperScan("com.company.example.springbootdemo.mapper")
public class ApplicationAO {


    public static void main(String[] args) {
        SpringApplication.run(ApplicationAO.class, args);
    }


    /**
     * 获得本机的内网地址（String）
     */
    private String getLocalIp(){
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            return "unknown-ip";
        }
    }
    @PostConstruct
    public void postConstruct() {
        String localIp = getLocalIp();
        System.setProperty("local-ip", localIp);
    }



}