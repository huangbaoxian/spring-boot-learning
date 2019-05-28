package com.hbx.springbootmybatisxmlmultidatasource.db;


import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

@Configuration
@MapperScan(basePackages = "com.hbx.springbootmybatisxmlmultidatasource.mapper.test2", sqlSessionTemplateRef = "template2")
public class DataSourceConfig2 {

    @Bean(name = "dataSource2")
    @ConfigurationProperties(prefix = "spring.datasource.test2")
    public DataSource dataSource2(){
        return DataSourceBuilder.create().build();
    }



    @Bean(name = "sqlSessionFactory2")
    public SqlSessionFactory sqlSessionFactory2(@Qualifier("dataSource2") DataSource dataSource) throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
        bean.setMapperLocations(new PathMatchingResourcePatternResolver().getResources("classpath:mybatis/mapper/*Mapper2.xml"));
        return bean.getObject();
    }


    @Bean(name = "manager2")
    public DataSourceTransactionManager manager2(@Qualifier("dataSource2") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "template2")
    public SqlSessionTemplate template2(@Qualifier("sqlSessionFactory2") SqlSessionFactory factory) throws  Exception{
        return new SqlSessionTemplate(factory);
    }

}
