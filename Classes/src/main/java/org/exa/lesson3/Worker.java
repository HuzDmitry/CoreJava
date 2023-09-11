package org.exa.lesson3;

import java.util.ArrayList;
import java.util.List;

public class Worker extends Employee{

    @Override
    public void setSalary(double salary) {
        if (salary < 30000){
            throw new RuntimeException("Уровень заработной платы за месяц должен быть не менее 30000");
        }
        this.salary = salary;
    }

    private Worker(String surName, String name, double salary){
        super(surName, name, salary);
        //System.out.println("Constructor - Worker");
    }

    public static Employee getInstance(){
        return new Worker(
                surNames[random.nextInt(surNames.length)],
                names[random.nextInt(surNames.length)],
                random.nextInt(30000, 250000));
    }

//    public static List<Employee> getEmployees(int count){
//        List<Employee> employees = new ArrayList<>();
//        for (int i = 0; i < count; i++)
//            employees.add(getInstance());
//        return employees;
//    }

    @Override
    public double calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%s %s; Рабочий; (фиксированная месячная оплата): %.2f (руб.)",
                surName, name, salary);
    }
}
