package com.swlc.skillmart.controller;

import com.swlc.skillmart.dto.RateDTO;
import com.swlc.skillmart.dto.ServiceAreaDTO;
import com.swlc.skillmart.service.RateService;
import com.swlc.skillmart.service.ServiceAreaService;
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
@RequestMapping("api/v1/serviceArea")
public class ServiceAreaController {

    @Autowired
    private ServiceAreaService serviceAreaService;

    @GetMapping("/findAllServiceArea")
    public ResponseEntity<StandardResponse<?>> findAllServiceArea() {
        return serviceAreaService.getAllServiceArea();
    }

    @PostMapping("/addServiceArea")
    public ResponseEntity<StandardResponse<?>> addServiceArea(@RequestParam String serviceArea) {
        return serviceAreaService.addServiceArea(serviceArea);
    }

    @PutMapping("/updateServiceArea")
    public ResponseEntity<StandardResponse<?>> updateServiceArea(@RequestBody ServiceAreaDTO serviceAreaDTO) {
        return serviceAreaService.updateServiceArea(serviceAreaDTO);
    }




}
