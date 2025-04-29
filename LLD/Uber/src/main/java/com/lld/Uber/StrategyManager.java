package com.lld.Uber;

import com.lld.Uber.interfaces.DriverMatchingStrategy;
import com.lld.Uber.interfaces.PricingStrategy;
import com.lld.Uber.models.TripMetadata;
import com.lld.Uber.strategies.LeastTimeBasedDriverMatchingStrategy;
import com.lld.Uber.strategies.RatingBasedPricingStrategy;

public class StrategyManager {
    private static volatile StrategyManager instance;

    private StrategyManager(){}

    public static StrategyManager getInstance(){
        if(instance==null){
            synchronized (StrategyManager.class){
                if(instance==null){
                    instance = new StrategyManager();
                }
            }
        }
        return instance;
    }

    public PricingStrategy determinePricingStrategy(TripMetadata tripMetadata){
        return new RatingBasedPricingStrategy();
    }

    public DriverMatchingStrategy determineDriverMatchingStrategy(TripMetadata tripMetadata){
        return new LeastTimeBasedDriverMatchingStrategy();
    }
}
