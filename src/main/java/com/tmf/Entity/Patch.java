package com.tmf.Entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Patch")

public class Patch {
    @Id
    private Integer id;

    private String creator;
    private String name;
    private String pattern;
    private String fabric;
    private String temperment;

    public Integer getId() {
        return id;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getFabric() {
        return fabric;
    }

    public void setFabric(String fabric) {
        this.fabric = fabric;
    }

    public String getTemperment() {
        return temperment;
    }

    public void setTemperment(String temperment) {
        this.temperment = temperment;
    }

}


