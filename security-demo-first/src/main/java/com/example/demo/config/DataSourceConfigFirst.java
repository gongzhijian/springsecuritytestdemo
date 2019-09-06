package com.example.demo.config;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import tk.mybatis.spring.annotation.MapperScan;

import javax.sql.DataSource;

/**
 * @author GEEX616
 * @create 2019-09-04 15:52
 * @desc 第一个数据库配置
 **/
@Configuration
@MapperScan(basePackages = "com.example.demo.dao.alpha", sqlSessionTemplateRef = "test1SqlSessionTemplate")
public class DataSourceConfigFirst {

    // 将这个对象放入Spring容器中
    @Bean(name = "alphaDataSource")
    // 表示这个数据源是默认数据源
    @Primary
    // 读取application.properties中的配置参数映射成为一个对象
    // prefix表示参数的前缀
    @ConfigurationProperties(prefix = "spring.datasource.alpha")
    public DataSource getDateSourceAlpha() {
        return DataSourceBuilder.create().build();
    }



    @Bean(name = "alphaSqlSessionFactory")
    @Primary
    public SqlSessionFactory alphaSqlSessionFactory(@Qualifier("alphaDataSource")DataSource dataSource) throws Exception{
        SqlSessionFactoryBean factoryBean=new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource);
        factoryBean.setMapperLocations(
                // 设置mybatis的xml所在位置
                new PathMatchingResourcePatternResolver().getResources("classpath:mapping/alpha/*.xml"));
        return factoryBean.getObject();

    }

    @Bean("test1SqlSessionTemplate")
    // 表示这个数据源是默认数据源
    @Primary
    public SqlSessionTemplate test1sqlsessiontemplate(
            @Qualifier("alphaSqlSessionFactory") SqlSessionFactory alphaSessionfactory) {
        return new SqlSessionTemplate(alphaSessionfactory);
    }



    @Bean(name = "alphaTransactionManager")
    @Primary
    public DataSourceTransactionManager dataSourceTransactionManagerAlpha(@Qualifier("alphaDataSource")DataSource alphaDataSource) {
        return new DataSourceTransactionManager(alphaDataSource);
    }

}
