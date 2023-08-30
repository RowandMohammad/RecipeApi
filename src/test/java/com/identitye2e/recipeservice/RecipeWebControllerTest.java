package com.identitye2e.recipeservice;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class RecipeWebControllerTest {

    @InjectMocks
    private RecipeWebController controller;

    @Mock
    private FileService fileService;

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        RestAssured.port = port;
    }

    static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.registerParser("text/plain", Parser.HTML);
    }



    @Test
    void testRenderTemplate() throws IOException {
        List<RecipeResult> recipes = new ArrayList<>();
        RecipeResult recipe = new RecipeResult();
        recipe.setId(1);
        recipe.setName("Sample Recipe");
        recipe.setDescription("A tasty sample recipe.");
        recipe.setThumbnailUrl("https://sample.url/image.jpg");
        recipes.add(recipe);

        when(fileService.readFileContent("src/main/resources/templates/recipes.html")).thenReturn("Rowand Recipes");

        String renderedHtml = controller.renderTemplate(recipes);

        assertTrue(renderedHtml.contains("Rowand Recipes"));
    }

    @Test
    void testRenderRecipeDetailTemplate() throws IOException {
        Root recipeDetail = new Root();
        recipeDetail.setName("Detailed Recipe");
        recipeDetail.setDescription("A detailed description of a tasty sample recipe.");
        recipeDetail.setThumbnailUrl("https://sample.url/image_detailed.jpg");

        when(fileService.readFileContent("src/main/resources/templates/recipeDetail.html")).thenReturn("Rowand Recipes");

        String renderedHtml = controller.renderRecipeDetailTemplate(recipeDetail);

        assertTrue(renderedHtml.contains("Rowand Recipes"));
    }

    @Test
    void testIndex() throws IOException {
        when(fileService.readFileContent("src/main/resources/templates/index.html")).thenReturn("<h1>Recipe Search</h1>");

        String renderedHtml = controller.index();

        assertTrue(renderedHtml.contains("<h1>Recipe Search</h1>"));
    }

    @Test
    void testDisplayRecipes() throws IOException {
        List<RecipeResult> recipes = new ArrayList<>();
        RecipeResult recipe = new RecipeResult();
        recipe.setId(1);
        recipe.setName("Sample Recipe");
        recipe.setDescription("A tasty sample recipe.");
        recipe.setThumbnailUrl("https://sample.url/image.jpg");
        recipes.add(recipe);

        when(fileService.readFileContent("src/main/resources/templates/recipes.html")).thenReturn("Rowand Recipes");

        String renderedHtml = controller.displayRecipes("testQuery");

        assertTrue(renderedHtml.contains("Rowand Recipes"));
    }


    @Test
    public void testMainEndpoint() {
        given()
                .contentType(ContentType.HTML)
                .when()
                .get("/")
                .then()
                .statusCode(200);
    }

    @Test
    public void testDisplayRecipesEndpoint() {
        String responseBody = given()
                .contentType(ContentType.HTML)
                .param("query", "chicken")
                .when()
                .get("/displayRecipes")
                .then()
                .statusCode(200)
                .extract().body().asString();
        assertTrue(responseBody.contains("<title>Recipes</title>"));

    }

    @Test
    public void testRecipeDetailsEndpoint() {
        String responseBody = given()
                .contentType(ContentType.HTML)
                .param("id", 3289)
                .when()
                .get("/recipeDetails")
                .then()
                .statusCode(200)
                .extract().body().asString();

        assertTrue(responseBody.contains("<h1 class=\"title\">One-Pot Chicken Fajita Pasta</h1>"));

    }




}
