package com.springConfig;


import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.Properties;

@Configuration
@PropertySource("classpath:properties/database.properties")
@EnableTransactionManagement
public class HibernateConfig {

    @Bean
    public DataSource dataSource(
            @Value("jdbc:mysql://localhost:3306/food_order_db") String url,
            @Value("root") String username,
            @Value("YWgaMaZpf2") String password
    ) throws SQLException {
        DriverManagerDataSource source = new DriverManagerDataSource(
                url, username, password
        );
        source.setDriverClassName("com.mysql.jdbc.Driver");
        return source;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory(DataSource dataSource) {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource);
        sessionFactory.setPackagesToScan("com.model");
        sessionFactory.setHibernateProperties(this.hibernateProperties());
        return sessionFactory;

    }

    @Bean
    public Properties hibernateProperties() {
        return new Properties() {
            {
                setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
                //setProperty("hibernate.chach.provider_class", "org.hibernate.cache.NoCacheProvider");
                setProperty("hibernate.show_sql", "true");
                setProperty("hibernate.hbm2ddl.auto", "update");
                // setProperty("hibernate.hbm2ddl.auto", "create-drop");
            }
        };
    }

    @Bean
    public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
        HibernateTransactionManager txManager = new HibernateTransactionManager();
        txManager.setSessionFactory(sessionFactory);
        return txManager;
    }

}