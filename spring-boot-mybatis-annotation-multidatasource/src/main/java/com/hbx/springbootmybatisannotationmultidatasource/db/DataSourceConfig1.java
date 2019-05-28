package com.hbx.springbootmybatisannotationmultidatasource.db;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.hbx.springbootmybatisannotationmultidatasource.mapper.test1", sqlSessionTemplateRef = "template1")
public class DataSourceConfig1 {


    @Bean(name = "testDataSource1")
    @ConfigurationProperties(prefix = "spring.datasource.test1")
    @Primary
    public DataSource testDataSource(){
        return DataSourceBuilder.create().build();
    }

    @Primary
    @Bean(name = "testSqlSessionFactory1")
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("testDataSource1") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        return bean.getObject();
    }

    @Bean(name = "transactionManager1")
    @Primary
    public DataSourceTransactionManager transactionManager(@Qualifier("testDataSource1") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }


    @Bean(name = "template1")
    @Primary
    public SqlSessionTemplate  template(@Qualifier("testSqlSessionFactory1") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }



}
