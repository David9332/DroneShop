package com.jb.dronelab.config;

import com.jb.dronelab.bean.Customer;
import com.jb.dronelab.bean.Drone;
import com.jb.dronelab.interfaces.DroneTypes;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;

import java.util.Date;

@Configuration
public class VIPCustomer {

    //Factory method...
    @Bean
    @Lazy
    public Customer customerIDF(){
        Customer idf = new Customer();
        idf.setName("I.D.F");
        idf.setAddress("Kyrtia TLV");
        idf.setIsVIP(true);

        Drone idfDrone = new Drone();
        idfDrone.setDrone(DroneTypes.DJI.M300);
        idfDrone.setEndWarrantyDate(new Date());
        idfDrone.setWarranty(true);
        idf.addDrone(idfDrone);

        return idf;
    }
}
