package com.swlc.skillmart.service;

import com.swlc.skillmart.dto.LoginDTO;
import com.swlc.skillmart.dto.LoginUserDTO;
import com.swlc.skillmart.response.ApiResponse;

public interface LoginService {
    ApiResponse signinUser(LoginDTO loginDto);

    ApiResponse loginUser(LoginUserDTO loginUserDto);
}
