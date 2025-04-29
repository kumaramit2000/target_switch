package com.lld.Uber;

import com.lld.Uber.interfaces.DriverMatchingStrategy;
import com.lld.Uber.interfaces.PricingStrategy;
import com.lld.Uber.models.*;

import java.util.HashMap;

public class TripManager {
    public  static  volatile TripManager instance;
    private RiderManager riderManager;
    private DriverManager driverManager;
    HashMap<Integer, TripMetadata> tripsMetadataInfo;
    HashMap<Integer, Trip> tripsInfo;

    private TripManager(){
        riderManager = RiderManager.getInstance();
        driverManager = DriverManager.getInstance();
    }

    public static TripManager getInstance(){
        if(instance==null){
            synchronized (TripManager.class){
                if(instance==null){
                    instance = new TripManager();
                }
            }
        }
        return instance;
    }

    public HashMap<Integer, Trip> getTripsMap(){
        return tripsInfo;
    }

    public void createTrip(Rider rider, Location src, Location dest){
        TripMetadata tripMetadata = new TripMetadata(src, dest, rider.getRating());
        StrategyManager strategyManager = StrategyManager.getInstance();

        PricingStrategy pricingStrategy = strategyManager.determinePricingStrategy(tripMetadata);
        DriverMatchingStrategy driverMatchingStrategy = strategyManager.determineDriverMatchingStrategy(tripMetadata);

        Driver driver = driverMatchingStrategy.findDriver(tripMetadata);
        double tripPrice = pricingStrategy.calclateFair(tripMetadata);

        Trip trip = new Trip();
        int tripId = trip.getTripId();
        tripsInfo.put(tripId,trip);
        tripsMetadataInfo.put(tripId,tripMetadata);
    }
}
