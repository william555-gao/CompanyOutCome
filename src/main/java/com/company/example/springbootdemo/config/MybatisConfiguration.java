/*
package com.springbootdemo.config;

import lombok.Data;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
@MapperScan("com.cjy.springbootdemo.mapper")
@ConfigurationProperties(prefix = "mybatis")
@Component
@Data
@AutoConfigureAfter( DataBaseConfiguration.class)
public class MybatisConfiguration {

    private String typealiasespackage;

    private String mapperlocations;

    private String configlocation;

    @Resource(name = "myDataSource")
    private DataSource dataSource;

    @Bean
    public SqlSessionFactory sqlSessionFactory() {
        try {
            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
            sqlSessionFactoryBean.setDataSource(dataSource);
            sqlSessionFactoryBean.setTypeAliasesPackage(typealiasespackage);
            PathMatchingResourcePatternResolver path = new PathMatchingResourcePatternResolver();
            sqlSessionFactoryBean.setMapperLocations(path.getResources(mapperlocations));
            DefaultResourceLoader resourceLoader = new DefaultResourceLoader();
            sqlSessionFactoryBean.setConfigLocation(resourceLoader.getResource(configlocation));
            return sqlSessionFactoryBean.getObject();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }


    @Bean
    public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

    @Bean
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(dataSource);
    }



}
*/
