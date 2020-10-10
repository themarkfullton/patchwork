package com.tmf.Models;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Patch")

public class Patch {
    @Id
    private Integer id;
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
    private Integer ptVoid;
    private Integer ptBlood;
    private Integer ptBlight;
    private Integer ptSpirit;
    private Integer ptWill;
    private Integer ptEnigma;
    private Integer ptPassion;

    public Integer getId() {
        return id;
    }

    public Integer getOwner() {
        return owner;
    }

    public void setOwner(Integer owner) {
        this.owner = owner;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getStage() {
        return stage;
    }

    public void setStage(Integer stage) {
        this.stage = stage;
    }

    public String getPersonality() {
        return personality;
    }

    public void setPersonality(String personality) {
        this.personality = personality;
    }

    public Integer getHunger() {
        return hunger;
    }

    public void setHunger(Integer hunger) {
        this.hunger = hunger;
    }

    public Integer getHappiness() {
        return happiness;
    }

    public void setHappiness(Integer happiness) {
        this.happiness = happiness;
    }

    public Boolean getHealthy() {
        return isHealthy;
    }

    public void setHealthy(Boolean healthy) {
        isHealthy = healthy;
    }

    public Integer getStrength() {
        return strength;
    }

    public void setStrength(Integer strength) {
        this.strength = strength;
    }

    public Integer getDefense() {
        return defense;
    }

    public void setDefense(Integer defense) {
        this.defense = defense;
    }

    public Integer getAgility() {
        return agility;
    }

    public void setAgility(Integer agility) {
        this.agility = agility;
    }

    public Integer getHp() {
        return hp;
    }

    public void setHp(Integer hp) {
        this.hp = hp;
    }

    public Integer getWp() {
        return wp;
    }

    public void setWp(Integer wp) {
        this.wp = wp;
    }

    public Integer getPtVoid() {
        return ptVoid;
    }

    public void setPtVoid(Integer ptVoid) {
        this.ptVoid = ptVoid;
    }

    public Integer getPtBlood() {
        return ptBlood;
    }

    public void setPtBlood(Integer ptBlood) {
        this.ptBlood = ptBlood;
    }

    public Integer getPtBlight() {
        return ptBlight;
    }

    public void setPtBlight(Integer ptBlight) {
        this.ptBlight = ptBlight;
    }

    public Integer getPtSpirit() {
        return ptSpirit;
    }

    public void setPtSpirit(Integer ptSpirit) {
        this.ptSpirit = ptSpirit;
    }

    public Integer getPtWill() {
        return ptWill;
    }

    public void setPtWill(Integer ptWill) {
        this.ptWill = ptWill;
    }

    public Integer getPtEnigma() {
        return ptEnigma;
    }

    public void setPtEnigma(Integer ptEnigma) {
        this.ptEnigma = ptEnigma;
    }

    public Integer getPtPassion() {
        return ptPassion;
    }

    public void setPtPassion(Integer ptPassion) {
        this.ptPassion = ptPassion;
    }
}