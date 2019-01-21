package com.fguer.app;

import com.fguer.app.persistence.CityRepository;
import com.fguer.app.persistence.City;
import com.fguer.app.persistence.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DatabaseApplication {
    
    private static final Logger log = LoggerFactory.getLogger(DatabaseApplication.class);

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(DatabaseApplication.class, args);
        //SpringApplication.run(DatabaseApplication.class, args);
        demo(context);
    }

    
    public static void demo(ConfigurableApplicationContext context) {
        CityRepository repository = context.getBean(CityRepository.class);
        for(City city: repository.findAll() ) {
            log.info(city.toString());            
        }
        City cityOne = repository.findOne(3L);
        log.info(cityOne.toString());            
        
        for(City city: repository.findByNameOrCode("B100", "Bogota") ) {
            log.info(city.toString());            
        }
        
        Country country = new Country(1L);
        for(City city: repository.findByCountry(country) ) {
            log.info(city.toString());            
        }
        
    }
}
