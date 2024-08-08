package com.rental.Rental.Tools.DTO;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
public class ToolRentalInformation {
    private String toolCode;
    private Date checkOutDate;
    private Integer rentalDays;
    private Integer discount;
}
