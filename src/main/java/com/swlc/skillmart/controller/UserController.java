package com.swlc.skillmart.controller;

import com.swlc.skillmart.dto.UserDTO;
import com.swlc.skillmart.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Chathumal Jayasingha | [chathumaljayasingha@hotmail.com]
 * @since - 11/1/24 | 2024-November-01[Friday]
 */

@RestController
@CrossOrigin
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    private String test(){
        UserDTO userDTO = new UserDTO();
        userDTO.setFirstName("Chathumal");
        userDTO.setLastName("Jayasinghe");
        userDTO.setAddress("Horana");
        Boolean b = userService.addUser(userDTO);
        return b.toString();
    }
}
