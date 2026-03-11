package APITests;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import io.restassured.RestAssured;
import io.restassured.config.XmlConfig;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;
import org.apache.commons.io.IOUtils;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class SoapAPITest {

    @Test
    public void testSoapXMLRequest() throws IOException {
        File file = new File("./SoapRequests/numberToWords.xml"); // we can use Wizdler extrension to get the xml request of the soap web service
        if(file.exists()){
            System.out.println("file exists >>>");
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        String requestBody = IOUtils.toString(fileInputStream, "UTF-8");

        // RestAssured.config = RestAssured.config().xmlConfig(XmlConfig.xmlConfig().disableLoadingOfExternalDtd());

        baseURI = "https://www.dataaccess.com/webservicesserver";

        given().
                contentType("text/xml").
                accept(ContentType.XML).
                body(requestBody).
        when().
        post("/NumberConversion.wso").
        then().statusCode(200).log().all().
        and().
                body("//*:NumberToWordsResult.text()", equalTo("five hundred ")). // used https://www.freeformatter.com/xpath-tester.html#before-output to get the xpath for the logged result
        and().
                assertThat().body(RestAssuredMatchers.matchesXsdInClasspath("numberToWords.xsd")); // used https://www.freeformatter.com/xsd-generator.html#before-output tp get the xsd schema for logged result
    }
}
