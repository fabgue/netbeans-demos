package com.fguer.demo;

import java.time.LocalTime;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

/**
 *
 * @author fguerrero
 */
@RestController
@RequestMapping("/")
public class GreetingsController {
    
    @RequestMapping(path = "/time", method = GET)
    public String sayHelloWorld(){
        return "Hello World @ " + LocalTime.now();
    }    
    
    /*
    @RequestMapping(method = GET)
    public List<Object> list() {
        return null;
    }
    
    @RequestMapping(value = "/{id}", method = GET)
    public Object get(@PathVariable String id) {
        return null;
    }
    
    @RequestMapping(value = "/{id}", method = PUT)
    public ResponseEntity<?> put(@PathVariable String id, @RequestBody Object input) {
        return null;
    }
    
    @RequestMapping(value = "/{id}", method = POST)
    public ResponseEntity<?> post(@PathVariable String id, @RequestBody Object input) {
        return null;
    }
    
    @RequestMapping(value = "/{id}", method = DELETE)
    public ResponseEntity<Object> delete(@PathVariable String id) {
        return null;
    }
    */
}
