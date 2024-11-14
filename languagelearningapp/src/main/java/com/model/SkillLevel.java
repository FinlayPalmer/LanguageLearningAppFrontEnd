package com.model;
public enum SkillLevel {
    EASY("Current Skill Level: Easy"),
    MEDIUM("Current Skill Level: Medium"),
    DIFFICULT("Current Skill Level: Difficult");

    public final String label;

    private SkillLevel(String label) {
        this.label = label;
    }
}