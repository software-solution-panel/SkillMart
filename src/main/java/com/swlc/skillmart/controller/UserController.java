package com.swlc.skillmart.controller;

import com.swlc.skillmart.dto.UserDTO;
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
@RequestMapping("api/v1")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/adduser")
    private ResponseEntity<StandardResponse<?>> addUser(@RequestBody UserDTO dto) {
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

    @GetMapping("/findAllAvailableUsers")
    private ResponseEntity<StandardResponse<?>> findAllAvailableUsers() {
        return userService.findAllAvailableUsers();
    }

    @GetMapping("/findById")
    private ResponseEntity<StandardResponse<?>> findById(@RequestParam Integer id) {
        if (id != null){
            return userService.findById(id);
        } else return new ResponseEntity<>(new StandardResponse<>(HttpStatus.BAD_REQUEST.value(), "Enter valid user id", "User id not valid"), HttpStatus.BAD_REQUEST);
    }






}
