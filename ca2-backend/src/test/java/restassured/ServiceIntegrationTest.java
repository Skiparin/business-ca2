/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restassured;

import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import java.util.List;
import static org.hamcrest.Matchers.equalTo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author kaspe
 */
public class ServiceIntegrationTest {
    
//    public ServiceIntegrationTest() {
//    }
//    
//    @BeforeClass
//    public static void setUpClass() {
//        RestAssured.baseURI = "http://localhost";
//        RestAssured.port = 8084;
//        RestAssured.basePath = "/ca2-backend";
//        RestAssured.defaultParser = Parser.JSON;
//    }
//    
//    @AfterClass
//    public static void tearDownClass() {
//    }
//    
//    @Before
//    public void setUp() {
//    }
//    
//    @After
//    public void tearDown() {
//    }
//
//    @Test
//    public void serverIsRunning() {
//        given().
//        when().
//        get().
//        then().
//        statusCode(200);
//        
//    }
//    
//    @Test
//    public void getPersons() {
//        Response response =
//            when().
//                get("/api/person/complete").
//            then().
//                contentType(ContentType.JSON).  // check that the content type return from the API is JSON
//            extract().response(); // extract the response
//        
//        String jsonAsString = response.asString();
//        
//        List<Integer> list = response.path("id");
//        
//        for (int js : list) {
//            Assert.assertNotNull(js);
//        }
//    }
//        
//    @Test
//    public void getPersonById() {
//        given().
//        when().get("/api/person/complete/3").
//        then().statusCode(200).
//        body("id", equalTo(3));
//    }

//    
//    @Test
//    public void getInfoPersons() {
//        given().
//        when().get("/api/person/conctactinfo").
//        then().statusCode(200).
//        body(containsString("22970674"));
//    }
//    
//    @Test
//    public void getPersonInfoById() {
//        given().
//        when().get("/api/person/contactinfo/1").
//        then().statusCode(200).
//        body(containsString("Kasper"));
//    }
//    
//    @Test
//    public void getPersonsByHoppy() {
//        given().
//        when().get("/api/person/hobby/fodbold").
//        then().statusCode(200).
//        body(containsString("Kasper"));
//    }
//    
//    @Test
//    public void createPerson() {
//        given().
//        when().post("/api/person").
//        then().statusCode(200);
//    }
//    
//    @Test
//    public void editPerson() {
//        given().
//        when().put("/api/person/hobby/fodbold").
//        then().statusCode(200);
//    }
//    
//    @Test
//    public void deletePerson() {
//        given().
//        when().delete("/api/person/hobby/fodbold").
//        then().statusCode(200);
//    }
//    
//    //-------------------------------------------------------------
//    
//    @Test
//    public void getCompanies() {
//        given().
//        when().get("/api/company/complete").
//        then().statusCode(200);
//    }
//    
//    @Test
//    public void getCompaniesById() {
//        given().
//        when().get("/api/company/complete/1").
//        then().statusCode(200);
//    }
//    
//    @Test
//    public void getInfoCompanies() {
//        given().
//        when().get("/api/company/contactinfo").
//        then().statusCode(200);
//    }
//    
//    @Test
//    public void getCompanyInfoById() {
//        given().
//        when().get("/api/company/complete/id").
//        then().statusCode(200);
//    }
//    
//    @Test
//    public void createCompany() {
//        given().
//        when().post("/api/company").
//        then().statusCode(200);
//    }
//    
//    @Test
//    public void editCompany() {
//        given().
//        when().put("/api/company/").
//        then().statusCode(200);
//    }
//    
//    @Test
//    public void deleteCompanyById() {
//        given().
//        when().delete("/api/company/id").
//        then().statusCode(200);
//    }
//    
//    
//    
//    
//    
//    
}
