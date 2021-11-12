package com.jb.dronelab.bean;

import com.jb.dronelab.values.MyValues;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@Data
@NoArgsConstructor
@AllArgsConstructor
@Scope("prototype")
public class Repair {
    private int id= MyValues.getCustomerId();
    private Date created = new Date();
    private boolean isUrgent;
    private String desc;
    private Double cost;
    private Date finishETA;
    private int parentId; //Forgien key

   //aop - it will pop up a message on screen :)
   public void setUrgent(boolean urgent){isUrgent=urgent;}
}
