package com.rental.Rental.Tools.Service;
import com.rental.Rental.Tools.Entity.ToolEntity;
import com.rental.Rental.Tools.Repository.ToolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ToolService {
    @Autowired
    private ToolRepository toolRepository;
    public ToolEntity register(ToolEntity toolEntity){
        ToolEntity saved = toolRepository.save(toolEntity);
        return saved;
    }
    public ToolEntity findByToolName(String toolCode){
        Optional<ToolEntity> tool= toolRepository.findById(toolCode);
            if(tool.isPresent()){
                ToolEntity toolDetails=tool.get();
                return  toolDetails;
            }
            else{
                return null;
            }
    }

}
