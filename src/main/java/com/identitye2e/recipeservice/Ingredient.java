package com.identitye2e.recipeservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Ingredient {
    @JsonProperty("name")
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplaySingular() {
        return displaySingular;
    }

    public void setDisplaySingular(String displaySingular) {
        this.displaySingular = displaySingular;
    }

    public String getDisplayPlural() {
        return displayPlural;
    }

    public void setDisplayPlural(String displayPlural) {
        this.displayPlural = displayPlural;
    }

    @JsonProperty("display_singular")
    public String displaySingular;

    @JsonProperty("display_plural")
    public String displayPlural;
}
