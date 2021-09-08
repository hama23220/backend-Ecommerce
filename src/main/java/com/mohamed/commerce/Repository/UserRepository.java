package com.mohamed.commerce.Repository;

import com.mohamed.commerce.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Override
    Optional<User> findById(Integer integer);

    Optional<User> findUserByEmail(String email);
}
