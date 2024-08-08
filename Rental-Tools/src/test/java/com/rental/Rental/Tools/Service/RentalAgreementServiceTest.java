package com.rental.Rental.Tools.Service;
import com.rental.Rental.Tools.DTO.RentalAgreement;
import com.rental.Rental.Tools.DTO.ToolRentalInformation;
import com.rental.Rental.Tools.Entity.ToolEntity;
import com.rental.Rental.Tools.Entity.ToolPriceEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class RentalAgreementServiceTest {
    @Mock
    private ToolService toolService;
    @Mock
    private ToolPriceService toolPriceService;

    @InjectMocks
    private RentalAgreementService rentalAgreementService;

    private ToolRentalInformation toolRentalInformation;
    private ToolEntity toolEntity;
    private ToolPriceEntity toolPriceEntity;

    @BeforeEach
    public void setUp() throws ParseException {
        toolRentalInformation = new ToolRentalInformation();
        toolRentalInformation.setToolCode("HAIR");
        toolRentalInformation.setRentalDays(5);
        toolRentalInformation.setDiscount(10);
        SimpleDateFormat smf=new SimpleDateFormat("yyyy-MM-dd");
        toolRentalInformation.setCheckOutDate(smf.parse("2024-08-01"));

        toolEntity = new ToolEntity();
        toolEntity.setToolCode("HAIR");
        toolEntity.setToolType("Hammer");
        toolEntity.setBrand("BrandA");

        toolPriceEntity = new ToolPriceEntity();
        toolPriceEntity.setDailyCharge(2.0);
        toolPriceEntity.setToolType("Hammer");
        toolPriceEntity.setHolidayCharge(true);
        toolPriceEntity.setWeekDayCharge(true);
        toolPriceEntity.setWeekEndCharge(false);
    }



    @Test
    void calculateRentalAmount() throws Exception {
        when(toolService.findByToolName("HAIR")).thenReturn(toolEntity);
        when(toolPriceService.findByToolName("Hammer")).thenReturn(toolPriceEntity);
        RentalAgreement rentalAgreement=rentalAgreementService.calculateRentalAmount(toolRentalInformation);
        assertEquals(7.2, rentalAgreement.getFinalCharge());
    }

}