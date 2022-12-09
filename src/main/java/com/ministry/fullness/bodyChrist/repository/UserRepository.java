package com.ministry.fullness.bodyChrist.repository;

import com.ministry.fullness.bodyChrist.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User ,Long> {
}
