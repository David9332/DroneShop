package com.jb.dronelab.clr;

import com.jb.dronelab.bean.Drone;
import com.jb.dronelab.composed.DroneLab;
import com.jb.dronelab.interfaces.DroneTypes;
import com.jb.dronelab.util.TablePrinter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Date;

import static com.jb.dronelab.util.MyUtil.printRow;

@Component
@Order(1)
public class Init implements CommandLineRunner {
    @Autowired
    ApplicationContext ctx;

    @Override
    public void run(String... args) throws Exception {
        printRow();
        System.out.println("IOC - Container was created :)");
        printRow();

        DroneLab chenAndSons = ctx.getBean(DroneLab.class);
        chenAndSons.addCustomer("Moshe","Moddien",false);
        chenAndSons.addCustomer("Daniel","Ashdod",true);

        chenAndSons.addDrone(1, DroneTypes.Elvina.guci,false,new Date());
        chenAndSons.addDrone(2,DroneTypes.DJI.Air,true,new Date());

        //System.out.println(chenAndSons.getCustomerList());
        TablePrinter.print(chenAndSons.getCustomerList());
        Drone drone = ctx.getBean(Drone.class);
        
    }
}
