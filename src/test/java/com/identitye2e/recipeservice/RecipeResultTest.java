package com.identitye2e.recipeservice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RecipeResultTest {

    @Test
    public void testToString() {
        RecipeResult result = new RecipeResult();
        result.setDisplay("Chicken Curry");
        result.setSearchValue("chicken curry");
        result.setType("recipe");

        String expectedString = "Recipe: Chicken Curry\nSearch Value: chicken curry\nType: recipe\n";
        assertEquals(expectedString, result.toString());
    }
}
