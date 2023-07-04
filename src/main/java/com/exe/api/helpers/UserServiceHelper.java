package com.exe.api.helpers;

import com.exe.api.constants.EndPoints;
//import com.exe.api.model.Account;
import com.exe.api.model.Account_1;
import com.exe.api.utils.ConfigManager;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.jetbrains.annotations.NotNull;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.ITestContext;

import java.io.IOException;
import java.util.Random;

import static io.restassured.RestAssured.*;
public class UserServiceHelper {
    protected static final String BASE_URL;
    protected static String generatedString;
   /* boolean isValidURL(String BASE_URL) throws MalformedURLException {
        UrlValidator validator = new UrlValidator();
        return validator.isValid(BASE_URL);
    }*/

    static {
        try {
            BASE_URL = ConfigManager.getInstance().getString("baseUrl");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }

    protected static final String token;

    static {
        try {
            token = ConfigManager.getInstance().getString("token");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public UserServiceHelper() throws IOException {
        baseURI = BASE_URL;
        oauth2(token);


    }

    public String generateEmail() {
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
        Random random = new Random();

        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        StringBuilder username = new StringBuilder();
        int usernameLength = random.nextInt(10) + 5; // Random length between 5 and 14
        for (int i = 0; i < usernameLength; i++) {
            int index = random.nextInt(characters.length());
            username.append(characters.charAt(index));
        }

        String[] domains = { "example.com", "test.com", "foo.com", "bar.com" }; // Add more domains if needed
        String domain = domains[random.nextInt(domains.length)];

        String email = username.toString() + "@" + domain;
        return email;
    }

    public  String generateUsername () {

        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 5;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        generatedString = buffer.toString();
        System.out.println(generatedString);
        System.out.println("\"" + generatedString + "\"");
        return generatedString;
    }

    public  String generatePassword () {

        int leftLimit = 97;
        int rightLimit = 122;
        int targetStringLength = 10;
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(targetStringLength);
        for (int i = 0; i < targetStringLength; i++) {
            int randomLimitedInt = leftLimit + (int)
                    (random.nextFloat() * (rightLimit - leftLimit + 1));
            buffer.append((char) randomLimitedInt);
        }
        generatedString = buffer.toString();
        System.out.println(generatedString);
        System.out.println("\"" + generatedString + "\"");
        return generatedString;
    }
    public String createUser()
    {
        String email1 = this.generateEmail();
        String username = this.generateUsername();
        String password = this.generatePassword();

        Account_1 account = new Account_1();
        account.setEmail(email1);
        account.setPassword(password);
        account.setUsername(username);

        Response response = given().baseUri(baseURI).contentType(ContentType.JSON).
                header("Authorization", "Bearer " + token).when().body(account).
                post(EndPoints.CREATE_User).then().log().all().extract().response();

        String responseBody = response.getBody().asString();
        JSONObject json = new JSONObject(responseBody);
        String id = json.getJSONObject("account").getString("id");


        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "User Created");
        String code = String.valueOf(response.getStatusCode());

        System.out.println("Account is created with correct 200 response code:" + code);
        //(response.getStatusCode(), HttpStatus.SC_CREATED)
        return id;
    }

    public String UpdateAccount(@NotNull ITestContext context) {

        String id = (String) context.getAttribute("id");
        System.out.println("This is the id:" + id);
        String updatedEmail = generateEmail();
        String updatedUsername = generateUsername();
        JSONObject userData = new JSONObject();
        userData.put("email", updatedEmail);
        userData.put("id", id);
        userData.put("username", updatedUsername);

        String requestBody = userData.toString();

        Response response = given().baseUri(baseURI) .contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token).
                when().body(requestBody).post(EndPoints.UPDATE_User)
                .then().log().all().extract().response();

        System.out.println("This is the response:" + response);

        String responseBody =  response.getBody().asString();
        System.out.println("This is the responsebody :" + responseBody);

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "User updated");
        String code = String.valueOf(response.getStatusCode());
        System.out.println("Account is being retrieved with correct 200 response code:" + code);
        return responseBody;
    }

    public String DeleteAccount(@NotNull ITestContext context) {

        String id = (String) context.getAttribute("id");
        System.out.println("This is the id:" + id);

        JSONObject userData = new JSONObject();
        userData.put("id", id);
        String requestBody = userData.toString();

        Response response = given().baseUri(baseURI).contentType(ContentType.JSON)
                .header("Authorization", "Bearer " + token).
                when().body(requestBody).post(EndPoints.DELETE_User).then().log().all().extract().response();

        String responseBody =  response.getBody().asString();
        System.out.println("This is the responsebody :" + responseBody);

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_OK, "Account deleted");
        String code = String.valueOf(response.getStatusCode());
        System.out.println("Account has been deleted with correct 200 response code:" + code);
        return responseBody;
    }

    public String createInvalidUser()
    {
        String email = "joe@example1235653434.com";
        String username = this.generateUsername();
        String password = this.generatePassword();

        Account_1 account = new Account_1();
        account.setEmail(email);
        account.setPassword(password);
        account.setUsername(username);

        Response response = given().baseUri(baseURI).contentType(ContentType.JSON).
                header("Authorization", "Bearer " + token).when().body(account).
                post(EndPoints.CREATE_User).then().log().all().extract().response();

        String responseBody = response.getBody().asString();
       // JSONObject json = new JSONObject(responseBody);

        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_BAD_REQUEST, "email already exists");
        String code = String.valueOf(response.getStatusCode());

        System.out.println("Account is not created with correct 400 response code- Bad Request:" + code);
        return responseBody;
    }

    public String User_WithInvalid_token()
    {
        String tokenn = "earewrewrewrewrewr4353";
        String email = this.generateEmail();
        String username = this.generateUsername();
        String password = this.generatePassword();

        Account_1 account = new Account_1();
        account.setEmail(email);
        account.setPassword(password);
        account.setUsername(username);

        Response response = given().baseUri(baseURI).contentType(ContentType.JSON).
                header("Authorization", "Bearer " + tokenn).when().body(account).
                post(EndPoints.CREATE_User).then().log().all().extract().response();

        String responseBody = response.getBody().asString();
        JSONObject json = new JSONObject(responseBody);
        Assert.assertEquals(response.getStatusCode(), HttpStatus.SC_UNAUTHORIZED, "email already exists");
        String code = String.valueOf(response.getStatusCode());

        System.out.println("Account is not created with correct 401 response code- UNAUTHORIZED:" + code);
        return responseBody;
    }

}
