package com.carl.rdj.configuration;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class DatabaseConfiguration {
	
	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan("com.carl.rdj.model");
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}
	
	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("org.postgresql.Driver");
		dataSource.setUrl("jdbc:postgresql://postgrescarlrdj.postgres.database.azure.com:5432/postgres?ssl=true");
		dataSource.setUsername("carlrdj@postgrescarlrdj");
		dataSource.setPassword("Carl.rdj");
		return dataSource;
	}
	
	public Properties hibernateProperties() {
		Properties properties = new Properties();
		//properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
		properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQL82Dialect");
		properties.put("show_sql", "true");
		return properties;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager hibernateTransactionManager = new HibernateTransactionManager();
		hibernateTransactionManager.setSessionFactory(sessionFactory().getObject());
		return hibernateTransactionManager;
	}
	
}
