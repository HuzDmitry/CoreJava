package org.exa.lesson3;


import java.util.ArrayList;
import java.util.List;

public class Freelancer extends Employee{
    @Override
    public void setSalary(double salary) {
        if (salary < 500){
            throw new RuntimeException("Уровень заработной платы за час должен быть не менее 500");
        }
        this.salary = salary;
    }

    public Freelancer(String surName, String name, double salary){
        super(surName, name, salary);
    }
    @Override
    public double calculateSalary() {
        double result;
        return result = 20.8 * 8 * salary;
    }
    public static Employee getInstance(){
        return new Freelancer(
                surNames[random.nextInt(surNames.length)],
                names[random.nextInt(surNames.length)],
                random.nextInt(500, 3000));
    }
//    public static List<Employee> getEmployees(int count){
//        List<Employee> employees = new ArrayList<>();
//        for (int i = 0; i < count; i++)
//            employees.add(getInstance());
//        return employees;
//    }
    @Override
    public String toString() {
        return String.format("%s %s; Рабочий; (почасовая оплата): %.2f (руб.)",
                surName, name, salary);
    }
}
