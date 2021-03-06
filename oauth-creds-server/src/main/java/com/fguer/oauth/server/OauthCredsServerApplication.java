package com.fguer.oauth.server;

import java.security.Principal;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.access.expression.method.MethodSecurityExpressionHandler;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.GlobalMethodSecurityConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.expression.OAuth2MethodSecurityExpressionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@EnableResourceServer
@SpringBootApplication
public class OauthCredsServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(OauthCredsServerApplication.class, args);
    }

    /**
     * Allows for @PreAuthorize annotation processing.
     */
    @EnableGlobalMethodSecurity(prePostEnabled = true)
    protected static class GlobalSecurityConfiguration extends GlobalMethodSecurityConfiguration {
        @Override
        protected MethodSecurityExpressionHandler createExpressionHandler() {
            return new OAuth2MethodSecurityExpressionHandler();
        }
    }

    @RestController
    public class MessageController {
        @GetMapping("/message")
        @PreAuthorize("#oauth2.hasScope('simple_app')")
        public String getMessage(Principal principal) {
            return "The message for user: " + principal.getName();
        }

    }    
}
