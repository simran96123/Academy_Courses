package com.example.coching_classes;

public class Data {

    private String courses;
    private  String name;
    public Data(){


    }

    public Data(String courses, String name) {
        this.courses = courses;
        this.name = name;
    }

    public String getCourses() {
        return courses;
    }

    public void setCourses(String courses) {
        this.courses = courses;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
