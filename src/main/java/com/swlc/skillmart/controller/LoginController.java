package com.swlc.skillmart.controller;

import com.swlc.skillmart.dto.LoginDTO;
import com.swlc.skillmart.dto.LoginUserDTO;
import com.swlc.skillmart.response.ApiResponse;
import com.swlc.skillmart.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping("api/v1/auth")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping(path = "/signin")
    public ApiResponse saveEmployee(@RequestBody LoginDTO loginDto) {
        return loginService.signinUser(loginDto);
    }

    @PostMapping(path = "/login")
    public ApiResponse loginEmployee(@RequestBody LoginUserDTO loginUserDto) {
        return loginService.loginUser(loginUserDto);
    }
}
