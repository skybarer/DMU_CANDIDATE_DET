
package com.hcl.dmu.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@Component
public class DBConfiguration {
	

	@Value("${db.driver}")
	private  String PROPERTY_NAME_DATABASE_DRIVER;
	@Value("${db.password}")
	private  String PROPERTY_NAME_DATABASE_PASSWORD;
	@Value("${db.url}")
	private  String PROPERTY_NAME_DATABASE_URL;
	@Value("${db.username}")
	private  String PROPERTY_NAME_DATABASE_USERNAME;
	@Value("${hibernate.dialect}")
	private  String PROPERTY_NAME_HIBERNATE_DIALECT;
	@Value("${hibernate.show_sql}")
	private  String PROPERTY_NAME_HIBERNATE_SHOW_SQL;
	@Value("${entitymanager.packages.to.scan}")
	private  String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN;

	@Autowired
	private Environment env;

	@Bean
	public DataSource dataSource() {

		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName(PROPERTY_NAME_DATABASE_DRIVER);
		dataSource.setUrl(PROPERTY_NAME_DATABASE_URL);
		dataSource.setUsername(PROPERTY_NAME_DATABASE_USERNAME);
		dataSource.setPassword(PROPERTY_NAME_DATABASE_PASSWORD);
		return dataSource;

	}
	
	

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
		sessionFactoryBean.setDataSource(dataSource());
		sessionFactoryBean.setPackagesToScan(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN);
		sessionFactoryBean.setHibernateProperties(hibProperties());
		return sessionFactoryBean;

	}


	private Properties hibProperties() {
		Properties properties = new Properties();
		properties.put("hibernate.dialect", PROPERTY_NAME_HIBERNATE_DIALECT);
		properties.put("hibernate.show_sql", PROPERTY_NAME_HIBERNATE_SHOW_SQL);
		properties.put("hibernate.hbm2ddl.auto", "update");
		return properties;

	}

	@Bean
	public HibernateTransactionManager transactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;

	}
}
