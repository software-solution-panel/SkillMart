package com.swlc.skillmart.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RateDTO {
    private String username;
    private String contact;
    private String comment;
    private Integer stars;
    private Integer userId;
}
