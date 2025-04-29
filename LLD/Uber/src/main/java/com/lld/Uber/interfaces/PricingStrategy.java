package com.lld.Uber.interfaces;

import com.lld.Uber.models.TripMetadata;

public interface PricingStrategy {
    public double calclateFair(TripMetadata metadata);
}
