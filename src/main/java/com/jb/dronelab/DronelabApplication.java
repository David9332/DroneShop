package com.jb.dronelab;

import com.jb.dronelab.bean.Drone;
import com.jb.dronelab.composed.DroneLab;
import com.jb.dronelab.interfaces.DroneTypes;
import com.jb.dronelab.util.TablePrinter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.util.Date;

import static com.jb.dronelab.util.MyUtil.printRow;

@SpringBootApplication //Component scan, configuration scan, configuration
public class DronelabApplication {
	public static void main(String[] args) {
		SpringApplication.run(DronelabApplication.class, args);
	}
}
