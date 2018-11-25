package com.hechuangjun.multipledatasources.application;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.mchange.v2.c3p0.ComboPooledDataSource;

/** 
* @author 作者 junye E-mail: 1105128664@qq.com
* @version 创建时间：2018年11月15日 
* 类说明 :
*/
@Configuration
@MapperScan(basePackages="com.hechuangjun.multipledatasources.mapper2",sqlSessionTemplateRef="secondSqlSessionTemplate")
public class SecondDataSource {
	//主要的数据库连接池
	@Bean(name="secondDataSource1",destroyMethod="close")
    @ConfigurationProperties(prefix = "spring.seconddatasource")
    public DataSource secondDataSource1() {
        return DataSourceBuilder.create().type(ComboPooledDataSource.class).build();
    }
	
	@Bean(name="secondSqlSessionFactory")
	public SqlSessionFactory secondsqlSessionFactory() throws Exception {
		SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
		bean.setDataSource(secondDataSource1());
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		try {
			bean.setMapperLocations(resolver.getResources("classpath*:mapper2/*.xml"));
			 return bean.getObject();
		} catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
	}
	@Bean(name="secondSqlSessionTemplate")
	public SqlSessionTemplate secondSqlSessionTemplate() throws Exception {
		SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(secondsqlSessionFactory());
		return sqlSessionTemplate;
	}

	
	@Bean(name="secondTransactionManager")
	public DataSourceTransactionManager secondDataSourceTransactionManager() {
	    return new DataSourceTransactionManager(secondDataSource1());
	}
}
