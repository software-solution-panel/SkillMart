package com.swlc.skillmart.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ServiceArea {
    @TableGenerator(name="area", initialValue= 20000)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="area")
    private Integer areaId;
    private String areaName;
}
