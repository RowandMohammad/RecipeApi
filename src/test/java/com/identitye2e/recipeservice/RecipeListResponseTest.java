package com.identitye2e.recipeservice;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RecipeListResponseTest {

    private RecipeListResponse recipeListResponse;

    @BeforeEach
    void setUp() {
        recipeListResponse = new RecipeListResponse();
    }

    @Test
    void testCount() {
        int count = 5;
        recipeListResponse.setCount(count);
        assertEquals(count, recipeListResponse.getCount());
    }

    @Test
    void testResults() {
        List<RecipeResult> results = new ArrayList<>();
        results.add(new RecipeResult());
        recipeListResponse.setResults(results);
        assertEquals(results, recipeListResponse.getResults());
    }

    @Test
    void testToString() {
        int count = 5;
        recipeListResponse.setCount(count);
        assertTrue(recipeListResponse.toString().contains("Count: " + count));
    }
}
