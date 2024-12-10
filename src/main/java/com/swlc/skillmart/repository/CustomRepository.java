package com.swlc.skillmart.repository;

import com.swlc.skillmart.dto.UserWithStarCountDTO;
import com.swlc.skillmart.entity.User;

import java.util.List;

public interface CustomRepository {
    public List<UserWithStarCountDTO> findUserOrderByRateStarCount();
    public int findAllByOtherServiceType();
    public List<UserWithStarCountDTO> findUserByServiceAreaLike(String serviceArea);
}
