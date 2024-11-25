package com.swlc.skillmart.service.impl;

import com.swlc.skillmart.dto.ServiceAreaDTO;
import com.swlc.skillmart.dto.UserDTO;
import com.swlc.skillmart.entity.Rate;
import com.swlc.skillmart.entity.ServiceArea;
import com.swlc.skillmart.entity.User;
import com.swlc.skillmart.repository.ServiceAreaRepository;
import com.swlc.skillmart.service.ServiceAreaService;
import com.swlc.skillmart.util.StandardResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service
@Transactional
public class ServiceAreaServiceImpl implements ServiceAreaService {


    @Autowired
    private ServiceAreaRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<StandardResponse<?>> getAllServiceArea() {
        List<ServiceAreaDTO> serviceAreaDTOList=null;
        try {
            List<ServiceArea> all = repository.findAll();
            serviceAreaDTOList = Arrays.asList(modelMapper.map(all, ServiceAreaDTO[].class));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new StandardResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Cannot Get All Service Areas","Internal Server Problem"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new StandardResponse<>(200, "Get success", serviceAreaDTOList), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<StandardResponse<?>> addServiceArea(String serviceArea) {
        try {
            if (serviceArea == null) {
                ServiceArea entity = new ServiceArea();
                entity.setAreaName(serviceArea);
                repository.save(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new StandardResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Cannot save","Internal Server Problem"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new StandardResponse<>(200, "Service Area Save Success", "OK"), HttpStatus.OK);
    }


}
