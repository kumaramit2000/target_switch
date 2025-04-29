package com.lld.Uber;

import com.lld.Uber.enums.RatingStatus;
import com.lld.Uber.models.Rider;
import org.springframework.stereotype.Service;


@Service
public class UberMainService {
    Rider amit = new Rider("Amit Kumar", RatingStatus.FIVE);
    Rider lalitK = new Rider("Lalit Kumar", RatingStatus.TWO);

    DriverManager driverManager = DriverManager.getInstance();


    // Pta nhi idher kya issue air rha hai... driverManager.addDriver() nhi call ho rha...
    
}
