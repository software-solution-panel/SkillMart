package com.swlc.skillmart.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.util.Date;

/**
 * @author Chathumal Jayasingha | [chathumaljayasingha@hotmail.com]
 * @since - 11/1/24 | 2024-November-01[Friday]
 */

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class User implements Serializable {
    @TableGenerator(name="tbl", initialValue= 20000)
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator="tbl")
    private Integer id;
    @NotBlank(message = "first name is mandatory")
    private String firstName;
    private String lastName;
    private String address;
    private String mobile;
    private Boolean available;
    private String type;
    private String serviceArea;
    private String serviceType;
    private String remark;
    private String links;
    private Boolean active;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;



}
