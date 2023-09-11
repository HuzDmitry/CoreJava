package org.exa.lesson3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class EmployeeGroup {
   private List<Employee> group;


    public EmployeeGroup(int freelancer, int worcker) {
        group = new ArrayList<Employee>();
        if (freelancer > 0){
            for (int i=0; i<freelancer; i++){
                group.add(Freelancer.getInstance());
            }
        }
        if (worcker>0){
            for (int i=0; i<freelancer; i++){
                group.add(Worker.getInstance());
            }
        }
    }
    public void getEmployee(){
        for (Employee employee: group) {
            System.out.println(employee);

        }
    }
    public void getSalary(){
        for (Employee employee: group) {
            System.out.printf("Среднемесячная зарплата %s %s = %s (руб.)",
                    employee.surName, employee.name, employee.calculateSalary());
            System.out.println();
        }
    }

    public void sortEmployee(Comparator<Employee> sort){
        Collections.sort(group, sort);
    }

}
