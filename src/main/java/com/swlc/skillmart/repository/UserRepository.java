package com.swlc.skillmart.repository;

import com.swlc.skillmart.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {
    @Query(nativeQuery = true, value = "select * from User where active=1 ")
    List<User> findAllActiveUsers();

    @Query(nativeQuery = true, value = "select * from user where active=true and available=true")
    List<User> findAllActiveAvailableUsers();

    @Query(nativeQuery = true, value = "select * from user where available=true")
    List<User> findAllAvailableUsers();

    @Query(nativeQuery = true, value = "select * from user where id=:id ")
    User findById(@Param("id") Integer id);

    @Query(nativeQuery = true, value = "select * from user where service_area=:serviceArea and active=1 ")
    List<User> findAllByServiceArea(@Param("serviceArea") String serviceArea);




}
