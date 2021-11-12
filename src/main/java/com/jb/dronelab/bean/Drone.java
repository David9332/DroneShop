package com.jb.dronelab.bean;

import com.jb.dronelab.interfaces.DroneTypes;
import com.jb.dronelab.values.MyValues;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Scope("prototype")
@Lazy
@Builder
public class Drone {
    private int id= MyValues.getDroneId();
    private DroneTypes drone;
    private Date created = new Date();
    private boolean isWarranty;
    private Date endWarrantyDate;
}
