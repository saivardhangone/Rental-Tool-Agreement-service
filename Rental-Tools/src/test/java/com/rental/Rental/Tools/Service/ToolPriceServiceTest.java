package com.rental.Rental.Tools.Service;

import com.rental.Rental.Tools.DTO.UpdateToolPrice;
import com.rental.Rental.Tools.Entity.ToolPriceEntity;
import com.rental.Rental.Tools.Repository.ToolPriceRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)

class ToolPriceServiceTest {
    @Mock
    private ToolPriceRepository toolPriceRepository;
    @InjectMocks
    private ToolPriceService toolPriceService;

    @Test
    void register() {
        ToolPriceEntity tool=new ToolPriceEntity("HAMN",2.31,true,true,true);
        when(toolPriceRepository.save(tool)).thenReturn(tool);
        ToolPriceEntity result=toolPriceService.register(tool);
        assertEquals(tool,result);
    }

    @Test
    void updatePrice() {
        ToolPriceEntity tool=new ToolPriceEntity("HAMN",2.31,true,true,true);
        when(toolPriceRepository.save(tool)).thenReturn(tool);
        when(toolPriceRepository.findById("HAMN")).thenReturn(Optional.of(tool));
        UpdateToolPrice updatedTool=new UpdateToolPrice("HAMN",3.14);
        ToolPriceEntity updatedPrice=new ToolPriceEntity("HAMN",3.14,true,true,true);
        String result=toolPriceService.updatePrice(updatedTool);
        assertEquals("updated",result);
    }
    @Test
    void updatePriceWithoutTool(){
        UpdateToolPrice toolPrice=new UpdateToolPrice("HARE",3.82);
        String result=toolPriceService.updatePrice(toolPrice);
        assertEquals("Data Not Found",result);
    }

    @Test
    void findByToolName() {
        ToolPriceEntity tool=new ToolPriceEntity("Hammer",2.31,true,true,true);
        when(toolPriceRepository.findById("Hammer")).thenReturn(Optional.of(tool));
        ToolPriceEntity result=toolPriceService.findByToolName("Hammer");
        assertEquals(tool,result);
    }
    @Test
    void findByToolNameWhenItIsNotFound(){
        ToolPriceEntity result=toolPriceService.findByToolName("Hammer");
        assertEquals(null,result);
    }
}