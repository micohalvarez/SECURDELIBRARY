package app.com.util;

import app.com.service.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;

/**
 * Created by Micoh F Alvarez on 8/9/2017.
 */
@Configuration
@EnableWebMvc
public class AppConfig extends WebMvcConfigurerAdapter{

        @Bean
        public InternalResourceViewResolver viewResolver(){
             InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
             internalResourceViewResolver.setPrefix("/");
             internalResourceViewResolver.setSuffix(".jsp");

             return internalResourceViewResolver;
    }


        @Override
        public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer){
            configurer.enable();
        }

    @Bean
    public DataSource getDataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/securde");
        dataSource.setUsername("root");
        dataSource.setPassword("MICOHALVAREZ");


        return dataSource;
    }

    @Bean public UserDAO getUserDAO() {
        return new UserDAOImpl(getDataSource());
    }

    @Bean public ResourceDAO getBookService() {
        return new ResourceDAOImpl(getDataSource());
    }

    @Bean public RoomDAO getReviewDAO() {
        return new RoomDAOImpl(getDataSource());
    }


}
