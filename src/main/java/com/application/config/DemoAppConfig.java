package com.application.config;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.awt.color.ProfileDataException;
import java.beans.PropertyVetoException;
import java.util.logging.Logger;

@SpringBootApplication(scanBasePackages = "com.application")
@PropertySource("classpath:persistence-sqlserver.properties")
public class DemoAppConfig {

    public static void main(String[] args) {
        SpringApplication.run(DemoAppConfig.class,args);
    }

    @Autowired
    private Environment env; //Helper class for spinrg (containt variables)

    //Create a logger
    private Logger logger = Logger.getLogger(getClass().getName());


    //Define bean for the view resolver
    @Bean
    public ViewResolver viewResolver(){

        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/view/");
        resolver.setSuffix(".jsp");

        return resolver;

    }


    //Bean for security data source
    @Bean
    public DataSource securityDataSource(){

        ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource(); //Create connecton pool

        try { //Read the database configuration from driver
            comboPooledDataSource.setDriverClass(env.getProperty("jdbc.driver")); //env - read from properties file
        }catch(PropertyVetoException e){
            throw new RuntimeException(e);
        }

        logger.info(">>> jdbc.url = " + env.getProperty("jdbc.url"));
        logger.info(">>> jdbc.user = " + env.getProperty("jdbc.user"));

        //Properties for database connection
        comboPooledDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
        comboPooledDataSource.setUser(env.getProperty("jdbc.user"));
        comboPooledDataSource.setPassword(env.getProperty("jdbc.password"));

        //Properties for pool size
        comboPooledDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
        comboPooledDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
        comboPooledDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
        comboPooledDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));


        return comboPooledDataSource;
    }


    //Helper method for convertion values from properties file
    //From properties value always comes as string
    //In this method value change to type int
    private int getIntProperty (String propName){
        String propVal = env.getProperty(propName);
        int intPropVal = Integer.parseInt(propVal);
        return intPropVal;
    }

}
