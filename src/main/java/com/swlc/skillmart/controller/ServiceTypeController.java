package com.swlc.skillmart.controller;

import com.swlc.skillmart.dto.ServiceTypeDTO;
import com.swlc.skillmart.service.ServiceTypeService;
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
@RequestMapping("api/v1/serviceType")
public class ServiceTypeController {

    @Autowired
    private ServiceTypeService typeService;

    @GetMapping("/findAllServiceType")
    public ResponseEntity<StandardResponse<?>> findAllServiceArea() {
        return typeService.getAllServiceTypes();
    }

    @PostMapping("/addServiceType")
    public ResponseEntity<StandardResponse<?>> addServiceArea(@RequestParam String serviceType) {
        return typeService.addServiceType(serviceType);
    }

    @PutMapping("/updateServiceType")
    public ResponseEntity<StandardResponse<?>> updateServiceArea(@RequestBody ServiceTypeDTO serviceTypeDTO) {
        return typeService.updateServiceType(serviceTypeDTO);
    }

    @DeleteMapping("/removeServiceTypeById")
    private ResponseEntity<StandardResponse<?>> removeUserById(@RequestParam Integer id) {
        if (id != null) {
            return typeService.removeServiceTypeById(id);
        } else
            return new ResponseEntity<>(new StandardResponse<>(HttpStatus.BAD_REQUEST.value(), "Enter valid service type id", "service type id not valid"), HttpStatus.BAD_REQUEST);
    }


}
