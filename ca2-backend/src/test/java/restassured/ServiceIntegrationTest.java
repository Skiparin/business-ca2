/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package restassured;

import com.mycompany.ca2.backend.entities.Company;
import com.mycompany.ca2.backend.entities.Person;
import com.mycompany.ca2.backend.jsonparser.JSONConverter;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static org.hamcrest.CoreMatchers.equalTo;
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
        Response response
                = when().
                get("/api/person/complete").
                then().
                contentType(ContentType.JSON). // check that the content type return from the API is JSON
                extract().response(); // extract the response

        List<Integer> list = response.path("id");

        for (int js : list) {
            Assert.assertNotNull(js);
        }
    }

    @Test
    public void getPersonById() {
        given().
                when().get("/api/person/complete/5").
                then().statusCode(200).
                body("id", equalTo(5));
    }

//    @Test
//    public void getInfoPersons() {
//        given().
//        when().get("/api/person/conctactinfo").
//        then().statusCode(200).
//        body(containsString("22970674"));
//    }
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
    @Test
    public void createPerson() {
        Map<String, String> person = new HashMap<>();
        person.put("firstName", "Kasper");
        person.put("lastName", "Vetter");
        given()
                .contentType("application/json")
                .body(person)
                .when().post("/api/person").
                then().statusCode(204);
    }

    @Test
    public void editPerson() {
        Map<String, String> person = new HashMap<>();
        person.put("id", String.valueOf(new Long(13)));
        person.put("firstName", "Phillip");
        person.put("lastName", "Brink");
        given().
                contentType(ContentType.JSON).
                body(person).
                when().put("/api/person").
                then().statusCode(200);
    }

    @Test
    public void deletePerson() {
        given().
                when().delete("/api/person/6").
                then().statusCode(500);
    }

    //-------------------------------------------------------------
    @Test
    public void getCompanies() {

        Response response
                = when().get("/api/company/complete").
                then().contentType(ContentType.JSON).extract().response();

        List<Integer> list = response.path("id");

        for (int id : list) {
            Assert.assertNotNull(id);
        }
    }
//

    @Test
    public void getCompanyByCvr() {
        given().
                when().get("/api/company/complete/987").
                then().statusCode(200).
                body("cvr", equalTo("007"));
    }
//
//    @Test
//    public void getInfoCompanies() {
//        given().
//                when().get("/api/company/contactinfo").
//                then().statusCode(200);
//    }
//
//    @Test
//    public void getCompanyInfoByCvr() {
//        given().
//                when().get("/api/company/complete/id").
//                then().statusCode(200);
//    }
//

    @Test
    public void createCompany() {
        Map<String, String> company = new HashMap<>();
        company.put("name", "Tom's Chokolade");
        company.put("description", "Snacks");
        company.put("cvr", "987");
        company.put("NumEmployees", "200");
        company.put("marketValue", "98007");
        given()
                .contentType("application/json")
                .body(company)
                .when().post("/api/company").
                then().statusCode(204);
    }

    @Test
    public void editCompany() {
        
        Map<String, String> c = new HashMap<>();
        c.put("id", String.valueOf(new Long(23)));
        c.put("name", "Store");
        c.put("description", "Stuff");
        c.put("cvr", "007");
        given().
                contentType(ContentType.JSON).
                body(c).
                when().put("/api/company").
                then().statusCode(200);
    }

    @Test
    public void deleteCompanyById() {
        given().
                when().delete("/api/company/7").
                then().statusCode(500);
    }
}
