package com.lld.Uber.interfaces;

import com.lld.Uber.models.Driver;
import com.lld.Uber.models.TripMetadata;

public interface DriverMatchingStrategy {
    public Driver findDriver(TripMetadata tripMetadata);
}
