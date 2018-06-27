package com.truextend.reciipeapp.config;

import com.truextend.reciipeapp.services.UserSecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final Environment env;
    private final UserSecurityService userSecurityService;

    public SecurityConfig(Environment env, UserSecurityService userSecurityService) {
        this.env = env;
        this.userSecurityService = userSecurityService;
    }

    private BCryptPasswordEncoder passwordEncoder() {
        return SecurityUtility.passwordEncoder();
    }

    private static final String[] PUBLIC_MATCHERS = {
            "/css/**",
            "/js/**",
            "/image/**",
            "/book/**",
            "/user/**",
            "/api/v1/users/newUser",
            "/api/v1/recipes/*",
            "/api/v1/users/**"
    };

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable().cors().disable().httpBasic().and().authorizeRequests()
                .antMatchers(PUBLIC_MATCHERS).permitAll().anyRequest().authenticated();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userSecurityService).passwordEncoder(passwordEncoder());
    }
 }
