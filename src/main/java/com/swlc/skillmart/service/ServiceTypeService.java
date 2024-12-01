package com.swlc.skillmart.service;

import com.swlc.skillmart.dto.ServiceAreaDTO;
import com.swlc.skillmart.dto.ServiceTypeDTO;
import com.swlc.skillmart.util.StandardResponse;
import org.springframework.http.ResponseEntity;

public interface ServiceTypeService {
    ResponseEntity<StandardResponse<?>> getAllServiceTypes();
    ResponseEntity<StandardResponse<?>> addServiceType(String serviceType);
    ResponseEntity<StandardResponse<?>> updateServiceType(ServiceTypeDTO serviceTypeDTO);
    ResponseEntity<StandardResponse<?>> removeServiceTypeById(Integer id);
}
