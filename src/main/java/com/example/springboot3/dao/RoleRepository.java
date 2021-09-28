package com.example.springboot3.dao;

import com.example.springboot3.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {
    Role findByRole(String role);
    Role findByName(String name);
    @Query("from Role")
    List<Role> findAllByRole();

}
