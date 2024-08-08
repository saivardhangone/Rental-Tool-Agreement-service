package com.rental.Rental.Tools.Service;


import com.rental.Rental.Tools.DTO.UpdateToolPrice;
import com.rental.Rental.Tools.Entity.ToolPriceEntity;
import com.rental.Rental.Tools.Repository.ToolPriceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ToolPriceService {
    @Autowired
    private ToolPriceRepository toolPriceRepository;
    public ToolPriceEntity register(ToolPriceEntity toolPriceEntity){
        return toolPriceRepository.save(toolPriceEntity);
    }
    public String updatePrice (UpdateToolPrice updateToolPrice)
    {
        String result="";
         Optional<ToolPriceEntity> toolPrice=toolPriceRepository.findById(updateToolPrice.getToolType());
         if(toolPrice.isPresent())
         {
             ToolPriceEntity toolPriceEntity = toolPrice.get();
             toolPriceEntity.setDailyCharge(Double.valueOf(updateToolPrice.getPrice()));
             toolPriceRepository.save(toolPriceEntity);
             result = "updated";
         }
         else{
             result="Data Not Found";
         }
         return  result;
    }
    public ToolPriceEntity findByToolName(String toolName)
    {
        Optional<ToolPriceEntity> tool=toolPriceRepository.findById(toolName);
        if(tool.isPresent()){
            ToolPriceEntity toolDetails=tool.get();
            return toolDetails;
        }
        else{
            return  null;
        }
    }


}
