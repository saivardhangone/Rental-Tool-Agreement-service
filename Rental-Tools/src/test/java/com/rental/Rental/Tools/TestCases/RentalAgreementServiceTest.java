package com.rental.Rental.Tools.TestCases;

import com.rental.Rental.Tools.DTO.Result;
import com.rental.Rental.Tools.DTO.ToolRentalInformation;
import com.rental.Rental.Tools.Service.RentalAgreementService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;



public class RentalAgreementServiceTest {
    @Autowired
    private RentalAgreementService rentalAgreementService;
//    public void rentalAgreementTest() throws ParseException {
//        ToolRentalInformation rentalInformation;
//        SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yy");
//        Date checkoutDate = sdf.parse("06/02/25");
//        rentalInformation = new ToolRentalInformation("JAKR",checkoutDate,5,101);
//        Result result=rentalAgreementService.calculateRentalAmount(rentalInformation);
//        System.out.println(result);
//    }
}
