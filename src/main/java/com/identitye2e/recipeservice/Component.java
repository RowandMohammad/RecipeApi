package com.identitye2e.recipeservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Component {
    @JsonProperty("measurements")
    public ArrayList<Measurement> measurements;

    @JsonProperty("ingredient")
    public Ingredient ingredient;

    public ArrayList<Measurement> getMeasurements() {
        return measurements;
    }

    public void setMeasurements(ArrayList<Measurement> measurements) {
        this.measurements = measurements;
    }

    public Ingredient getIngredient() {
        return ingredient;
    }

    public void setIngredient(Ingredient ingredient) {
        this.ingredient = ingredient;
    }

    public String getRawText() {
        return rawText;
    }

    public void setRawText(String rawText) {
        this.rawText = rawText;
    }

    @JsonProperty("raw_text")
    public String rawText;

    @Override
    public String toString() {
        return "Component{" +
                "measurements=" + measurements +
                ", ingredient=" + ingredient +
                ", rawText='" + rawText + '\'' +
                '}';
    }

}
