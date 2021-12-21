package com.upgrad.uber.clone.dao ;


import com.upgrad.uber.clone.entities.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleDao extends JpaRepository<Role, Integer> {
}
