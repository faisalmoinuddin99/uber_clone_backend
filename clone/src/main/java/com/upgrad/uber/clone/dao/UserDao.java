package com.upgrad.uber.clone.dao;


import com.upgrad.uber.clone.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserDao extends JpaRepository<Users, Integer> {
    public List<Users> findByFirstNameIgnoreCase(String firstName);
    public List<Users> findByFirstNameIgnoreCaseOrLastNameIgnoreCase(String firstName, String lastName);
    public Users findByMobileNoIgnoreCase(String mobileNo);
    public Users findByEmailIgnoreCase(String email);
    public Users findByEmailAndPassword(String email, String password);
}
