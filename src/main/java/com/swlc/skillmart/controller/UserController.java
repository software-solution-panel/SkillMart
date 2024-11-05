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
    private ResponseEntity<StandardResponse<?>> addUser(@RequestBody UserDTO dto){
        return userService.addUser(dto);
    }







}
