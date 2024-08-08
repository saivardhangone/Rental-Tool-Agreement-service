package com.rental.Rental.Tools.Repository;

import com.rental.Rental.Tools.Entity.ToolEntity;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
@RunWith(SpringRunner.class)
@DataJpaTest

class ToolRepositoryTest {
    @Autowired
    private ToolRepository toolRepository;

    @Test
    void findByToolName() {
        String toolCode="HAMN";
        ToolEntity tool=new ToolEntity("HAMN","HTNL","Hammer");
        toolRepository.save(tool);
        Optional<ToolEntity> foundedTool=toolRepository.findById(toolCode);
        ToolEntity toolEntity=foundedTool.get();
        assertEquals("HAMN",toolEntity.getToolCode());
    }


}