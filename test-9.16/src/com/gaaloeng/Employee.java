package com.gaaloeng;

public class Employee {
    public String name;
    public int age;
    public int salary;
    public String sex;
    public int id;

    static String AAAAAAAAAA = "aa";

    public Employee(String name, int age, int salary, String sex, int id) {
        this.name = name;
        String aa = AAAAAAAAAA;
        this.age = age;
        this.salary = salary;
        this.sex = sex;
        this.id = id;
    }

    public Employee(String name, int age, int salary, String sex) {
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.sex = sex;
    }

    public Employee() {
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", sex='" + sex + '\'' +
                ", id=" + id +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}
