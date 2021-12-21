package com.upgrad.uber.clone.dao;

import com.upgrad.uber.clone.entities.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List ;
import java.util.Optional;

public interface UsersDao extends JpaRepository<Users, Integer> {
    public List<Users> findByFirstNameIgnoreCase(String firstName);

    public List<Users> findByFirstNameOrLastNameIgnoreCase(String firstName, String lastName);

    public Optional<Users> findByEmailIgnoreCase(String email);

    public Optional<Users> findByMobileNo(String mobileNo);

    Optional<Users> findByEmailAndPassword(String email, String password);
}
