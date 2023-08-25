package com.identitye2e.recipeservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true)

public class RecipeDetail {

    private String name;
    private List<Instruction> instructions;
    private Nutrition nutrition;
    @JsonProperty("thumbnail_url")
    private String thumbnailUrl;

    // Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Instruction> getInstructions() {
        return instructions;
    }

    public void setInstructions(List<Instruction> instructions) {
        this.instructions = instructions;
    }

    public Nutrition getNutrition() {
        return nutrition;
    }

    public void setNutrition(Nutrition nutrition) {
        this.nutrition = nutrition;
    }

    public String getThumbnailUrl() {
        return thumbnailUrl;
    }

    public void setThumbnailUrl(String thumbnailUrl) {
        this.thumbnailUrl = thumbnailUrl;
    }
    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Instruction {
        public String getDisplayText() {
            return displayText;
        }

        public void setDisplayText(String displayText) {
            this.displayText = displayText;
        }

        public Integer getStartTime() {
            return startTime;
        }

        public void setStartTime(Integer startTime) {
            this.startTime = startTime;
        }

        public Integer getEndTime() {
            return endTime;
        }

        public void setEndTime(Integer endTime) {
            this.endTime = endTime;
        }


        public String getDuration() {
            if (this.startTime == null || this.endTime == null) {
                return "Determined by Cook";
            }

            double durationMinutes = (this.endTime - this.startTime) / 1000.0;

            // Rounding up to the nearest whole number
            int roundedMinutes = (int) Math.ceil(durationMinutes);

            // Make sure there's no duration less than 1 minute
            if (roundedMinutes == 0) {
                roundedMinutes = 1;
            }

            int hours = roundedMinutes / 60;
            int minutes = roundedMinutes % 60;

            if (hours > 0) {
                return String.format("%d hour%s %d min%s",
                        hours, (hours == 1 ? "" : "s"),
                        minutes, (minutes == 1 ? "" : "s"));
            } else {
                return String.format("%d min", minutes);
            }
        }

        public boolean hasTimeInText() {
            if (this.displayText == null) {
                return false;
            }

            // A basic regex pattern that checks for time-related phrases
            String timePattern = "(\\d+\\s*(min|minute|hr|hour|sec|second)s?)";

            return this.displayText.toLowerCase().matches(".*" + timePattern + ".*");
        }
















        public String getTemperature() {
            return temperature;
        }

        public void setTemperature(String temperature) {
            this.temperature = temperature;
        }

        public String getAppliance() {
            return appliance;
        }

        public void setAppliance(String appliance) {
            this.appliance = appliance;
        }
        @JsonProperty("display_text")
        private String displayText;
        @JsonProperty("start_time")
        private Integer startTime;
        @JsonProperty("end_time")
        private Integer endTime;
        private String temperature;
        private String appliance;

        // ... Getters and setters for these additional fields
    }
    @JsonIgnoreProperties(ignoreUnknown = true)

    public static class Nutrition {
        private Integer calories;

        public Integer getCalories() {
            return calories;
        }

        public void setCalories(Integer calories) {
            this.calories = calories;
        }

        public Integer getCarbohydrates() {
            return carbohydrates;
        }

        public void setCarbohydrates(Integer carbohydrates) {
            this.carbohydrates = carbohydrates;
        }

        public Integer getFat() {
            return fat;
        }

        public void setFat(Integer fat) {
            this.fat = fat;
        }

        public Integer getProtein() {
            return protein;
        }

        public void setProtein(Integer protein) {
            this.protein = protein;
        }

        public Integer getSugar() {
            return sugar;
        }

        public void setSugar(Integer sugar) {
            this.sugar = sugar;
        }

        public Integer getFiber() {
            return fiber;
        }

        public void setFiber(Integer fiber) {
            this.fiber = fiber;
        }

        private Integer carbohydrates;
        private Integer fat;
        private Integer protein;
        private Integer sugar;
        private Integer fiber;

        // ... Getters and setters for these fields
    }

}
