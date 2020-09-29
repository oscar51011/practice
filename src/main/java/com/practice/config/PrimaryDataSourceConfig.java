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
@MapperScan(basePackages = PrimaryDataSourceConfig.PRIMARY_PACKAGE, sqlSessionFactoryRef = "primarySqlSessionFactory")
public class PrimaryDataSourceConfig {
	
	static final String MAPPER_LOCATION = "classpath:mapper/*.xml";
	static final String PRIMARY_PACKAGE = "com.practice.mapper";

	@Value("${datasource.primary.url}")
	private String url;
	@Value("${datasource.primary.driver-class-name}")
	private String driver;
	@Value("${datasource.primary.username}")
	private String user;
	@Value("${datasource.primary.password}")
	private String password;
	
	@Bean(name = "primaryDataSource")
    @Primary
    public DataSource primaryDataSource() {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        return dataSource;
    }
 
    @Bean(name = "primaryTransactionManager")
    @Primary
    public DataSourceTransactionManager primaryTransactionManager() {
        return new DataSourceTransactionManager(primaryDataSource());
    }
 
    @Bean(name = "primarySqlSessionFactory")
    @Primary
    public SqlSessionFactory primarySqlSessionFactory(@Qualifier("primaryDataSource") DataSource masterDataSource)
            throws Exception {
    	
        final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
        sessionFactory.setDataSource(masterDataSource);
        sessionFactory.setMapperLocations(new PathMatchingResourcePatternResolver()
                .getResources(PrimaryDataSourceConfig.MAPPER_LOCATION));
        return sessionFactory.getObject();
    }
}
