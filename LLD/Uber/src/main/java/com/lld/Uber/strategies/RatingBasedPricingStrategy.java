package com.lld.Uber.strategies;

import com.lld.Uber.interfaces.PricingStrategy;
import com.lld.Uber.models.TripMetadata;

public class RatingBasedPricingStrategy implements PricingStrategy {

    @Override
    public double calclateFair(TripMetadata tripMetadata) {
        return 10.11;
    }
}
