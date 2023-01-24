package com.backEndApiChallenge.service;

import com.backEndApiChallenge.model.User;
import org.json.JSONObject;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.UUID;
public class UserRegistrationServiceImpl {
    private final User user;
    public UserRegistrationServiceImpl(User user1){

        this.user = user1;
    }
    private static Boolean checkValidUserName(User user) throws Exception {
        if (user.getUsername() == null){
            throw new Exception("Username cannot be empty");
        }
        else return true;
    }

    private static Boolean checkValidPassword(User user) throws Exception {
        if (user.getPassword() == null){
            throw new Exception("Password Cannot Be Empty");
        }
        if (user.getPassword().matches("(?=[A-Za-z0-9_#$% ]+$)^(?=.*[a-z])(?=.*[A-Z])(?=.*[0-9])(?=.*[_#$%])(?=.{9,}).*$")) {
            return true;
        }
        else throw new Exception("Password must contain at least 9 letters.\n " +
                "Password must contain at least 1 number, 1 capitalized letter, 1 special character in this set: _#$%");
    }


    public String httpResponse() throws IOException, InterruptedException {
        HttpClient httpClient = HttpClient.newHttpClient();// sets up a default client
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create("http://ip-api.com/json")).build(); // Makes a Get-request to Ip-API
        HttpResponse<String> stringHttpResponseResponse = httpClient.send(httpRequest,HttpResponse.BodyHandlers.ofString());
        return stringHttpResponseResponse.body();

    }
    private Boolean checkValidIpLocation() throws Exception {
        JSONObject jsonObject = new JSONObject(httpResponse());
        String country = jsonObject.getString("country");
        if (country.equals("Canada")){
            return true;
        }
        else throw new Exception("User is not eligible to register.");

    }
    public String successMessage(User user) throws Exception {
        JSONObject jsonObject = new JSONObject(httpResponse());
        if(checkValidUserName(user) && checkValidPassword(user) && checkValidIpLocation() ){
            UUID uuid = UUID.randomUUID();
            String name = user.getUsername();
            String city = jsonObject.getString("city");
            return "Welcome! Your UUID is " + uuid + ", " + name + " from " + city;
        }
        else throw new Exception();
    }
}
