package org.exa.lesson3;

import java.util.Collections;
import java.util.List;

public class Program {

    public static void main(String[] args) {
        EmployeeGroup employeeGroup = new EmployeeGroup(10, 10);
        employeeGroup.getEmployee();
        employeeGroup.sortEmployee(new EmployeeNameComparator());
        employeeGroup.getEmployee();
        employeeGroup.sortEmployee(new EmployeeSalaryComparator());
        employeeGroup.getEmployee();
        employeeGroup.getSalary();

//        List<Employee> employeesWorcker = Worker.getEmployees(15);
//        List<Employee> employeesFreelancer = Freelancer.getEmployees(15);

//        for (Employee employee: employeesWorcker) {
//            System.out.println(employee);
//            System.out.printf("Среднемесячная зарплата рабочего = %s (руб.)",employee.calculateSalary());
//            System.out.println();
//        }
//        for (Employee employee: employeesFreelancer) {
//            System.out.println(employee);
//            System.out.printf("Среднемесячная зарплата рабочего = %s (руб.)",employee.calculateSalary());
//            System.out.println();
//        }

//        Collections.sort(employeesWorcker, new EmployeeNameComparator());
//        Collections.sort(employeesFreelancer, new EmployeeNameComparator());
//        System.out.println();
//
//        for (Employee employee: employeesWorcker) {
//            System.out.println(employee);
//        }
//        for (Employee employee: employeesFreelancer) {
//            System.out.println(employee);
//        }

    }

}
