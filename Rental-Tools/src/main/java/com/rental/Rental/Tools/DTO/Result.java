package com.rental.Rental.Tools.DTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class Result {
    private double rentalAmount;
    private String toolCode;
    private String toolType;
    private double discountAmount;
    private int chargeableDays;
}
