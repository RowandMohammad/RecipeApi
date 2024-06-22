package com.identitye2e.recipeservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Root {

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }

    @JsonProperty("thumbnail_url")
    private String thumbnailUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVideoUrl() {
        return videoUrl;
    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Section> getSections() {
        return sections;
    }

    public void setSections(ArrayList<Section> sections) {
        this.sections = sections;
    }

    public ArrayList<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(ArrayList<Instruction> instructions) {
        this.instructions = instructions;
    }

    public int getNumServings() {
        return numServings;
    }

    public void setNumServings(int numServings) {
        this.numServings = numServings;
    }

    public Nutrition getNutrition() {
        return nutrition;
    }

    public void setNutrition(Nutrition nutrition) {
        this.nutrition = nutrition;
    }

    @JsonProperty("name")
    public String name;

    @JsonProperty("video_url")
    public String videoUrl;

    @JsonProperty("description")
    public String description;

    @JsonProperty("sections")
    public ArrayList<Section> sections;

    @JsonProperty("instructions")
    public ArrayList<Instruction> instructions;

    @JsonProperty("num_servings")
    public int numServings;

    @JsonProperty("nutrition")
    public Nutrition nutrition;


    @Override
    public String toString() {
        return "Root{" +
                "name='" + name + '\'' +
                ", videoUrl='" + videoUrl + '\'' +
                ", description='" + description + '\'' +
                ", sections=" + sections +
                ", instructions=" + instructions +
                ", numServings=" + numServings +
                ", nutrition=" + nutrition +
                '}';
    }

}


