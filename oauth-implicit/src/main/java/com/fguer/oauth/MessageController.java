package com.fguer.oauth;

import java.security.Principal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {
    
    @GetMapping("/message")
    public String getMessage(Principal principal) {
        return "The message is for user: " + principal.getName();
    }
    
}
