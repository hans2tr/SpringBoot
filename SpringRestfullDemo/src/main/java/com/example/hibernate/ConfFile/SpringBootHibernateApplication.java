package com.example.hibernate.ConfFile;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

@SpringBootApplication
@EnableAutoConfiguration(exclude = {
		DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class,
		HibernateJpaAutoConfiguration.class
})

public class SpringBootHibernateApplication {
	
	@Autowired
	private Environment env;

	public static void main(String[] args) {
        SpringApplication.run(SpringBootHibernateApplication.class, args);
    }
	
	@Bean(name="datasource")
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName(env.getProperty("net.sourceforge.jtds.jdbc.Driver"));
		dataSource.setUrl(env.getProperty("spring.datasource.url"));
		dataSource.setUsername(env.getProperty("spring.datasource.username"));
		dataSource.setPassword(env.getProperty("spring.datasource.password"));
		
		return dataSource;
	}
	
	@Autowired
	@Bean(name="sessionFactory")
	public SessionFactory getSessionFactory(DataSource dataSource) throws Exception {
		Properties pro =  new Properties();
		
		pro.put("hibernate.dialect", env.getProperty("spring.jpa.properties.hibernate.dialect"));
	    pro.put("current_session_context_class", env.getProperty("spring.jpa.properties.hibernate.current_session_context_class"));
	    
	    LocalSessionFactoryBean factoryBean = new LocalSessionFactoryBean();
	    
	    factoryBean.setPackagesToScan(new String[] {""});
	    factoryBean.setDataSource(dataSource);
	    factoryBean.setHibernateProperties(pro);
	    factoryBean.afterPropertiesSet();
	    
	    SessionFactory sf = factoryBean.getObject();
	    return sf; 
	}
	
	@Autowired
	@Bean(name="transactionManager")
	public  HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {
		HibernateTransactionManager transManager = new HibernateTransactionManager(sessionFactory);
		
		return transManager;
	}
}
