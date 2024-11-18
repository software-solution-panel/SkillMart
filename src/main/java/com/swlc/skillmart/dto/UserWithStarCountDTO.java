package com.swlc.skillmart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author Chathumal Jayasingha | [chathumaljayasingha@hotmail.com]
 * @since - 11/1/24 | 2024-November-01[Friday]
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserWithStarCountDTO extends UserDTO implements Serializable {
    private Integer stars;
}
