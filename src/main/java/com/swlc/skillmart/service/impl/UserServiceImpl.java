package com.swlc.skillmart.service.impl;

import com.swlc.skillmart.dto.UserDTO;
import com.swlc.skillmart.entity.User;
import com.swlc.skillmart.repository.UserRepository;
import com.swlc.skillmart.service.UserService;
import com.swlc.skillmart.util.StandardResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

/**
 * @author Chathumal Jayasingha | [chathumaljayasingha@hotmail.com]
 * @since - 11/1/24 | 2024-November-01[Friday]
 */

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Override
    public ResponseEntity<StandardResponse<?>> addUser(UserDTO dto) {
        try {
            User map = modelMapper.map(dto, User.class);
            userRepository.save(map);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new StandardResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Cannot save","Internal Server Problem"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new StandardResponse<>(200, "Save success", "OK"), HttpStatus.OK);
    }
}
