package com.swlc.skillmart.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ServiceType {
    @TableGenerator(name="type", initialValue= 70000)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="type")
    private Integer typeId;
    private String type;
}
