package com.pos_app.pos_app.repository;

import com.pos_app.pos_app.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    Optional<User> findByUserName(String userName);
}
