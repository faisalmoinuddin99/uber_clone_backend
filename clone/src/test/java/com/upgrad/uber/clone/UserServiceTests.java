package com.upgrad.uber.clone;

import com.upgrad.uber.clone.dao.RoleDao;
import com.upgrad.uber.clone.dao.UserDao;
import com.upgrad.uber.clone.entities.Role;
import com.upgrad.uber.clone.entities.Users;
import com.upgrad.uber.clone.services.UserServiceImpl;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ContextConfiguration;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
@ContextConfiguration(locations = {"classpath:mtbBeans.xml"})
public class UserServiceTests {

    @InjectMocks
    UserServiceImpl userService ;

    @Mock
    UserDao userDao ;

    @Mock
    static
    RoleDao roleDao ;

    public  static  Users users ;
    public static Role role ;
    @BeforeClass
    public static void setUpTestEnv() throws ParseException {
        users = new Users("faisal","suleman","user@123","faisal@gmail.com",
                "9999999999", 60000);
    }
    @Before
    public void setUpTestMock() {
        when(userDao.save(users)).thenReturn(users);
        when(userDao.findById(1)).thenReturn(java.util.Optional.ofNullable(users));

        Users users1 = new Users("rahul","dua","rahul@123","rahul@gmail.com",
                "88888888888", 60000);


        when(userDao.findAll()).thenReturn(new ArrayList<>(Arrays.asList(users, users1)));
    }

    @Test
    public void testCreateUser() throws ParseException {
        Assert.assertEquals(users, userService.createUser(users));
    }
}
