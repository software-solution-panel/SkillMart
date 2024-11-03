package com.swlc.skillmart.repository;

import com.swlc.skillmart.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
