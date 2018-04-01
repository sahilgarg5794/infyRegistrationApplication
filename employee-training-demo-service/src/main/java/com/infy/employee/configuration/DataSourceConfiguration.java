//package com.infy.employee.configuration;
//
//import com.mchange.v2.c3p0.ComboPooledDataSource;
//import lombok.Setter;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import java.beans.PropertyVetoException;
//
//@Configuration
//@ConfigurationProperties(prefix = "infyApplication.mariaDB")
//@Setter
//public class DataSourceConfiguration {
//
//    private String jdbcUrl;
//    private String username;
//    private String password;
//    private String driverClassName;
//
//    @Bean
//    public ComboPooledDataSource dataSource() throws PropertyVetoException {
//        ComboPooledDataSource dataSource=new ComboPooledDataSource();
//        dataSource.setDriverClass(driverClassName); //loads the jdbc driver
//        dataSource.setJdbcUrl(jdbcUrl);
//        dataSource.setUser(username);
//        dataSource.setPassword(password);
//        return dataSource;
//    }
//}
