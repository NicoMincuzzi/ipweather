package com.nmincuzzi.ipweather.java.model;

public class LocaleModel {

    private String id;
    private String name;

    public LocaleModel() {
    }

    public LocaleModel(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
