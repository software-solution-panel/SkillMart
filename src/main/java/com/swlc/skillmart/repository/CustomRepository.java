package com.swlc.skillmart.repository;

import com.swlc.skillmart.dto.UserWithStarCountDTO;

import java.util.List;

public interface CustomRepository {
    public List<UserWithStarCountDTO> findUserOrderByRateStarCount();
    public List<UserWithStarCountDTO> findUserByServiceAreaLike(String serviceArea);
}
