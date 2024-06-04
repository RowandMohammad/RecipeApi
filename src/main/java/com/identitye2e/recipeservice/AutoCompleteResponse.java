package com.identitye2e.recipeservice;

import java.util.List;

public class AutoCompleteResponse {

    private List<RecipeResult> results;

    public List<RecipeResult> getResults() {
        return results;
    }

    public void setResults(List<RecipeResult> results) {
        this.results = results;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Search Results:\n");
        for (RecipeResult result : results) {
            sb.append(result.toString()).append("\n");
        }
        return sb.toString();
    }
}