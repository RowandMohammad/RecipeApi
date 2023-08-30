package com.identitye2e.recipeservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Root {

    @JsonProperty("name")
    public String name;

    @JsonProperty("video_url")
    public String videoUrl;

    @JsonProperty("description")
    public String description;

    @JsonProperty("sections")
    public List<Section> sections;

    @JsonProperty("instructions")
    public List<Instruction> instructions;

    @JsonProperty("num_servings")
    public int numServings;

    @JsonProperty("nutrition")
    public Nutrition nutrition;

    @JsonProperty("thumbnail_url")
    private String thumbnailUrl;

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }


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

    public List<Section> getSections() {
        return sections;
    }

    public void setSections(List<Section> sections) {
        this.sections = sections;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Instruction> instructions) {
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


