package com.identitye2e.recipeservice;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AutoCompleteResponseTest {

    @Test
    public void testToString() {
        AutoCompleteResponse response = new AutoCompleteResponse();
        RecipeResult result = new RecipeResult();
        result.setDisplay("Chicken Curry");
        result.setSearchValue("chicken curry");
        result.setType("recipe");

        response.setResults(Arrays.asList(result));

        String expectedString = "Search Results:\nRecipe: Chicken Curry\nSearch Value: chicken curry\nType: recipe\n\n";
        assertEquals(expectedString, response.toString());
    }
}
