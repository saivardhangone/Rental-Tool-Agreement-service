package com.rental.Rental.Tools.Repository;


import com.rental.Rental.Tools.Entity.ToolEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ToolRepository extends JpaRepository<ToolEntity, String> {

}
