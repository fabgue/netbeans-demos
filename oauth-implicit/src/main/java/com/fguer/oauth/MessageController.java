package com.fguer.oauth;

import java.security.Principal;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    
    @GetMapping("/message")
    @PreAuthorize("hasAuthority('Everyone') || #oauth2.hasScope('email')")
    public String getMessage(Principal principal) {
        return "The message is for user: " + principal.getName();
    }
    
}
