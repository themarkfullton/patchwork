package com.tmf.Models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import org.bson.types.ObjectId;

import java.util.Date;
import java.util.List;
import java.util.Objects;

@JsonInclude(Include.NON_NULL)
public class Patch {
    @JsonSerialize(using = ToStringSerializer.class)

    private ObjectId id;
    private String creator;
    private String name;
    private String pattern;
    private String texture;
    private String temperment;
    private Date creationDay = new Date();

    public ObjectId getId() {
        return id;
    }

    public Patch setId(ObjectId id) {
        this.id = id;
        return this;
    }

    public String getCreator() {
        return creator;
    }

    public Patch setCreator(String creator) {
        this.creator = creator;
        return this;
    }

    public String getName() {
        return name;
    }

    public Patch setName(String name) {
        this.name = name;
        return this;
    }

    public String getPattern() {
        return pattern;
    }

    public Patch setPattern(String pattern) {
        this.pattern = pattern;
        return this;
    }

    public String getTexture() {
        return texture;
    }

    public Patch setTexture(String texture) {
        this.texture = texture;
        return this;
    }

    public String getTemperment() {
        return temperment;
    }

    public Patch setTemperment(String temperment){
        this.temperment = temperment;
        return this;
    }

    public Date getCreationDay(){
        return creationDay;
    }

    public Patch setCreationDay(Date creationDay) {
        this.creationDay = creationDay;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o){
            return true;
        }
        if (o == null || getClass() != o.getClass()){
            return false;
        }

        Patch patch = (Patch) o;

        return Objects.equals(id, patch.id) && Objects.equals(creator, patch.creator)
                && Objects.equals(name, patch.name) && Objects.equals(pattern, patch.pattern)
                && Objects.equals(texture, patch.texture) && Objects.equals(temperment, patch.temperment)
                && creationDay == patch.creationDay;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, creator, name, pattern, texture, temperment, creationDay);
    }
}


