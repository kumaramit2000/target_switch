package com.lld.Uber.strategies;

import com.lld.Uber.DriverManager;
import com.lld.Uber.interfaces.DriverMatchingStrategy;
import com.lld.Uber.models.Driver;
import com.lld.Uber.models.TripMetadata;

import java.util.HashMap;

public class LeastTimeBasedDriverMatchingStrategy implements DriverMatchingStrategy {

    @Override
    public Driver findDriver(TripMetadata tripMetadata) {
        DriverManager driverMgr = DriverManager.getInstance();

        HashMap<String, Driver> driversMap =  driverMgr.getDriversMap();
        return driversMap.get(0);
    }
}
