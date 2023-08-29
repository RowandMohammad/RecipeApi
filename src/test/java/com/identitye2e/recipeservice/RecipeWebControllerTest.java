package com.identitye2e.recipeservice;

import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.Matchers.containsString;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class RecipeWebControllerTest {

    @Test
    public void testIndex() {
        RestAssured.given()
                .port(8080)  // if your app is running on a different port, update this
                .get("/")
                .then()
                .statusCode(200)
                .body(containsString("Recipe Search"));
    }

    @Test
    public void testDisplayRecipes() {
        String query = "chicken";
        RestAssured.given()
                .port(8080)
                .param("query", query)
                .get("/displayRecipes")
                .then()
                .statusCode(200)
                .body(containsString("Recipes"));
    }

    @Test
    public void testDisplayRecipeDetails() {
        Integer id = 3289;  // some id for testing
        RestAssured.given()
                .port(8080)
                .param("id", id)
                .get("/recipeDetails")
                .then()
                .statusCode(200)
                .body(containsString("Rowand Recipes"))
                .body(containsString("One-Pot Chicken Fajita Pasta"));
    }


}
