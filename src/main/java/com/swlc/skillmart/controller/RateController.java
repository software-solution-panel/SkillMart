package com.swlc.skillmart.controller;

import com.swlc.skillmart.dto.RateDTO;
import com.swlc.skillmart.dto.UserDTO;
import com.swlc.skillmart.service.RateService;
import com.swlc.skillmart.service.UserService;
import com.swlc.skillmart.util.StandardResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Chathumal Jayasingha | [chathumaljayasingha@hotmail.com]
 * @since - 11/1/24 | 2024-November-01[Friday]
 */

@RestController
@CrossOrigin
@RequestMapping("api/v1/rate")
public class RateController {

    @Autowired
    private UserService userService;

    @Autowired
    private RateService rateService;

    @PostMapping("/addRate")
    private ResponseEntity<StandardResponse<?>> addRate(@RequestBody RateDTO dto) {
        return rateService.addRate(dto);
    }

    @GetMapping("/findAllRatesForUser")
    private ResponseEntity<StandardResponse<?>> findAllRatesForUser(@RequestParam Integer userId) {
        if (userId == null) {
            return new ResponseEntity<>(new StandardResponse<>(HttpStatus.BAD_REQUEST.value(), "Enter valid user id for get all rates", "user id not valid"), HttpStatus.BAD_REQUEST);
        } else return rateService.findAllRatesForUser(userId);
    }

    @GetMapping("/findUserOrderByRateStarCount")
    private ResponseEntity<StandardResponse<?>> findUserOrderByRateStarCount() {
        return rateService.findUserOrderByRateStarCount();
    }

    @GetMapping("/findUserByServiceAreaLike")
    private ResponseEntity<StandardResponse<?>> findUserByServiceAreaLike(@RequestParam String serviceArea) {
        if (serviceArea != null) {
            return rateService.findUserByServiceAreaLike(serviceArea);
        } else
            return new ResponseEntity<>(new StandardResponse<>(HttpStatus.BAD_REQUEST.value(), "Enter valid service area", "service area not valid"), HttpStatus.BAD_REQUEST);
    }



}
