package APITests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.*;

public class LocalAPITest {

    @BeforeClass
    public void setup() {
        baseURI = "http://localhost:3000";
    }

    @Test
    public void testGetRequest(){
        given().
                get("/students").
        then().
                statusCode(200).log().all();
    }

    @Test
    public void testPostRequest(){
        JSONObject request = new JSONObject();
        request.put("firstname", "Pawan");
        request.put("lastname", "Kalyan");
        request.put("subjectid", 2);

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                post("/students").
        then().
                statusCode(201).log().all();
    }

    @Test
    public void testPutRequest(){
        JSONObject request = new JSONObject();
        request.put("firstname", "Pawan");
        request.put("lastname", "Sangi");
        request.put("subjectid", 1);

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                put("/students/3").
        then().
                statusCode(200).log().all();
    }

    @Test
    public void testPatchRequest(){
        JSONObject request = new JSONObject();
        request.put("firstname", "Pavan");

        given().
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                patch("/students/3").
        then().
                statusCode(200).log().all();
    }

    @Test
    public  void testDeleteRequest(){
        when().
                delete("/students/3").
        then().
                statusCode(200).log().all();
    }
}
