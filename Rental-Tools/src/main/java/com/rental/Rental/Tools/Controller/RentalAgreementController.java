package com.rental.Rental.Tools.Controller;

import com.rental.Rental.Tools.DTO.RentalAgreement;
import com.rental.Rental.Tools.DTO.Result;
import com.rental.Rental.Tools.DTO.ToolRentalInformation;
import com.rental.Rental.Tools.Service.RentalAgreementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rent")
public class RentalAgreementController {
    @Autowired
    private RentalAgreementService rentalAgreementService;
    @GetMapping("/")
    public RentalAgreement getRent(@RequestBody ToolRentalInformation toolRentalInformation) throws Exception {
        return  rentalAgreementService.calculateRentalAmount(toolRentalInformation);
    }
}
