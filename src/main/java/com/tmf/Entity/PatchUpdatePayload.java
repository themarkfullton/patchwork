package com.tmf.Entity;

import org.springframework.data.annotation.Id;

public class PatchUpdatePayload {
    private String creator;
    private String name;
    private String pattern;
    private String fabric;
    private String temperment;

    public String getCreator() {
        return creator;
    }

    public String getName() {
        return name;
    }

    public String getPattern() {
        return pattern;
    }

    public String getFabric() {
        return fabric;
    }

    public String getTemperment() {
        return temperment;
    }

}

