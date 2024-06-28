package com.identitye2e.recipeservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecipeResultTest {

    private RecipeResult recipeResult;

    @BeforeEach
    void setUp() {
        recipeResult = new RecipeResult();
    }

    @Test
    void testId() {
        Integer id = 1;
        recipeResult.setId(id);
        assertEquals(id, recipeResult.getId());
    }

    @Test
    void testName() {
        String name = "Delicious Recipe";
        recipeResult.setName(name);
        assertEquals(name, recipeResult.getName());
    }

    @Test
    void testDescription() {
        String description = "A detailed description about the recipe.";
        recipeResult.setDescription(description);
        assertEquals(description, recipeResult.getDescription());
    }

    @Test
    void testThumbnailUrl() {
        String thumbnailUrl = "http://example.com/thumbnail.jpg";
        recipeResult.setThumbnailUrl(thumbnailUrl);
        assertEquals(thumbnailUrl, recipeResult.getThumbnailUrl());
    }

    @Test
    void testToString() {
        recipeResult.setName("Delicious Recipe");
        recipeResult.setDescription("A detailed description about the recipe.");
        recipeResult.setThumbnailUrl("http://example.com/thumbnail.jpg");

        String expectedString = "Name: Delicious Recipe\n" +
                "Description: A detailed description about the recipe.\n" +
                "Thumbnail URL: http://example.com/thumbnail.jpg\n";

        assertEquals(expectedString, recipeResult.toString());
    }
}
