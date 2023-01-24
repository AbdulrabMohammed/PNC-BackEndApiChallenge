package com.backEndApiChallenge.application;

import com.backEndApiChallenge.controller.UserRegistrationController;
import com.backEndApiChallenge.model.User;
import com.backEndApiChallenge.service.UserRegistrationServiceImpl;
import org.json.JSONObject;


public class Main {
    public static void main(String[] args) throws Exception {

        System.out.println("Hello world!");
        User user = new User();
        UserRegistrationServiceImpl userRegistrationService =
                new UserRegistrationServiceImpl(user);
        UserRegistrationController userRegistrationController =
                new UserRegistrationController(userRegistrationService);

        user.setUsername("userName");
        user.setPassword("pwd1233AAA#$$%");

        String httpResponse = userRegistrationService.httpResponse();
        JSONObject jsonObject = new JSONObject(httpResponse);
        user.setIpAddress(jsonObject.getString("query"));

        System.out.println(userRegistrationController.verifyUser(user));
    }
}