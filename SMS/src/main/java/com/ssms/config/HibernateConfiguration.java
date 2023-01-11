package com.ssms.config;

import java.nio.charset.StandardCharsets;
import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@Configuration
public class HibernateConfiguration {

	private static final String TRUE = "true";
	
	@Value("${db.driverClassName}")
	private String driverClassName;
	
	@Value("${db.url}")
	private String url;	
	
	@Value("${db.username}")
	private String userName;
	
	@Value("${db.password}")
	private String password;
	
	/** The dialect. */
	@Value("${db.dialect}")
	private String dialect;

	/** The show SQL. */
	@Value("${db.showSQL}")
	private String showSQL;

	@Bean	
	public DataSource getDataSourceObject() {
		final DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(driverClassName);
		dataSource.setUrl(url);
		dataSource.setUsername(userName);
		dataSource.setPassword(password);		
		return dataSource;
		
	}
	
	@Bean
	public LocalSessionFactoryBean createSessionFactory(DataSource dataSource) {
		final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		sessionFactory.setPackagesToScan("com.ssms.**.model");
		sessionFactory.setHibernateProperties(this.hibernateProperties());
		return sessionFactory;
	}
	
	
	private final Properties hibernateProperties() {
		final Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.allow_update_outside_transaction", TRUE);
		hibernateProperties.setProperty("hibernate.proc.param_null_passing", TRUE);
		hibernateProperties.setProperty("hibernate.connection.CharSet", StandardCharsets.UTF_8.toString());
		hibernateProperties.setProperty("hibernate.connection.characterEncoding", StandardCharsets.UTF_8.toString());
		hibernateProperties.setProperty("hibernate.connection.useUnicode", TRUE);

		/// Dynamic properties
		hibernateProperties.setProperty("hibernate.dialect", this.dialect);
		hibernateProperties.setProperty("hibernate.show_sql", this.showSQL);

		return hibernateProperties;
	}


	
}
