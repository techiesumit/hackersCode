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
                .collect(Collectors.toList()); // Collecting the list of Items
        filterEmps.forEach(System.out::println); // Printing the list (How to combine the two stream operations ??)

        // Single Operation from the above.
        System.out.println("Single Operation Print");
      employees.stream()
                .filter(predicate)
               .forEach(e->System.out.println(e.toString()));

    }

    public void filterEmployeesMultipleConditions(Predicate<Employee> predicate1, Predicate<Employee> predicate2) {
        List<Employee> filterEmps = employees.stream()
                .filter(predicate1.or(predicate2)) // and and not are also available.
                .collect(Collectors.toList());
        filterEmps.stream().forEach(System.out::println);
    }

    // Pass Multiple Predicate using PredicateCollections multiPredicate
    public  <T> T findAnyMatch(Predicate<T> predicate) {
        T[] list = null;
        for (T element : list) {
            if (predicate.test(element)) {
                return element;
            }
        }
        return null;
    }
}
