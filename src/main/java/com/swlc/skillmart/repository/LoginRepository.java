package com.swlc.skillmart.repository;

import com.swlc.skillmart.entity.Login;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@EnableJpaRepositories
@Repository
public interface LoginRepository extends JpaRepository<Login, Integer> {
    Optional<Login> findByEmailAndPassword(String email, String password);

    Login findByEmail(String email);
}
