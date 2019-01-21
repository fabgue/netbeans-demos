package com.fguer.app.persistence;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

//@Component
public interface CityRepository extends CrudRepository<City, Long> {
   List<City> findByCountry(Country country);
   List<City> findByCountryOrderByName(Country country);
   List<City> findByPopulationGreaterThan(Integer population);
   List<City> findByNameContaining(String nameSubstring);
   List<City> findByNameAndCountry(String name, Country country);
   
    @Query(value="select c from City c where c.name = :name or c.postCode = :code")
    List<City> findByNameOrCode(@Param("code")String postCode, @Param("name")String name);   
}