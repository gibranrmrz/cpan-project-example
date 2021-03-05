package com.ramirez.model;

public abstract class Witcher {
    private String name;
    private String city;
    private School school;

    public enum School {
        CAT, WOLF, BEAR
    }

    public Witcher(String name, String city, School school) {
        this.name = name;
        this.city = city;
        this.school = school;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }
}
