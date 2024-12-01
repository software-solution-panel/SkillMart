package com.swlc.skillmart.service.impl;

import com.swlc.skillmart.dto.ServiceAreaDTO;
import com.swlc.skillmart.dto.ServiceTypeDTO;
import com.swlc.skillmart.entity.ServiceArea;
import com.swlc.skillmart.entity.ServiceType;
import com.swlc.skillmart.repository.ServiceTypeRepository;
import com.swlc.skillmart.service.ServiceTypeService;
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
public class ServiceTypeServiceImpl implements ServiceTypeService {

    @Autowired
    private ServiceTypeRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public ResponseEntity<StandardResponse<?>> getAllServiceTypes() {
        List<ServiceTypeDTO> serviceTypeDTOList=null;
        try {
            List<ServiceType> all = repository.findAll();
            serviceTypeDTOList = Arrays.asList(modelMapper.map(all, ServiceTypeDTO[].class));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new StandardResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Cannot Get All Service Types","Internal Server Problem"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new StandardResponse<>(200, "Get success", serviceTypeDTOList), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<StandardResponse<?>> addServiceType(String serviceType) {
        try {
            if (serviceType != null) {
                ServiceType entity = new ServiceType();
                entity.setType(serviceType);
                repository.save(entity);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new StandardResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Cannot save","Internal Server Problem"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new StandardResponse<>(200, "Service Type Save Success", "OK"), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<StandardResponse<?>> updateServiceType(ServiceTypeDTO serviceTypeDTO) {
        try {
            if (serviceTypeDTO.getTypeId() != null) {
                Optional<ServiceType> byId = repository.findById(serviceTypeDTO.getTypeId());
                if (byId.isPresent()){
                    ServiceType serviceType = byId.get();
                    serviceType.setType(serviceTypeDTO.getType());
                    repository.save(serviceType);
                } else {
                    return new ResponseEntity<>(new StandardResponse<>(HttpStatus.NOT_FOUND.value(), "Cannot find to update","Not Found"), HttpStatus.NOT_FOUND);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new StandardResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Cannot update","Internal Server Problem"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new StandardResponse<>(200, "Service Type update Success", "OK"), HttpStatus.OK);

    }

    @Override
    public ResponseEntity<StandardResponse<?>> removeServiceTypeById(Integer id) {
        try {
            if (id != null) {
                Optional<ServiceType> byId = repository.findById(id);
                if (byId.isPresent()){
                    ServiceType serviceType = byId.get();
                    repository.deleteById(serviceType.getTypeId());
                } else {
                    return new ResponseEntity<>(new StandardResponse<>(HttpStatus.NOT_FOUND.value(), "Cannot find to delete","Not Found"), HttpStatus.NOT_FOUND);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(new StandardResponse<>(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Cannot delete","Internal Server Problem"), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>(new StandardResponse<>(200, "Service Type delete Success", "OK"), HttpStatus.OK);

    }
}
