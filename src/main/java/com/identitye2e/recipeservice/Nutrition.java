package com.identitye2e.recipeservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Nutrition {
    @JsonProperty("calories")
    public int calories;

    @JsonProperty("carbohydrates")
    public int carbohydrates;

    @JsonProperty("fat")
    public int fat;

    @JsonProperty("protein")
    public int protein;

    @JsonProperty("sugar")
    public int sugar;

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public int getCarbohydrates() {
        return carbohydrates;
    }

    public void setCarbohydrates(int carbohydrates) {
        this.carbohydrates = carbohydrates;
    }

    public int getFat() {
        return fat;
    }

    public void setFat(int fat) {
        this.fat = fat;
    }

    public int getProtein() {
        return protein;
    }

    public void setProtein(int protein) {
        this.protein = protein;
    }

    public int getSugar() {
        return sugar;
    }

    public void setSugar(int sugar) {
        this.sugar = sugar;
    }

    public int getFiber() {
        return fiber;
    }

    public void setFiber(int fiber) {
        this.fiber = fiber;
    }

    @JsonProperty("fiber")
    public int fiber;

    @Override
    public String toString() {
        return "Nutrition{" +
                "calories=" + calories +
                ", carbohydrates=" + carbohydrates +
                ", fat=" + fat +
                ", protein=" + protein +
                ", sugar=" + sugar +
                ", fiber=" + fiber +
                '}';
    }

}
