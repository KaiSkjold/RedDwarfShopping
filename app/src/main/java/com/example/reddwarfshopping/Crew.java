package com.example.reddwarfshopping;

public class Crew {
    public String name;
    public String nickName;
    public String job;
    public String species;
    public String quote;
    public String placeOfOrigin;
    public String portrait;

    public Crew(String name, String nickName, String job, String race, String quote, String placeOfOrigin, String portrait) {
        this.name = name;
        this.nickName = nickName;
        this.job = job;
        this.species = race;
        this.quote = quote;
        this.placeOfOrigin = placeOfOrigin;
        this.portrait = portrait;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getPlaceOfOrigin() {
        return placeOfOrigin;
    }

    public void setPlaceOfOrigin(String placeOfOrigin) {
        this.placeOfOrigin = placeOfOrigin;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }
}
