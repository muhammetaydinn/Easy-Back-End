package com.example.Easy.Repository;

import com.example.Easy.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
public interface UserRepository extends JpaRepository<UserEntity, UUID> {
}
