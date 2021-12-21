package com.upgrad.uber.clone.services;

import com.upgrad.uber.clone.dao.UserDao;
import com.upgrad.uber.clone.entities.Users;
import com.upgrad.uber.clone.exceptions.APIException;
import com.upgrad.uber.clone.exceptions.BadCredentialsException;
import com.upgrad.uber.clone.exceptions.UserAlreadyExistsException;
import com.upgrad.uber.clone.exceptions.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserDao userDao ;

    @Override
    public Users getUser(Users user) throws APIException, UserNotFoundException, BadCredentialsException {
        Users checkUser = userDao.findByEmailIgnoreCase(user.getEmail()) ;
        if (checkUser == null){
            throw new UserNotFoundException("User Not Found") ;
        }
        Users checkUserNameAndPassword = userDao.findByEmailAndPassword(user.getEmail(),user.getPassword()) ;
        if (checkUserNameAndPassword == null){
            throw new BadCredentialsException("Unauthorized User") ;
        }


        return checkUserNameAndPassword;
    }

    @Override
    public Users createUser(Users users) throws APIException, UserAlreadyExistsException {
      Users checkEmail = userDao.findByEmailIgnoreCase(users.getEmail()) ;
      if (checkEmail != null){
          throw new UserAlreadyExistsException("Email already exist") ;
      }

      Users checkMobileNumber = userDao.findByMobileNoIgnoreCase(users.getMobileNo()) ;
      if (checkMobileNumber != null){
          throw new UserAlreadyExistsException("Mobile number already exist") ;
      }

        return userDao.save(users);
    }

    @Override
    public Users getUsersById(int id) throws APIException, UserNotFoundException {
       Users users = userDao.findById(id)
               .orElseThrow(
                       () -> new RuntimeException("No Book Found for this Id:" +id)
               ) ;
        return users;
    }
}
