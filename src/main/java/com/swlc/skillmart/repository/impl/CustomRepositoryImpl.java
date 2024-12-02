package com.swlc.skillmart.repository.impl;

import com.swlc.skillmart.dto.UserWithStarCountDTO;
import com.swlc.skillmart.repository.CustomRepository;
import com.swlc.skillmart.repository.rowmapper.UserWithStarCountRowMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CustomRepositoryImpl implements CustomRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public List<UserWithStarCountDTO> findUserOrderByRateStarCount(){
        return jdbcTemplate.query("select sum(r.stars) stars,u.* from rate r right outer join user u on u.id=r.user_id and u.active='1' and r.active='1' group by u.id order by stars desc", new UserWithStarCountRowMapper());
    }

    @Override
    public List<UserWithStarCountDTO> findUserByServiceAreaLike(String serviceArea) {
        return jdbcTemplate.query("select sum(r.stars) stars,u.* from rate r right outer join user u on u.id=r.user_id and u.active='1' and r.active='1' and u.service_area like '%"+serviceArea.trim()+"%' group by u.id order by stars desc", new UserWithStarCountRowMapper());
    }

}
