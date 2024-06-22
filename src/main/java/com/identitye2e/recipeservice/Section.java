package com.identitye2e.recipeservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Section {
    @JsonProperty("components")
    public ArrayList<Component> components;

    public ArrayList<Component> getComponents() {
        return components;
    }

    public void setComponents(ArrayList<Component> components) {
        this.components = components;
    }

    @Override
    public String toString() {
        return "Section{" +
                "components=" + components +
                '}';
    }

}
