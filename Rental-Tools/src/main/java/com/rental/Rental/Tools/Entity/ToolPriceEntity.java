package com.rental.Rental.Tools.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="tools_price")
public class ToolPriceEntity {
    @Id
    @Column(name="tool_type")
    private String toolType;
    @Column(name="daily_charge")
    private Double dailyCharge;
    @Column(name="weekday_charge")
    private Boolean weekDayCharge;
    @Column(name="weekend_charge")
    private Boolean weekEndCharge;
    @Column(name="holiday_charge")
    private Boolean holidayCharge;
}
