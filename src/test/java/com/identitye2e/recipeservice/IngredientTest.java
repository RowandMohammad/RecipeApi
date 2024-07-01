package com.identitye2e.recipeservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class IngredientTest {

    private Ingredient ingredient;

    @BeforeEach
    void setUp() {
        ingredient = new Ingredient();
    }

    @Test
    void testName() {
        String expectedName = "Flour";
        ingredient.setName(expectedName);
        assertEquals(expectedName, ingredient.getName());
    }

    @Test
    void testDisplaySingular() {
        String expectedDisplaySingular = "Cup";
        ingredient.setDisplaySingular(expectedDisplaySingular);
        assertEquals(expectedDisplaySingular, ingredient.getDisplaySingular());
    }

    @Test
    void testDisplayPlural() {
        String expectedDisplayPlural = "Cups";
        ingredient.setDisplayPlural(expectedDisplayPlural);
        assertEquals(expectedDisplayPlural, ingredient.getDisplayPlural());
    }
}
