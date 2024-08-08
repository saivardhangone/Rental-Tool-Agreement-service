package com.rental.Rental.Tools.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;


@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="tools_details")

public class ToolEntity{
    @Id
    @Column(name="tool_code")
    private String toolCode;
    @Column(name="brand")
    private String brand;
    @Column(name="tool_type")
    private String toolType;
}
