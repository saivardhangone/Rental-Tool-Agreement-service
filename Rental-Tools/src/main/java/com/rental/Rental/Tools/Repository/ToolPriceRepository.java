package com.rental.Rental.Tools.Repository;

import com.rental.Rental.Tools.Entity.ToolPriceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ToolPriceRepository extends JpaRepository<ToolPriceEntity,String> {

}
