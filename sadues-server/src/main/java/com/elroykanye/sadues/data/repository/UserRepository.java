package com.elroykanye.sadues.data.repository;

import com.elroykanye.sadues.data.entity.User;
import com.elroykanye.sadues.data.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email);

    List<User> findAllByRole(Role role);

    boolean existsByEmail(String email);
}
