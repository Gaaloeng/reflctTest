package com.gaaloeng;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDate {


    static public List<Employee> getEmployeeDate(){
        List<Employee> employeeArrayList = new ArrayList<Employee>();
        employeeArrayList.add(new Employee("小紅",16,1000,"男"));
        employeeArrayList.add(new Employee("小藍",17,10000,"男"));
        employeeArrayList.add(new Employee("小绿",19,9000,"女"));
        employeeArrayList.add(new Employee("小黄",20,450,"女"));
        employeeArrayList.add(new Employee("小紫",35,6500,"男"));
        employeeArrayList.add(new Employee("小橙",30,450,"女"));

        return employeeArrayList;
    }

}
