package com.swlc.skillmart.service;

import com.swlc.skillmart.dto.UserDTO;
import com.swlc.skillmart.util.StandardResponse;
import org.springframework.http.ResponseEntity;

/**
 * @author Chathumal Jayasingha | [chathumaljayasingha@hotmail.com]
 * @since - 11/1/24 | 2024-November-01[Friday]
 */
public interface UserService {
    ResponseEntity<StandardResponse<?>> addUser(UserDTO dto);
    ResponseEntity<StandardResponse<?>> findAllActiveUsers();
    ResponseEntity<StandardResponse<?>> findAllUsers();
    ResponseEntity<StandardResponse<?>> findAllActiveAvailableUsers();
    ResponseEntity<StandardResponse<?>> findAllAvailableUsers();
}
