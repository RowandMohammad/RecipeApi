package com.identitye2e.recipeservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RecipeWebControllerTest {

    private RecipeWebController controller;

    @BeforeEach
    void setUp() {
        controller = new RecipeWebController();
        controller.fileService = new FileService();
    }

    @Test
    void testRenderTemplate() {
        List<RecipeResult> recipes = new ArrayList<>();
        RecipeResult recipe = new RecipeResult();
        recipe.setId(1);
        recipe.setName("Sample Recipe");
        recipe.setDescription("A tasty sample recipe.");
        recipe.setThumbnailUrl("https://sample.url/image.jpg");
        recipes.add(recipe);

        String renderedHtml = controller.renderTemplate(recipes);

        assertTrue(renderedHtml.contains("Rowand Recipes"));
        assertTrue(renderedHtml.contains("<a href=\"/recipeDetails?id=1\">Sample Recipe</a>"));
        assertTrue(renderedHtml.contains("A tasty sample recipe."));
        assertTrue(renderedHtml.contains("https://sample.url/image.jpg"));
    }

    @Test
    void testRenderRecipeDetailTemplate() {
        Root recipeDetail = new Root();
        recipeDetail.setName("Detailed Recipe");
        recipeDetail.setDescription("A detailed description of a tasty sample recipe.");
        recipeDetail.setThumbnailUrl("https://sample.url/image_detailed.jpg");

        String renderedHtml = controller.renderRecipeDetailTemplate(recipeDetail);

        assertTrue(renderedHtml.contains("Rowand Recipes"));
        assertTrue(renderedHtml.contains("Detailed Recipe"));
        assertTrue(renderedHtml.contains("A detailed description of a tasty sample recipe."));
        assertTrue(renderedHtml.contains("https://sample.url/image_detailed.jpg"));
    }

    @Test
    void testIndex() {
        String renderedHtml = controller.index();
        assertTrue(renderedHtml.contains("<h1>Recipe Search</h1>"));
    }








}
