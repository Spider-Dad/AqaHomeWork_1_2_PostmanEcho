package ru.netology;

import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;

public class PostmanEchoTest {
    @Test
    public void testPostWithJsonBody (){
        // Given - When - Then
        // Предусловия
         String jsonBody = "{\"id\": 1, \"name\": \"Petr\", \"number\": 1234, \"balance\": 100, \"currency\": \"RUB\"}";

        given()
                .baseUri("https://postman-echo.com")
                .header("Content-Type","application/json")
                .body(jsonBody)
                // Выполняемые действия
                .when()
                .post("/post")
                // Проверки
                .then()
                .statusCode(200)
                .body("json.id", equalTo(1))
                .body("json.name", equalTo("Petr"))
                .body("json.number",equalTo(1234))
                .body("json.balance", greaterThanOrEqualTo(150))
                .body("json.currency", equalTo("RUB"))
        ;
    }
}
