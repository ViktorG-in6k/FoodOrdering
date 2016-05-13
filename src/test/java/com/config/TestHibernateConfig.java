package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

@Configuration
@ComponentScan("com")
@EnableTransactionManagement
public class TestHibernateConfig {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.hsqldb.jdbcDriver");
        ds.setUrl("jdbc:hsqldb:mem:testdb");
        ds.setUsername("sa");
        ds.setPassword("");
        return ds;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        final LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan(new String[]{"com"});
        sessionFactory.setHibernateProperties(hibernateProperties());
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager() {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory().getObject());
        return txManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation() {
        return new PersistenceExceptionTranslationPostProcessor();
    }

    final Properties hibernateProperties() {
        return new Properties() {
            {
                setProperty("hibernate.archive.autodetection", "class, hbm");
                setProperty("hibernate.dialect", "com.config.ImprovedHSQLDialect");
                setProperty("hibernate.connection.driver_class","org.hsqldb.jdbcDriver");
                setProperty("hibernate.connection.username", "sa");
                setProperty("hibernate.connection.password", "");
                setProperty("hibernate.connection.url", "jdbc:hsqldb:mem:testdb");
                setProperty("hibernate.show_sql", "false");
                setProperty("hibernate.default_schema", " PUBLIC");
                setProperty("hibernate.current_session_context_class", "org.springframework.orm.hibernate5.SpringSessionContext");
                setProperty("hibernate.hbm2ddl.auto", "create");
            }
        };
    }
}

