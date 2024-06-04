package com.identitye2e.recipeservice;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RecipeResult {
    private String display;

    @JsonProperty("search_value")
    private String searchValue;
    private String type;

    public String getDisplay() {
        return display;
    }

    public void setDisplay(String display) {
        this.display = display;
    }

    public String getSearchValue() {
        return searchValue;
    }

    public void setSearchValue(String searchValue) {
        this.searchValue = searchValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Recipe: " + display + "\n" +
                "Search Value: " + searchValue + "\n" +
                "Type: " + type + "\n";
    }
}



