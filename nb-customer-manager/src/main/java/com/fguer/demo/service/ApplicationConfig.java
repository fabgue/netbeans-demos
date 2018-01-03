package com.fguer.demo.service;

import java.util.Set;
import javax.ws.rs.core.Application;

/**
 *
 * @author fmguerrerom
 */
@javax.ws.rs.ApplicationPath("webresources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(com.fguer.demo.service.CustomerFacadeREST.class);
        resources.add(com.fguer.demo.service.DiscountCodeFacadeREST.class);
        resources.add(com.fguer.demo.service.MicroMarketFacadeREST.class);
    }

}
