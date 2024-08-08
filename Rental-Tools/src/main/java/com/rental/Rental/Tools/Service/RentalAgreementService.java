package com.rental.Rental.Tools.Service;

import java.text.DecimalFormat;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.Month;
import java.time.ZoneId;
import java.util.*;
import com.rental.Rental.Tools.DTO.RentalAgreement;
import com.rental.Rental.Tools.DTO.ToolRentalInformation;
import com.rental.Rental.Tools.Entity.ToolEntity;
import com.rental.Rental.Tools.Entity.ToolPriceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalAgreementService {
    @Autowired
    private ToolService toolService;
    @Autowired
    private  ToolPriceService toolPriceService;

    private RentalAgreement rentalAgreement=new RentalAgreement();
        private boolean isWeekend(LocalDate localDate){
            return DayOfWeek.SATURDAY.equals(localDate.getDayOfWeek()) || DayOfWeek.SUNDAY.equals(localDate.getDayOfWeek());
        }
        private boolean isWeekday(LocalDate localDate){
            return !isWeekend(localDate);
        }
        private boolean isIndependenceDay(LocalDate localDate){
            return Month.JULY.equals(localDate.getMonth()) && localDate.getDayOfMonth() == 4;
        }
        private boolean isLaborDay(LocalDate localDate){
            return Month.SEPTEMBER.equals(localDate.getMonth()) && localDate.getDayOfMonth()<=7 && DayOfWeek.MONDAY.equals(localDate.getDayOfWeek());
        }
        private boolean isHoliday(LocalDate localDate){
            return isLaborDay(localDate) || isIndependenceDay(localDate);
        }
        private double calculateRentalAmount(int chargeableDays, double dailyCharge){
            return chargeableDays * dailyCharge;
        }

        private int calculateChargeableDays(int totalRentalDays, LocalDate checkoutDate, ToolPriceEntity toolRentDetails){
            int chargeableDays = 0;
            for(int i=0; i<totalRentalDays; i++){
                LocalDate dateForPayableCheck = checkoutDate.minusDays(i);
                DayOfWeek dayOfWeek = dateForPayableCheck.getDayOfWeek();
                boolean isIndependenceDay = isIndependenceDay(dateForPayableCheck);
                boolean isWeekend = isWeekend(dateForPayableCheck);
                boolean isLaborDay = isLaborDay(dateForPayableCheck);
//            System.out.println(dateForPayableCheck+"'s day is : "+ dayOfWeek);
//            System.out.println(dateForPayableCheck+" isIndependenceDay: "+ isIndependenceDay);
//            System.out.println(dateForPayableCheck+" isLaborDay: "+ isLaborDay);
//            System.out.println(dateForPayableCheck+" isWeekend: "+ isWeekend);
                if(isIndependenceDay ){
                    if(!toolRentDetails.getHolidayCharge()){
                        if(isWeekend(dateForPayableCheck)){
                            if(DayOfWeek.SATURDAY.equals(dateForPayableCheck.getDayOfWeek()) && i!=0){
                                if(chargeableDays > 0) {
                                    chargeableDays--;
                                }
                            }else if(DayOfWeek.SUNDAY.equals(dateForPayableCheck.getDayOfWeek()) && i!=totalRentalDays-1){
                                if(chargeableDays > 0) {
                                    chargeableDays--;
                                }
                            }
                        }
                        continue;
                    }else{
                        chargeableDays++;
                    }
                }
                if( isWeekend && !toolRentDetails.getWeekEndCharge()){
                    continue;
                }
                if(isLaborDay && !toolRentDetails.getHolidayCharge()){
                    continue;
                }
                if(toolRentDetails.getWeekDayCharge()) {
                    chargeableDays++;
                }
            }
            return chargeableDays;
        }
        public RentalAgreement calculateRentalAmount(ToolRentalInformation toolRentalInformation) throws Exception {
            validateRequest(toolRentalInformation);
            ToolEntity toolDetails=toolService.findByToolName(toolRentalInformation.getToolCode());
            if(toolDetails!=null){
                ToolPriceEntity toolRentDetails=toolPriceService.findByToolName(toolDetails.getToolType());
                if(toolRentDetails!=null){
                    Date checkOutDate = toolRentalInformation.getCheckOutDate();
                    LocalDate checkoutDateLocalDate = checkOutDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                    int chargeableDays = calculateChargeableDays(toolRentalInformation.getRentalDays(), checkoutDateLocalDate, toolRentDetails);
                    double totalRentAmount = calculateRentalAmount(chargeableDays, toolRentDetails.getDailyCharge());
                    double discountAmount = totalRentAmount * toolRentalInformation.getDiscount()/100;
                    double finalAmount = totalRentAmount - discountAmount;
                    rentalAgreement.setRentalDays(toolRentalInformation.getRentalDays());
                    rentalAgreement.setCheckOutDate(toolRentalInformation.getCheckOutDate());
                    rentalAgreement.setDiscountPercentage(toolRentalInformation.getDiscount());
                    rentalAgreement.setToolCode(toolRentalInformation.getToolCode());
                    rentalAgreement.setToolType(toolDetails.getToolType());
                    rentalAgreement.setToolBrand(toolDetails.getBrand());
                    DecimalFormat df = new DecimalFormat("####0.00");
                    rentalAgreement.setDiscountAmount(Double.parseDouble(df.format(discountAmount)));
                    rentalAgreement.setDailyCharge(Double.parseDouble(df.format(toolRentDetails.getDailyCharge())));
                    rentalAgreement.setFinalCharge(Double.parseDouble(df.format(finalAmount)));
                }
            }
            return rentalAgreement ;
        }
        public void validateRequest(ToolRentalInformation toolRentalInformation) throws Exception {
            if(toolRentalInformation.getRentalDays() == 0){
                throw new Exception("Rental day count is not 1 or greater");
            }
            if(toolRentalInformation.getDiscount() < 0 || toolRentalInformation.getDiscount() > 100){
                throw new Exception("Discount percent is not in the range 0-100");
            }
        }

}






