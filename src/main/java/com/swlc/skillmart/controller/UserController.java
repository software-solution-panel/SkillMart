package com.swlc.skillmart.controller;

import com.swlc.skillmart.dto.UserDTO;
import com.swlc.skillmart.service.UserService;
import com.swlc.skillmart.util.MobileNumberValidator;
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
@RequestMapping("api/v1/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/adduser")
    private ResponseEntity<StandardResponse<?>> addUser(@RequestBody UserDTO dto) {
        if (!MobileNumberValidator.isValidMobileNumber(dto.getMobile())) {
            return new ResponseEntity<>(new StandardResponse<>(HttpStatus.BAD_REQUEST.value(), "Enter valid mobile number", "mobile validation problem"), HttpStatus.BAD_REQUEST);
        }
        return userService.addUser(dto);
    }

    @GetMapping("/findAllActiveUsers")
    private ResponseEntity<StandardResponse<?>> findAllActiveUsers() {
        return userService.findAllActiveUsers();
    }

    @GetMapping("/findAllUsers")
    private ResponseEntity<StandardResponse<?>> findAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/findAllActiveAvailableUsers")
    private ResponseEntity<StandardResponse<?>> findAllActiveAvailableUsers() {
        return userService.findAllActiveAvailableUsers();
    }
    @GetMapping("/findAllActiveLikeByFirstNameOrLastName")
    private ResponseEntity<StandardResponse<?>> findAllActiveLikeByFirstNameOrLastName(@RequestParam String name) {
        return userService.findAllActiveLikeByFirstNameOrLastName(name);
    }

    @GetMapping("/findAllAvailableUsers")
    private ResponseEntity<StandardResponse<?>> findAllAvailableUsers() {
        return userService.findAllAvailableUsers();
    }
    @GetMapping("/findAllByServiceArea")
    private ResponseEntity<StandardResponse<?>> findAllByServiceArea(@RequestParam String serviceArea) {
        if (serviceArea != null){
            return userService.findAllByServiceArea(serviceArea);
        } else return new ResponseEntity<>(new StandardResponse<>(HttpStatus.BAD_REQUEST.value(), "Enter valid service area", "service area not valid"), HttpStatus.BAD_REQUEST);
    }

    @GetMapping("/findAllByServiceType")
    private ResponseEntity<StandardResponse<?>> findAllByServiceType(@RequestParam String serviceType) {
        if (serviceType != null){
            return userService.findAllByServiceType(serviceType);
        } else return new ResponseEntity<>(new StandardResponse<>(HttpStatus.BAD_REQUEST.value(), "Enter valid service type", "service type not valid"), HttpStatus.BAD_REQUEST);
    }


    @GetMapping("/findById")
    private ResponseEntity<StandardResponse<?>> findById(@RequestParam Integer id) {
        if (id != null){
            return userService.findById(id);
        } else return new ResponseEntity<>(new StandardResponse<>(HttpStatus.BAD_REQUEST.value(), "Enter valid user id", "User id not valid"), HttpStatus.BAD_REQUEST);
    }


    @PutMapping("/alterUserById")
    private ResponseEntity<StandardResponse<?>> alterUserById(@RequestParam Integer id,@RequestBody UserDTO dto) {
        if (id != null){
            return userService.alterUserById(dto,id);
        } else return new ResponseEntity<>(new StandardResponse<>(HttpStatus.BAD_REQUEST.value(), "Enter valid user id", "User id not valid"), HttpStatus.BAD_REQUEST);
    }

    @DeleteMapping("/removeUserById")
    private ResponseEntity<StandardResponse<?>> removeUserById(@RequestParam Integer id) {
        if (id != null){
            return userService.removeUserById(id);
        } else return new ResponseEntity<>(new StandardResponse<>(HttpStatus.BAD_REQUEST.value(), "Enter valid user id", "User id not valid"), HttpStatus.BAD_REQUEST);
    }




}
