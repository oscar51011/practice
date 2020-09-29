package com.practice.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import com.alibaba.druid.pool.DruidDataSource;

@Configuration
@MapperScan(basePackages = SecondDataSourceConfig.SECOND_PACKAGE, sqlSessionFactoryRef = "secondSqlSessionFactory")
public class SecondDataSourceConfig {
	
	static final String MAPPER_LOCATION = "classpath:secondMapper/*.xml";
	static final String SECOND_PACKAGE = "com.practice.secondMapper";

	@Value("${datasource.second.url}")
	private String url;
	@Value("${datasource.second.driver-class-name}")
	private String driver;
	@Value("${datasource.second.username}")
	private String user;
	@Value("${datasource.second.password}")
	private String password;
	
	@Bean(name = "secondDataSource")
    public DataSource secondDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }
 
    @Bean(name = "secondTransactionManager")
    public DataSourceTransactionManager secondTransactionManager() {
        return new DataSourceTransactionManager(secondDataSource());
    }
 
    @Bean(name = "secondSqlSessionFactory")
    public SqlSessionFactory secondSqlSessionFactory(@Qualifier("secondDataSource") DataSource dataSource)
            throws Exception {
    	
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(SecondDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
