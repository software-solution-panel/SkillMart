package com.swlc.skillmart.service.impl;

import com.swlc.skillmart.dto.RateDTO;
import com.swlc.skillmart.dto.UserDTO;
import com.swlc.skillmart.entity.Rate;
import com.swlc.skillmart.entity.User;
import com.swlc.skillmart.repository.RateRepository;
import com.swlc.skillmart.repository.UserRepository;
import com.swlc.skillmart.service.RateService;
import com.swlc.skillmart.service.UserService;
import com.swlc.skillmart.util.StandardResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * @author Chathumal Jayasingha | [chathumaljayasingha@hotmail.com]
 * @since - 11/1/24 | 2024-November-01[Friday]
 */

@Service
public class RateServiceImpl implements RateService {

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RateRepository rateRepository;

    @Override
    public ResponseEntity<StandardResponse<?>> addRate(RateDTO dto) {
        try {
            Integer userId = dto.getUserId();
            User byId = userRepository.findById(userId);
            if (byId == null) {
                return new ResponseEntity<>(new StandardResponse<>(HttpStatus.NOT_FOUND.value(), "User Not found","Not Found for add rate"), HttpStatus.NOT_FOUND);
            } else {
                Rate rate = new Rate();
                rate.setId(byId);
                rate.setUsername(dto.getUsername());
                rate.setContact(dto.getContact());
                rate.setComment(dto.getComment());
                rate.setActive(true);
                rate.setStars(dto.getStars());
                rateRepository.save(rate);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new StandardResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Cannot save","Internal Server Problem"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new StandardResponse<>(200, "User Rate Save Success", "OK"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<StandardResponse<?>> findAllRatesForUser(Integer userId) {
        List<RateDTO> list=null;
        try {
            User byId = userRepository.findById(userId);
            if (byId == null) {
                return new ResponseEntity<>(new StandardResponse<>(HttpStatus.NOT_FOUND.value(), "User Not found","Not Found for get all rates"), HttpStatus.NOT_FOUND);
            } else {
                List<Rate> allRatesForUser = rateRepository.findAllRatesForUser(userId);
                list = Arrays.asList(modelMapper.map(allRatesForUser, RateDTO[].class));
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new StandardResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Cannot save","Internal Server Problem"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new StandardResponse<>(200, "Success", list), HttpStatus.OK);
    }









}
