/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restassured;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import static org.hamcrest.Matchers.equalTo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author kaspe
 */
public class ServiceIntegrationTest {
    
    public ServiceIntegrationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8084;
        RestAssured.basePath = "/ca2-backend";
        RestAssured.defaultParser = Parser.JSON;
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void serverIsRunning() {
        given().
        when().
        get().
        then().
        statusCode(200);
        
    }
    
    @Test
    public void getPersons() {
        given().
        when().get("/api/person/complete").
        then().statusCode(200).
        body("firstName", equalTo("firstName"), "Vetter", equalTo("Vetter"));
    }
    
//        @Test
//    public void getPersonss() {
//        Response response = given().
//        when().get("/api/person/complete").
//        then().contentType(ContentType.TEXT).extract().response();
//        String jsonAsString = response.toString();
//        assertEquals("{\"firstName\":\"Kasper\"}", jsonAsString);
//    } 
}
