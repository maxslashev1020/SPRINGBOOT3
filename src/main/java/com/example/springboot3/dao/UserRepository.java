package com.example.springboot3.dao;

import com.example.springboot3.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserName(String username);
    User findById(long id);
    @Query("from User")
    List<User> findAllBy();
}
