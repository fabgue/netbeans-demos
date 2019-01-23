package com.fguer.oauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@EnableResourceServer
@SpringBootApplication
public class OAuthImplicitApplication {

    public static void main(String[] args) {
        SpringApplication.run(OAuthImplicitApplication.class, args);
    }

    @Bean
    protected ResourceServerConfigurerAdapter resourceServerConfigurerAdapter() {
        return new ResourceServerConfigurerAdapter() {
            @Override
            public void configure(HttpSecurity http) throws Exception {
                http.authorizeRequests()
                    .antMatchers("/", "/index.html", "/sign-in-widget-config").permitAll()
                    .anyRequest().authenticated();
            }
        };
    }

}
