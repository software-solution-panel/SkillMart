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
import java.util.Optional;

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
            if (serviceArea != null) {
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

    @Override
    public ResponseEntity<StandardResponse<?>> updateServiceArea(ServiceAreaDTO areaDTO) {
        try {
            if (areaDTO.getAreaId() != null) {
                Optional<ServiceArea> byId = repository.findById(Long.valueOf(areaDTO.getAreaId()));
                if (byId.isPresent()){
                    ServiceArea serviceArea = byId.get();
                    serviceArea.setAreaName(areaDTO.getAreaName());
                    repository.save(serviceArea);
                } else {
                    return new ResponseEntity<>(new StandardResponse<>(HttpStatus.NOT_FOUND.value(), "Cannot find to update","Not Found"), HttpStatus.NOT_FOUND);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new StandardResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Cannot update","Internal Server Problem"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new StandardResponse<>(200, "Service Area update Success", "OK"), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<StandardResponse<?>> removeServiceAreaById(Integer areaId) {
        try {
            if (areaId != null) {
                Optional<ServiceArea> byId = repository.findById(Long.valueOf(areaId));
                if (byId.isPresent()){
                    ServiceArea serviceArea = byId.get();
                    repository.deleteById(Long.valueOf(serviceArea.getAreaId()));
                } else {
                    return new ResponseEntity<>(new StandardResponse<>(HttpStatus.NOT_FOUND.value(), "Cannot find to delete","Not Found"), HttpStatus.NOT_FOUND);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new StandardResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Cannot delete","Internal Server Problem"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new StandardResponse<>(200, "Service Area delete Success", "OK"), HttpStatus.OK);
    }

}
