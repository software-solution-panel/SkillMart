package com.swlc.skillmart.service.impl;

import com.swlc.skillmart.dto.UserDTO;
import com.swlc.skillmart.entity.User;
import com.swlc.skillmart.repository.CustomRepository;
import com.swlc.skillmart.repository.UserRepository;
import com.swlc.skillmart.service.UserService;
import com.swlc.skillmart.util.StandardResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

/**
 * @author Chathumal Jayasingha | [chathumaljayasingha@hotmail.com]
 * @since - 11/1/24 | 2024-November-01[Friday]
 */

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomRepository customRepository;

    @Override
    public ResponseEntity<StandardResponse<?>> addUser(UserDTO dto) {
        try {
            boolean b = userRepository.existsByMobile(dto.getMobile());
            if (b) {
                return new ResponseEntity<>(new StandardResponse<>(HttpStatus.BAD_REQUEST.value(), "mobile is already exist", "Enter valid mobile"), HttpStatus.BAD_REQUEST);
            }
            User map = modelMapper.map(dto, User.class);
            map.setActive(true);
            userRepository.save(map);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new StandardResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Cannot save","Internal Server Problem"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new StandardResponse<>(200, "Save success", "OK"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<StandardResponse<?>> findAllActiveUsers() {
        List<UserDTO> userDTOList=null;
        try {
            List<User> allByActive = userRepository.findAllActiveUsers();
            userDTOList = Arrays.asList(modelMapper.map(allByActive, UserDTO[].class));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new StandardResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Cannot Get All Active Users","Internal Server Problem"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new StandardResponse<>(200, "Get success", userDTOList), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<StandardResponse<?>> findAllUsers() {
        List<UserDTO> userDTOList=null;
        try {
            List<User> allByActive = userRepository.findAll();
            userDTOList = Arrays.asList(modelMapper.map(allByActive, UserDTO[].class));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new StandardResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Cannot Get All Active and Inactive Users","Internal Server Problem"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new StandardResponse<>(200, "Get success", userDTOList), HttpStatus.OK);
    }



    @Override
    public ResponseEntity<StandardResponse<?>> findAllActiveAvailableUsers() {
        List<UserDTO> userDTOList=null;
        try {
            List<User> allByActive = userRepository.findAllActiveAvailableUsers();
            userDTOList = Arrays.asList(modelMapper.map(allByActive, UserDTO[].class));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new StandardResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Cannot Get All Active and available Users","Internal Server Problem"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new StandardResponse<>(200, "Get success", userDTOList), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<StandardResponse<?>> findAllActiveLikeByFirstNameOrLastName(String name) {
        List<UserDTO> userDTOList=null;
        try {
            List<User> allByActive = userRepository.findAllActiveLikeByFirstNameOrLastName(name);
            userDTOList = Arrays.asList(modelMapper.map(allByActive, UserDTO[].class));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new StandardResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Cannot Get All Active ","Internal Server Problem"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new StandardResponse<>(200, "Get success", userDTOList), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<StandardResponse<?>> findAllAvailableUsers() {
        List<UserDTO> userDTOList=null;
        try {
            List<User> allByActive = userRepository.findAllAvailableUsers();
            userDTOList = Arrays.asList(modelMapper.map(allByActive, UserDTO[].class));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new StandardResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Cannot Get available Users","Internal Server Problem"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new StandardResponse<>(200, "Get success", userDTOList), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<StandardResponse<?>> findAllByServiceArea(String serviceArea) {
        List<UserDTO> userDTOList=null;
        try {
            List<User> allByServiceArea = userRepository.findAllByServiceArea(serviceArea);
            userDTOList = Arrays.asList(modelMapper.map(allByServiceArea, UserDTO[].class));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new StandardResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Cannot Get Users by service area","Internal Server Problem"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new StandardResponse<>(200, "Get success", userDTOList), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<StandardResponse<?>> findAllByOtherServiceType() {
        try {
            int allByOtherServiceType = customRepository.findAllByOtherServiceType();
            return new ResponseEntity<>(new StandardResponse<>(200, "Get success", allByOtherServiceType), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new StandardResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Cannot Get Users by service area","Internal Server Problem"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @Override
    public ResponseEntity<StandardResponse<?>> findAllByServiceType(String serviceType) {
        List<UserDTO> userDTOList=null;
        try {
            List<User> allByServiceType = userRepository.findAllByServiceType(serviceType);
            userDTOList = Arrays.asList(modelMapper.map(allByServiceType, UserDTO[].class));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new StandardResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Cannot Get Users by service type","Internal Server Problem"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new StandardResponse<>(200, "Get success", userDTOList), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<StandardResponse<?>> findById(Integer id) {
        UserDTO userDTO=null;
        try {
            User byId = userRepository.findById(id);
            if (byId == null) {
                return new ResponseEntity<>(new StandardResponse<>(HttpStatus.NOT_FOUND.value(), "User Not found","Not Found"), HttpStatus.NOT_FOUND);
            } else {
                userDTO = modelMapper.map(byId, UserDTO.class);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new StandardResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Cannot find user by id","Internal Server Problem"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new StandardResponse<>(200, "User founded", userDTO), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<StandardResponse<?>> alterUserById(UserDTO dto,Integer id) {
        User byId = null;
        try {
             byId=userRepository.findById(id);
            if (byId == null) {
                return new ResponseEntity<>(new StandardResponse<>(HttpStatus.NOT_FOUND.value(), "User Not found for update","Not Found"), HttpStatus.NOT_FOUND);
            } else {
                byId.setFirstName(dto.getFirstName());
                byId.setLastName(dto.getLastName());
                byId.setAddress(dto.getAddress());
                byId.setMobile(dto.getMobile());
                byId.setAvailable(dto.getAvailable());
                byId.setActive(true);
                byId.setServiceArea(dto.getServiceArea());
                byId.setServiceType(dto.getServiceType());
                byId.setQualification(dto.getQualification());
                byId.setLinks(dto.getLinks());
                userRepository.save(byId);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new StandardResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Cannot find user by id","Internal Server Problem"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new StandardResponse<>(200, "Update success", byId), HttpStatus.OK);
    }



    @Override
    public ResponseEntity<StandardResponse<?>> removeUserById(Integer id) {
        User byId = null;
        try {
            byId=userRepository.findById(id);
            if (byId == null) {
                return new ResponseEntity<>(new StandardResponse<>(HttpStatus.NOT_FOUND.value(), "User Not found for remove user process","Not Found"), HttpStatus.NOT_FOUND);
            } else {
                User user = userRepository.save(byId);
                user.setActive(false);
                userRepository.save(user);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new StandardResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Cannot find user by id in remove user","Internal Server Problem"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new StandardResponse<>(200, "User remove success", byId), HttpStatus.OK);
    }
}
