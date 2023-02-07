package Automation_tasks.api_task.zeelAPI;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.*;

import static io.restassured.RestAssured.given;


public class GetRequest {
    String url = "https://iezapt5vu6.execute-api.us-east-1.amazonaws.com/test/getkey";
    @DisplayName("GET call query parameters")
    @Test()
    public void getCall(){
            given();
    }
}
