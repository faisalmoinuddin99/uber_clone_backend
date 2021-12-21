package com.upgrad.uber.clone.services;

import com.upgrad.uber.clone.entities.Users;
import com.upgrad.uber.clone.exceptions.APIException;
import com.upgrad.uber.clone.exceptions.BadCredentialsException;
import com.upgrad.uber.clone.exceptions.UserAlreadyExistsException;
import com.upgrad.uber.clone.exceptions.UserNotFoundException;

public interface UserService {
    public  Users getUser(Users user) throws APIException, UserNotFoundException, BadCredentialsException;
    public Users createUser(Users users) throws APIException, UserAlreadyExistsException;
    public Users getUsersById(int id) throws APIException, UserNotFoundException ;
}
