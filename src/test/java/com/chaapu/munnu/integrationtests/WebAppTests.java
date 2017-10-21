package com.chaapu.munnu.integrationtests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.context.embedded.LocalServerPort;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.containsString;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class WebAppTests {

    @LocalServerPort
    private int port;

    @Test
    public void isAbleToGetLoginPage() throws Exception {
        given().
                port(port).
        when().
                get("/login").
        then().
                statusCode(200).
                body(containsString("User Name"));
    }

    @Test
    public void canSeeErrorMessageOnSubmittingEmptyForm() throws Exception {
        given().
                param("userName", "").
                param("password", "").
                port(port).
        when().
                post("/login").
        then().
                statusCode(200).
                body(containsString("Please enter Details"));
    }

    @Test
    public void canSeeErrorMessageOnSubmittingFormWithInvalidCredentials() throws Exception {
        given().
                param("userName", "bla").
                param("password", "bla").
                port(port).
        when().
                post("/login").
        then().
                statusCode(200).
                body(containsString("Invalid Details"));
    }

    @Test
    public void canSuccessfullyLoginWithValidCredentials() throws Exception {
        given().
                param("userName", "chaapu").
                param("password", "munnu").
                port(port).
        when().
                post("/login").
        then().
                statusCode(200).
                body(containsString("You have successfully logged in"));
    }

}
