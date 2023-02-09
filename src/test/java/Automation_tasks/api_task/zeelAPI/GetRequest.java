package Automation_tasks.api_task.zeelAPI;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.baseURI;
import static org.hamcrest.Matchers.*;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;

import org.junit.jupiter.api.Test;
import java.util.*;

import static io.restassured.RestAssured.*;


public class GetRequest {
    static List<Map<String,String>>patientMap;
    String url       = "https://iezapt5vu6.execute-api.us-east-1.amazonaws.com/test/patient";
    String updateUrl = "https://iezapt5vu6.execute-api.us-east-1.amazonaws.com/test/update";
    String apiKey    = "19024181417131114141320230207";

    @DisplayName("GET call query parameters")
    @Test()
    public void getTask2(){
                Response response = given().accept(ContentType.JSON).queryParam("api_key", apiKey)
                .when().get(url);

                JsonPath jsonPath = response.jsonPath();

                patientMap = jsonPath.getList("");


                boolean isTrue =false;
                for (int i = 0; i < patientMap.size(); i++) {
                if (patientMap.get(i).get("appointment_date").contains("2022-06")){
                    isTrue = true;
            }
        }
                Assertions.assertTrue(isTrue);

    }
    @DisplayName("In a test, fail if the following patient does not exist")
    @Test()
    public void getTask3(){

                 String body = "{id=SR19760827202206208364, " +
                               "birthdate=1976-08-27, phone=347-555-9876, " +
                               "appointment_date=2022-06-20, name={lastName=Rogers, firstName=Steve}, " +
                               "address={street=45 W 45th St, city=New York, state=NY, zip=10036}}";

                 JsonPath jsonPath = given().accept(ContentType.JSON)

                .queryParam("api_key", apiKey)
                .when().get(url).then()
                .extract().jsonPath();
                 patientMap = jsonPath.getList("");
                 String patient="";

        for (int i = 0; i < patientMap.size(); i++) {

                if(patientMap.get(i).get("id").equals("SR19760827202206208364")){
                 patient = patientMap.get(i).toString();
                 System.out.println(patient);
            }
        }
                 Assertions.assertEquals(body,patient);

    }
    @DisplayName("Verify the “id” for all of the patients")
    @Test()
    public void getTask4(){
                JsonPath jsonPath = given().accept(ContentType.JSON)

                .queryParam("api_key", apiKey)
                .when().get(url).then()
                .extract().jsonPath();
                 patientMap = jsonPath.getList("");

        for ( int i = 0; i < patientMap.size(); i++) {
                String   result ="";
                result+= jsonPath.getString("name.firstName["+i+"]").substring(0,1);
                result+= jsonPath.getString("name.lastName["+i+"]").substring(0,1);
                result+= jsonPath.getString("birthdate["+i+"]").substring(0,4);
                result+= jsonPath.getString("birthdate["+i+"]").substring(5,7);
                result+= jsonPath.getString("birthdate["+i+"]").substring(8);
                result+= jsonPath.getString("appointment_date["+i+"]").substring(0,4);
                result+= jsonPath.getString("appointment_date["+i+"]").substring(5,7);
                result+= jsonPath.getString("appointment_date["+i+"]").substring(8);

                Assertions.assertEquals(result,patientMap.get(i).get("id").substring(0,18));
        }
    }
    @DisplayName("Create a JSON payload  includes the following updates to the patient")
    @Test()
    public void getTask5(){


               String body = "{\n" +
                "\"id\": \"SR19760827202206208364\",\n" +
                "\n" +
                "\"name\": {\n" +
                "\"firstName\": \"Tester\",\n" +
                "\"lastName\": \"Awesome\"\n" +
                "},\n" +
                "\"address\": {\n" +
                "\"street\": \"20 nunnawauk\",\n" +
                "\"city\": \"Newtown\",\n" +
                "\"state\": \"CT\",\n" +
                "\"zip\": \"06470\"\n" +
                "}\n" +
                "}";

                given().body(body).accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .queryParam("api_key", apiKey).and()
                .when().patch(updateUrl)
                .then().statusCode(201);
                JsonPath jsonPath = given().accept(ContentType.JSON)

                .queryParam("api_key", apiKey)
                .when().get(url).then()
                .extract().jsonPath();
                 patientMap = jsonPath.getList("");


                 patientMap = jsonPath.getList("");

                 for (int i = 0; i <patientMap.size() ; i++) {
                     if (patientMap.get(i).get("id").equals("SR19760827202206208364")){
                          System.out.println(patientMap.get(i));
                      }
        }
    }
    @DisplayName("Make a PATCH call to the following URL with the JSON payload ")
    @Test()
    public void getTask6(){
        JsonPath jsonPath = given().accept(ContentType.JSON)
                .and().contentType(ContentType.JSON)
                .queryParam("api_key", apiKey).and()
                .when().patch(updateUrl)
                .then().statusCode(201).extract().jsonPath();
        System.out.println(jsonPath.getList(""));


    }
    @DisplayName("assert the following from the update (PATCH) response")
    @Test()
    public void getTask7(){


    }

}
