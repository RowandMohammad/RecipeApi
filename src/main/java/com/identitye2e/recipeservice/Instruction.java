package com.identitye2e.recipeservice;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

public class Instruction {
    @JsonProperty("display_text")
    public String displayText;

    @JsonProperty("start_time")
    public int startTime;

    @JsonProperty("end_time")
    public int endTime;

    public String getDisplayText() {
        return displayText;
    }

    public void setDisplayText(String displayText) {
        this.displayText = displayText;
    }

    public int getStartTime() {
        return startTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public boolean shouldDisplayDuration() {
        return startTime != 0 && endTime != 0;
    }

    public int getDurationInMinutes() {
        return Math.round((float)(endTime - startTime) / 6000);
    }


    @Override
    public String toString() {
        return "Instruction{" +
                "displayText='" + displayText + '\'' +
                ", startTime=" + startTime +
                ", endTime=" + endTime +
                '}';
    }

}
