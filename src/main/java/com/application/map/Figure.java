package com.application.map;

public class Figure {

    private String name;

    public Figure() {
    }

    public Figure(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Figure{" +
                "name='" + name + '\'' +
                '}';
    }
}
