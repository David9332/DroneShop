package com.jb.dronelab.bean;

import com.jb.dronelab.values.MyValues;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Scope("prototype")
@Lazy
@Builder
@Primary
public class Customer {
    private int customerId = MyValues.getCustomerId();
    private Date create = new Date();
    private String name;
    private String address; //so hila will know it's address :)
    private Boolean isVIP; //like daniel
    private List<Drone> drones = new ArrayList<>();
    private List<Repair> repairs = new ArrayList<>();

    public void addDrone (Drone drone){this.drones.add(drone);}
    public void addRepair(Repair repair){this.repairs.add(repair);}
}
