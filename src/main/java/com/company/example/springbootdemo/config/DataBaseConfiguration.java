/*
package com.springbootdemo.config;

import com.alibaba.druid.pool.DruidDataSource;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

@Configuration
@Component
@ConfigurationProperties(prefix = "spring.datasource")
@Data
public class DataBaseConfiguration {

//    @Value("${driverclassname}")
//    private String driverclassname;
    @Value("{url}")
    private String url;
    @Value("{username}")
    private String username;
    @Value("{password}")
    private String password;



    @Bean(name = "myDataSource")
    public DataSource myDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
//        dataSource.setDriverClassName(driverclassname);
        dataSource.setUrl(url);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;

    }
}
*/
