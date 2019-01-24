package com.fguer.oauth.client;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class OauthCredsClientApplication implements CommandLineRunner  {
    
    private final Logger logger = LoggerFactory.getLogger(OauthCredsClientApplication.class);
    
    @Value("#{ @environment['example.baseUrl'] }")
    private String serverBaseUrl;    

    public static void main(String[] args) {
        SpringApplication.run(OauthCredsClientApplication.class, args);
    }

    @Bean
    @ConfigurationProperties("example.oauth2.client")
    protected ClientCredentialsResourceDetails oAuthDetails() {
        return new ClientCredentialsResourceDetails();
    }

    @Bean
    protected RestTemplate restTemplate() {
        return new OAuth2RestTemplate(oAuthDetails());
    }

    @Override
    public void run(String... args) {
        logger.info("Message: {}", restTemplate().getForObject(serverBaseUrl + "/message", String.class));
    }
}
