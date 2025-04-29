package com.lld.Uber;

import com.lld.Uber.models.Driver;

import java.util.HashMap;

public class DriverManager {
    // Volatile ensures changes are visible to all threads
    private static volatile DriverManager instance;

    HashMap<String, Driver> driversMap;

    // Private constructor to prevent instantiation
    private DriverManager() {
        // Initialization logic (e.g., loading DB driver)
        System.out.println("DriverManager instance created");
    }

    // Global access point
    public static DriverManager getInstance() {
        if (instance == null) {
            synchronized (DriverManager.class) {
                if (instance == null) {
                    instance = new DriverManager();
                }
            }
        }
        return instance;
    }

    public void addDriver(String driverName, Driver driver){
        driversMap.put(driverName, driver);
    }

    public Driver getDriver(String driverName){
        return driversMap.get(driverName);
    }

    public HashMap<String, Driver> getDriversMap(){
        return driversMap;
    }
}
