package app.com.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by Micoh F Alvarez on 8/11/2017.
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

        @Autowired
        public void configureGlobal(AuthenticationManagerBuilder builder) throws Exception{

            builder.inMemoryAuthentication().withUser("user").password("password").roles("USER");
            builder.inMemoryAuthentication().withUser("admin    ").password("password").roles("ADMIN");
        }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        super.configure(http);
    }
}

