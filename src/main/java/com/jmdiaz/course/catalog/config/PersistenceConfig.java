package com.jmdiaz.course.catalog.config;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.postgresql.Driver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;

@Configuration
@MapperScan("com.jmdiaz.course.catalog.repository")
public class PersistenceConfig {
	@Value("${database.dbHost}") 
    private String dbHost; 
	
	@Value("${database.dbPort}") 
    private String dbPort;
	
	@Value("${database.dbName}") 
    private String dbName;
	
	@Value("${database.dbUser}") 
    private String dbUser;
	
	@Value("${database.dbPwd}") 
    private String dbPwd;
	
	@Bean
	public DataSource dataSource() {
		SimpleDriverDataSource sdds = new SimpleDriverDataSource();
		sdds.setDriverClass(Driver.class);
		sdds.setUrl(String.format("jdbc:postgresql://%s:%s/%s", dbHost, dbPort, dbName));
		sdds.setUsername(dbUser);
		sdds.setPassword(dbPwd);
		return sdds;
	}
 
	@Bean
	public DataSourceTransactionManager transactionManager() {
		return new DataSourceTransactionManager(dataSource());
	}
 
	@Bean
	public SqlSessionFactoryBean sqlSessionFactory() throws Exception {
		SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		return sessionFactory;
	}

}
