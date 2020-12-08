package de.gad.batchdemo;

import javax.sql.DataSource;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyDataSource
{
    @Bean
    public DataSource getDataSource() 
    {
        return DataSourceBuilder.create()
            //.driverClassName("com.mysql.jdbc.Driver")//
            .username("root")//
            .password("yop49JZ")//
            .url("jdbc:mysql://localhost:3306/fiducia?allowPublicKeyRetrieval=true&useSSL=false&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Berlin&zeroDateTimeBehavior=convertToNull")
            .build();
    }

}
