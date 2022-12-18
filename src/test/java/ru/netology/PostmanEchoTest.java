package ru.netology;


import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsEqual.equalTo;


public class PostmanEchoTest {

    @Test
    public void shouldCheckBody() {
        // Given - When - Then
// Предусловия
        given()
                .baseUri("https://postman-echo.com")
                .body("Netology Echo Postman") // отправляемые данные (заголовки и query можно выставлять аналогично)
// Выполняемые действия
                .when()
                .post("/post")
// Проверки
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data", equalTo("Netology Echo Postman"))
        ;
    }

    @Test
    public void shouldCheckBodyId() {
        // Given - When - Then
        given()
                .baseUri("https://postman-echo.com")
                .body("id:1")
                .when()
                .post("/post")
                .then()
                .statusCode(200)
                .contentType(ContentType.JSON)
                .body("data", equalTo("id:2"))
        ;
    }
}