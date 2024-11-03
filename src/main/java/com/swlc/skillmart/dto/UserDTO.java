package com.swlc.skillmart.dto;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.sql.Date;

/**
 * @author Chathumal Jayasingha | [chathumaljayasingha@hotmail.com]
 * @since - 11/1/24 | 2024-November-01[Friday]
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDTO implements Serializable {
    private Long id;
    private String firstName;
    private String lastName;
    private String address;
    private String mobile;


}
