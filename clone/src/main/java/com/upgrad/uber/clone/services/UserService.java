package com.upgrad.uber.clone.services ;

import com.upgrad.uber.clone.entities.User;
import com.upgrad.uber.clone.exceptions.APIException;
import com.upgrad.uber.clone.exceptions.BadCredentialsException;
import com.upgrad.uber.clone.exceptions.UserAlreadyExistsException;
import com.upgrad.uber.clone.exceptions.UserNotFoundException;

public interface UserService {
    User getUser(User user) throws APIException, UserNotFoundException, BadCredentialsException;
    User createUser(User user) throws APIException, UserAlreadyExistsException;
}
