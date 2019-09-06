package com.example.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author GEEX616
 * @create 2019-09-04 15:52
 * @desc 第一个数据库配置
 **/
@Configuration
//@MapperScan(basePackages = "com.example.demo.dao.beta.StudentMapper", sqlSessionFactoryRef = "betaSqlSessionFactory")
@MapperScan(basePackages = "com.example.demo.dao.beta.*", sqlSessionTemplateRef = "test2SqlSessionTemplate")
public class DataSourceConfigSecond {

    // 将这个对象放入Spring容器中
    @Bean(name = "betaDataSource")
    // 表示这个数据源是默认数据源
    // 读取application.properties中的配置参数映射成为一个对象
    // prefix表示参数的前缀
    @ConfigurationProperties(prefix = "spring.datasource.beta")
    public DataSource getDateSourceAlpha() {
        return DataSourceBuilder.create().build();
    }



    @Bean(name = "betaSqlSessionFactory")
    public SqlSessionFactory betaSqlSessionFactory(@Qualifier("betaDataSource")DataSource dataSource) throws Exception{
        SqlSessionFactoryBean factoryBean=new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(
                // 设置mybatis的xml所在位置
                new PathMatchingResourcePatternResolver().getResources("classpath:mapping/beta/*.xml"));
        return factoryBean.getObject();

    }

    @Bean("test2SqlSessionTemplate")
    public SqlSessionTemplate test2sqlsessiontemplate(
            @Qualifier("betaSqlSessionFactory") SqlSessionFactory betaSessionfactory) {
        return new SqlSessionTemplate(betaSessionfactory);
    }



    @Bean(name = "betaTransactionManager")
    public DataSourceTransactionManager dataSourceTransactionManagerBeta(@Qualifier("betaDataSource")DataSource betaDataSource) {
        return new DataSourceTransactionManager(betaDataSource);
    }

}
