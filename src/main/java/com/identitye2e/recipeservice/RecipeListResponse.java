package com.identitye2e.recipeservice;

import java.util.List;

public class RecipeListResponse {
    private int count;
    private List<RecipeResult> results;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<RecipeResult> getResults() {
        return results;
    }

    public void setResults(List<RecipeResult> results) {
        this.results = results;
    }

    @Override
    public String toString() {
        return "Count: " + count + "\n" +
                "Results: " + results + "\n";
    }
}
