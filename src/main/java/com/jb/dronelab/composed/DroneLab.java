package com.jb.dronelab.composed;

import com.jb.dronelab.bean.Customer;
import com.jb.dronelab.bean.Drone;
import com.jb.dronelab.bean.Repair;
import com.jb.dronelab.interfaces.DroneTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.jb.dronelab.util.MyUtil.printRow;

@Component
@Lazy
public class DroneLab {
    @Autowired
    ApplicationContext ctx;

    private List<Customer> customerList = new ArrayList<>();

    public Customer addCustoerIDF(){
        Customer idf = ctx.getBean("customerIDF",Customer.class);
        customerList.add(idf);
        return idf;
    }

    public List<Customer> getCustomerList(){
        return this.customerList;
    }

    public void addCustomer(String name, String address, boolean isVip){
        Customer newCustomer = ctx.getBean(Customer.class);
        newCustomer.setName(name);
        newCustomer.setAddress(address);
        newCustomer.setIsVIP(isVip);
        this.customerList.add(newCustomer);
    }

    public void addDrone(int customerId,
                         DroneTypes drone,
                         boolean isWarrnty,
                         Date endWarrantyDate){
        Drone newDrone = Drone.builder()
                .drone(drone)
                .isWarranty(isWarrnty)
                .endWarrantyDate(endWarrantyDate)
                .build();

        Customer findCustomer = customerList.get(customerId-1);
        if (findCustomer != null){
            findCustomer.addDrone(newDrone);
        } else {
            System.out.println("Customer not found :(");
        }
    }

    public Repair addRepair(int customerId,
                            boolean isUrgent,
                            String description,
                            Double cost,
                            Date finishEta){
        Repair newRepair = ctx.getBean(Repair.class);
        if (isUrgent){
            newRepair.setUrgent(isUrgent);
        }
        newRepair.setDesc(description);
        newRepair.setCost(cost);
        newRepair.setFinishETA(finishEta);

        Customer findCustomer = customerList.get(customerId-1);
        if (findCustomer != null){
            newRepair.setParentId(findCustomer.getCustomerId());
            findCustomer.addRepair(newRepair);
        } else {
            System.out.println("Customer not found :(");
        }
        return newRepair;
    }

    public List<Drone> getDroneList(){
        //short the method :)
        List<Drone> returnList = new ArrayList<>();
        for (Customer customerItem:this.customerList){
            for (Drone droneItem:customerItem.getDrones()){
                returnList.add(droneItem);
            }
        }
        return returnList;
    }

    public List<Repair> getRepairList(){
        //short the method :) !!!!!  use google :)
        List<Repair> returnList = new ArrayList<>();
        for (Customer customerItem:this.customerList){
            returnList.addAll(customerItem.getRepairs());
        }
        return returnList;
    }

    public void getSummary(){
        //we should use singleton or static, to update the info in repair/drones level
        int totalEarnings = 0;
        int totalDrones = 0;
        int totalRepairs = 0;
        int totalCustomer = customerList.size();

        for (Repair item : getRepairList()){
            totalEarnings+=item.getCost();
            totalRepairs+=1;
        }

        totalDrones = getDroneList().size();

        //formatter
        NumberFormat format = NumberFormat.getCurrencyInstance();
        //123.56789
        //₪123.56 -> currency

        printRow();
        System.out.printf("total Customer: %d\ntotal eranings: %s\ntotal repairs: %d\ntotal drones: %d\n",totalCustomer,format.format(totalEarnings),totalRepairs,totalDrones);
        printRow();
    }
}
