package com.gaaloeng.myclass;

public class Creature<T>  {
    private String name;
    protected String type;
    public int weight;


    public Creature() {
    }

    public Creature(String name, String type, int weight) {
        this.name = name;
        this.type = type;
        this.weight = weight;
    }
}
