package com.zarko.TrackZilla.entity;

import javax.persistence.*;

@Entity
public class Release {

    private Integer id;
    private String releaseDate;
    private String description;

    public Release(){
    }

    public Release(Integer id, String description, String releaseDate){
        this.id = id;
        this.description = description;
        this.releaseDate = releaseDate;
    }

    public  Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }
}
