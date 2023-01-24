package com.backEndApiChallenge.controller;

import com.backEndApiChallenge.model.User;
import com.backEndApiChallenge.service.UserRegistrationServiceImpl;
import org.json.JSONObject;
import java.util.Scanner;

public class UserRegistrationController {
    private final UserRegistrationServiceImpl userRegistrationServiceImpl;


    public UserRegistrationController(UserRegistrationServiceImpl userRegistrationServiceImpl1) {
        this.userRegistrationServiceImpl = userRegistrationServiceImpl1;
    }

    public String verifyUser(User user) throws Exception {
        return userRegistrationServiceImpl.successMessage(user);
    }
}
