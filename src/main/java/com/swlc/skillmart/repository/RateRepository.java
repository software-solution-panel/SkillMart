package com.swlc.skillmart.repository;

import com.swlc.skillmart.dto.UserWithStarCountDTO;
import com.swlc.skillmart.entity.Rate;
import com.swlc.skillmart.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RateRepository extends JpaRepository<Rate, Integer> {

    @Query(nativeQuery = true, value = "select * from rate where user_id=:userId and active=1 ")
    List<Rate> findAllRatesForUser(@Param("userId") Integer userId);

    @Query(nativeQuery = true, value = "select sum(r.stars) stars,u.* from rate r inner join user u on u.id=r.user_id " +
            "and u.active='1' and r.active='1' group by r.user_id order by stars desc")
    List<UserWithStarCountDTO> findUserOrderByRateStarCount();

}
