package com.gaaloeng.myclass;


public class Person extends Creature<String> {
    public String name;
    protected int height;
    private int age;
    private int weight;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    @MyAnnotation
    public int getAge() {
        return age;
    }
    @MyAnnotation
    public void setAge(int age) {
        this.age = age;
    }

    public Person() {
    }

    public Person(String name, int height, int age) {
        this.name = name;
        this.height = height;
        this.age = age;
    }

    protected Person(int height, int age) {
        this.height = height;
        this.age = age;
    }

    private Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private int getWeight() {
        return weight;
    }

    private String show(int age){
        return "年龄："+age;
    }
}

