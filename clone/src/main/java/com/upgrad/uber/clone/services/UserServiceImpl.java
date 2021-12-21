package com.upgrad.uber.clone.services;

import com.upgrad.uber.clone.dao.UserDao;
import com.upgrad.uber.clone.entities.Users;
import com.upgrad.uber.clone.exceptions.APIException;
import com.upgrad.uber.clone.exceptions.BadCredentialsException;
import com.upgrad.uber.clone.exceptions.UserAlreadyExistsException;
import com.upgrad.uber.clone.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;

public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao ;

    @Override
    public Users getUser(Users user) throws APIException, UserNotFoundException, BadCredentialsException {
        return null;
    }

    @Override
    public Users createUser(Users users) throws APIException, UserAlreadyExistsException {
      Users checkEmail = userDao.findByEmailIgnoreCase(users.getEmail()) ;
      if (checkEmail != null)
          throw new UserAlreadyExistsException("Email already exist") ;

      Users checkMobileNumber = userDao.findByMobileNoIgnoreCase(users.getMobileNo()) ;
      if (checkMobileNumber != null)
          throw new UserAlreadyExistsException("Mobile number already exist") ;

        return userDao.save(users);
    }
}
