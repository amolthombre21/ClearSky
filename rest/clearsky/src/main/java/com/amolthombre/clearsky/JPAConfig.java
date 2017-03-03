package com.amolthombre.clearsky;

import java.util.Properties;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
public class JPAConfig {

    @Bean
    public LocalContainerEntityManagerFactoryBean emfb() {
        LocalContainerEntityManagerFactoryBean emf = new LocalContainerEntityManagerFactoryBean();
        emf.setJpaVendorAdapter(new HibernateJpaVendorAdapter());
        emf.setDataSource(getDataSource());
        emf.setPackagesToScan("com.amolthombre.clearsky.entity");
        emf.setJpaProperties(setJpaProperties());
        return emf;
    }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource driverManagerDataDource = new DriverManagerDataSource();
        driverManagerDataDource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        driverManagerDataDource
                .setUrl("jdbc:mysql://localhost:3306/example_db");
        driverManagerDataDource.setUsername("root");
        driverManagerDataDource.setPassword("root");
        return driverManagerDataDource;
    }

    @Bean
    public Properties setJpaProperties() {
        Properties props = new Properties();
        props.setProperty("hibernate.dialect",
                "org.hibernate.dialect.MySQLDialect");
        props.setProperty("hibernate.hbm2ddl.auto", "validate");
        props.setProperty("hibernate.show_sql", "true");
        props.setProperty("hibernate.format_sql", "true");
        return props;
    }

    @Bean
    public PlatformTransactionManager ptm(EntityManagerFactory emf) {
        return new JpaTransactionManager(emf);
    }
}