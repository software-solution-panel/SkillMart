package com.swlc.skillmart.service;

import com.swlc.skillmart.dto.ServiceAreaDTO;
import com.swlc.skillmart.util.StandardResponse;
import org.springframework.http.ResponseEntity;

public interface ServiceAreaService {
    ResponseEntity<StandardResponse<?>> getAllServiceArea();
    ResponseEntity<StandardResponse<?>> addServiceArea(String serviceArea);
    ResponseEntity<StandardResponse<?>> updateServiceArea(ServiceAreaDTO areaDTO);
}
