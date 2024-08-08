package com.rental.Rental.Tools.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor

public class RentalAgreement {
    private String toolCode;
    private String toolType;
    private String toolBrand;
    private Integer rentalDays;
    private Date checkOutDate;
    private Double dailyCharge;
    private Integer discountPercentage;
    private Double discountAmount;
    private Double finalCharge;

}
