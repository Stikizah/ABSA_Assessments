package page;

import base.Base;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;

public class DogAPIPage extends Base {
    public WebDriver driver;
    String responseBody;
    int statusCode;
    public DogAPIPage(WebDriver driver)
    {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public void DiagramOne() {
        System.out.println("----------Diagram One---------");

        RestAssured.baseURI = prop.getProperty("allDoApiURL");
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,prop.getProperty("allDoApiURL"));

        responseBody = response.getBody().asString();

        String formattedJsonString = prettyPrintUsingGson(responseBody);
        System.out.println(formattedJsonString);

    }

    public void DiagramTwo()
    {
        System.out.println("----------Diagram Two---------");

        RestAssured.baseURI = prop.getProperty("searchRetrieverUrl");
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,prop.getProperty("searchRetrieverUrl"));

        responseBody = response.getBody().asString();

        if (responseBody.contains("retriever"))
        {
            System.out.println("PASS Verify - retriever is within list");
        }else {
            System.out.println("FAIL Verify - retriever is NOT within list");
        }

    }

    public void DiagramThree() {

        System.out.println("----------Diagram Three---------");

        RestAssured.baseURI = prop.getProperty("breedsForRetrieverUrl");
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,prop.getProperty("breedsForRetrieverUrl"));

        responseBody = response.getBody().asString();

        String formattedJsonString = prettyPrintUsingGson(responseBody);
        System.out.println(formattedJsonString);

    }

    public void DiagramFour()
    {
        System.out.println("----------Diagram Four---------");

        RestAssured.baseURI = prop.getProperty("subBreedGoldenUrl");
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET,prop.getProperty("subBreedGoldenUrl"));

        responseBody = response.getBody().asString();

        String formattedJsonString = prettyPrintUsingGson(responseBody);
        System.out.println(formattedJsonString);

    }

    public String prettyPrintUsingGson(String uglyJson) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        JsonElement jsonElement = JsonParser.parseString(uglyJson);
        String prettyJsonString = gson.toJson(jsonElement);
        return prettyJsonString;
    }
}
