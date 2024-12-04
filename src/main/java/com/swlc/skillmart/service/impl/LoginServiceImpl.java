package com.swlc.skillmart.service.impl;

import com.swlc.skillmart.dto.LoginDTO;
import com.swlc.skillmart.dto.LoginUserDTO;
import com.swlc.skillmart.entity.Login;
import com.swlc.skillmart.repository.LoginRepository;
import com.swlc.skillmart.response.ApiResponse;
import com.swlc.skillmart.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    private LoginRepository loginRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public ApiResponse signinUser(LoginDTO loginDto) {
        try {
            Login email = loginRepository.findByEmail(loginDto.getEmail());
            if (email != null) {
                return new ApiResponse("Email is already registered!", false);
            } else {
                Login login = new Login();
                login.setName(loginDto.getName());
                login.setEmail(loginDto.getEmail());
                login.setPassword(passwordEncoder.encode(loginDto.getPassword()));
                loginRepository.save(login);

                return new ApiResponse("User create successfully.", true);
            }
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            throw new RuntimeException("An unexpected error occurred while creating user login.", e);
        }
    }

    @Override
    public ApiResponse loginUser(LoginUserDTO loginUserDto) {
        Login email = loginRepository.findByEmail(loginUserDto.getEmail());

        if (email != null) {
            String password = loginUserDto.getPassword();
            String encodedPassword = email.getPassword();

            boolean isMatch = passwordEncoder.matches(password, encodedPassword);

            if (isMatch) {
                Optional<Login> employee = loginRepository.findByEmailAndPassword(loginUserDto.getEmail(), encodedPassword);
                if (employee.isPresent()) {
                    return new ApiResponse("Login Success", true);
                } else {
                    return new ApiResponse("Login Failed", false);
                }
            } else  {
                return new ApiResponse("Password not match", false);
            }

        } else {
            return new ApiResponse("Email not exist", false);
        }
    }
}
