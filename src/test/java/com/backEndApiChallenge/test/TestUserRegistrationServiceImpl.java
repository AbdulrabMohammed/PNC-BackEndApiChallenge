package com.backEndApiChallenge.test;
import com.backEndApiChallenge.model.User;
import com.backEndApiChallenge.service.UserRegistrationServiceImpl;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;


public class TestUserRegistrationServiceImpl {
    @Test
    public void testSuccessMessage_validInput_returnsSuccessMessage() throws Exception {
        User user = new User();
        user.setUsername("null");
        user.setPassword("Password1#");
        user.setIpAddress("100.42.23.255");
        UserRegistrationServiceImpl service = new UserRegistrationServiceImpl(user);
        String expected = "Welcome! Your UUID is " + UUID.randomUUID() + ", " + "username" + " from " + "someCity";
        String actual = service.successMessage(user);
        assertEquals(expected, actual);
    }

    @Test(expected = Exception.class)
    public void testSuccessMessage_invalidUsername_throwsException() throws Exception {
        User user = new User();
        user.setUsername(null);
        user.setPassword("Password1#");
        UserRegistrationServiceImpl service = new UserRegistrationServiceImpl(user);
        service.successMessage(user);
    }

    @Test(expected = Exception.class)
    public void testSuccessMessage_invalidPassword_throwsException() throws Exception {
        User user = new User();
        user.setUsername(null);
        user.setPassword("Password");
        UserRegistrationServiceImpl service = new UserRegistrationServiceImpl(user);
        service.successMessage(user);
    }

    @Test(expected = Exception.class)
    public void testSuccessMessage_invalidIpLocation_throwsException() throws Exception {
        User user = new User();
        user.setUsername(null);
        user.setPassword("Password1#");
        UserRegistrationServiceImpl service = new UserRegistrationServiceImpl(user);
        service.successMessage(user);
    }
}
