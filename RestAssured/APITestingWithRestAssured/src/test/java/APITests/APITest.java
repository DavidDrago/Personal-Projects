package APITests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.module.jsv.JsonSchemaValidator.*;

public class APITest {

    @BeforeClass
    public void setup() {
        baseURI = "https://jsonplaceholder.typicode.com/";
    }

    @Test
    public void testGetObjects(){

        Response response = get("https://jsonplaceholder.typicode.com/");

        System.out.println(response.getStatusCode());
        System.out.println(response.getTime());
        System.out.println(response.statusLine());
        System.out.println(response.getBody().asString());
        System.out.println(response.getHeader("content-type"));
        Assert.assertEquals(response.getStatusCode(), 200);
        Assert.assertEquals(response.getStatusLine(), "HTTP/1.1 200 OK");
    }

    @Test
    public void testGetObjectId(){
        // baseURI = "https://jsonplaceholder.typicode.com/";

        //BDD style
        given().
            get("/posts").
        then().
            statusCode(200);

        // We can use Json Path finder to navigate to the elemnet which we are unaware of
        get("/posts/7").then().body("title", equalTo("magnam facilis autem"));

        // json file follows indexing. so the we are getting 3 items name value.
        get("/posts").then().body("title[1]", equalTo("qui est esse"));

        get("/posts").then().body("[12].body", containsString("aut dicta possimus sint mollitia voluptas commodi quo doloremque"));

        get("/posts").then()
                .body("[9].title", equalTo("optio molestias id quia eum"))
                .body("title", hasItems("qui est esse", "nesciunt quas odio"));
    }

    @Test
    public void testPost(){
        // baseURI = "https://jsonplaceholder.typicode.com/";

        JSONObject request = new JSONObject();
        request.put("userId", 10);
        request.put("title", "Api Testing using RestAssured");
        request.put("body", "The Post request is being tested using RestAssured");

        System.out.println(request.toJSONString());

        given().
            contentType(ContentType.JSON).
            accept(ContentType.JSON).
            body(request.toJSONString()).
        when().
            post("/posts").
        then().
            statusCode(201).log().all();
    }

    @Test
    public void testPut(){
        // baseURI = "https://jsonplaceholder.typicode.com/";

        JSONObject request = new JSONObject();
        request.put("userId", 10);
        request.put("title", "Api Testing using RestAssured");
        request.put("body", "The Post request is being tested using RestAssured");

        System.out.println(request.toJSONString());

        given().
                // header("Content-Type", "application/json"). // since we used contentType this is not needed.
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                put("/posts/100").
        then().
                statusCode(200).log().all();
    }

    @Test
    public void testPatch(){
        // baseURI = "https://jsonplaceholder.typicode.com/";

        JSONObject request = new JSONObject();
        request.put("userId", 10);
        request.put("title", "Api Testing using RestAssured");
        request.put("body", "The Post request is being tested using RestAssured");

        System.out.println(request.toJSONString());

        given().
                // header("Content-Type", "application/json"). // since we used contentType this is not needed.
                contentType(ContentType.JSON).
                accept(ContentType.JSON).
                body(request.toJSONString()).
        when().
                patch("/posts/100").
        then().
                statusCode(200).log().all();
    }

    @Test
    public void testDelete(){
        // baseURI = "https://jsonplaceholder.typicode.com/";

        when().
                delete("/posts/100").
        then().
                statusCode(200).log().all();
    }

    @Test
    public void testJSONSchemaValidator(){
        get("/posts/50").
                then().
        assertThat().
        body(matchesJsonSchemaInClasspath("posts_Schema.json")).statusCode(200).log().all();

        get("/comments/100").
                then().
        assertThat().
        body(matchesJsonSchemaInClasspath("comments_Schema.json")).statusCode(200).log().all();
    }
}
