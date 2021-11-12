package com.jb.dronelab.values;

public class MyValues {
    private static int customerId=0;
    private static int droneId=0;
    private static int repairId=0;

    public static int getCustomerId() {
        customerId+=1;
        return customerId;
    }

    public static int getDroneId() {
        droneId+=1;
        return droneId;
    }

    public static int getRepairId() {
        repairId+=1;
        return repairId;
    }
}
