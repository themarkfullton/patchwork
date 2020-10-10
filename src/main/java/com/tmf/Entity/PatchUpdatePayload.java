package com.tmf.Entity;

public class PatchUpdatePayload {
    private Integer owner;
    private String type;
    private String pattern;
    private Integer level;
    private Integer stage;
    private String personality;
    private Integer hunger;
    private Integer happiness;
    private Boolean isHealthy;
    private Integer strength;
    private Integer defense;
    private Integer agility;
    private Integer hp;
    private Integer wp;

    public Integer getOwner() {
        return owner;
    }

    public String getType() {
        return type;
    }

    public String getPattern() {
        return pattern;
    }

    public Integer getLevel() {
        return level;
    }

    public Integer getStage() {
        return stage;
    }

    public String getPersonality() {
        return personality;
    }

    public Integer getHunger() {
        return hunger;
    }

    public Integer getHappiness() {
        return happiness;
    }

    public Boolean getHealthy() {
        return isHealthy;
    }

    public Integer getStrength() {
        return strength;
    }

    public Integer getDefense() {
        return defense;
    }

    public Integer getAgility() {
        return agility;
    }

    public Integer getHp() {
        return hp;
    }

    public Integer getWp() {
        return wp;
    }
}
