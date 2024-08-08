package com.rental.Rental.Tools.Controller;

import com.rental.Rental.Tools.DTO.UpdateToolPrice;
import com.rental.Rental.Tools.Entity.ToolEntity;
import com.rental.Rental.Tools.Entity.ToolPriceEntity;
import com.rental.Rental.Tools.Service.ToolPriceService;
import com.rental.Rental.Tools.Service.ToolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tool")
public class ToolController {
    @Autowired
    private ToolService toolService;
    @Autowired
    private ToolPriceService toolPriceService;
    @PostMapping("/")
    public ToolEntity register(@RequestBody ToolEntity toolEntity){
        return toolService.register(toolEntity);
    }
    @PostMapping("/price")
    public ToolPriceEntity register(@RequestBody ToolPriceEntity toolPriceEntity){
        return toolPriceService.register(toolPriceEntity);
    }
    @PutMapping("/price")
    public String updatePrice(@RequestBody UpdateToolPrice changeOfToolPrice){
        return toolPriceService.updatePrice(changeOfToolPrice);
    }

}
