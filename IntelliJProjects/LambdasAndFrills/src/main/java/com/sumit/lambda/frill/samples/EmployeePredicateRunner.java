package com.sumit.lambda.frill.samples;

import com.sumit.lambda.frill.samples.model.Employee;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class EmployeePredicateRunner {

    List<Employee> employees;

    public EmployeePredicateRunner(List employees) {
        this.employees = employees;
    }

    public void filterEmployees(Predicate<Employee> predicate) {
        List<Employee> filterEmps = employees.stream()
                .filter(predicate)
                .collect(Collectors.toList());
        filterEmps.stream().forEach(System.out::println);
    }
    public void filterEmployeesMultipleConditions(Predicate<Employee> predicate1, Predicate<Employee> predicate2) {
        List<Employee> filterEmps = employees.stream()
                .filter(predicate1.or(predicate2))
                .collect(Collectors.toList());
        filterEmps.stream().forEach(System.out::println);
    }


}
