package com.rental.Rental.Tools.Service;

import com.rental.Rental.Tools.Entity.ToolEntity;
import com.rental.Rental.Tools.Repository.ToolRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ToolServiceTest {
    @Mock
    private ToolRepository toolRepository;
    @InjectMocks
    private ToolService toolService;


    @Test
    void register() {
        ToolEntity tool=new ToolEntity("HMNA","Bosch","Hammer");
        when(toolRepository.save(tool)).thenReturn(tool);
        ToolEntity createdTool=toolService.register(tool);
        assertEquals(tool,createdTool);
    }

    @Test
    void findByToolName() {
        ToolEntity tool=new ToolEntity("DRLR","Bosch","Driller");
        when(toolRepository.findById("DRLR")).thenReturn(Optional.of(tool));
        ToolEntity result=toolService.findByToolName("DRLR");
        assertEquals(tool,result);
    }
}