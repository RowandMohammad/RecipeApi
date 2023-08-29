package com.identitye2e.recipeservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NutritionTest {

    private Nutrition nutrition;

    @BeforeEach
    void setUp() {
        nutrition = new Nutrition();
    }

    @Test
    void testCaloriesSetterAndGetter() {
        nutrition.setCalories(200);
        assertEquals(200, nutrition.getCalories());
    }

    @Test
    void testCarbohydratesSetterAndGetter() {
        nutrition.setCarbohydrates(50);
        assertEquals(50, nutrition.getCarbohydrates());
    }

    @Test
    void testFatSetterAndGetter() {
        nutrition.setFat(10);
        assertEquals(10, nutrition.getFat());
    }

    @Test
    void testProteinSetterAndGetter() {
        nutrition.setProtein(15);
        assertEquals(15, nutrition.getProtein());
    }

    @Test
    void testSugarSetterAndGetter() {
        nutrition.setSugar(5);
        assertEquals(5, nutrition.getSugar());
    }

    @Test
    void testFiberSetterAndGetter() {
        nutrition.setFiber(3);
        assertEquals(3, nutrition.getFiber());
    }

    @Test
    void testToStringMethod() {
        nutrition.setCalories(200);
        nutrition.setCarbohydrates(50);
        nutrition.setFat(10);
        nutrition.setProtein(15);
        nutrition.setSugar(5);
        nutrition.setFiber(3);

        String expectedOutput = "Nutrition{calories=200, carbohydrates=50, fat=10, protein=15, sugar=5, fiber=3}";
        assertEquals(expectedOutput, nutrition.toString());
    }
}
