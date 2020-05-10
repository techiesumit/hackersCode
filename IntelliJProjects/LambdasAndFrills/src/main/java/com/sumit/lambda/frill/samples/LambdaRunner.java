package com.sumit.lambda.frill.samples;

import com.sumit.lambda.frill.samples.model.Employee;
import com.sumit.lambda.frill.samples.predicate.PredicateCollections;
import com.sumit.lambda.frill.samples.stream.operations.StreamOperations;
import com.sumit.lambda.frill.samples.util.Mocks.EmployeeDataFeeder;

import java.util.function.Predicate;

public class LambdaRunner {
    public static void main(String[] args) {
        EmployeePredicateRunner employeePredicateRunner = new EmployeePredicateRunner(EmployeeDataFeeder.getEmployeees());
        employeePredicateRunner.filterEmployees(PredicateCollections.isAdultFemale());
        System.out.println("\n");
        employeePredicateRunner.filterEmployeesMultipleConditions(PredicateCollections.isAdultFemale(),
                PredicateCollections.salaryGreaterinParam(5000.00));
        Predicate<Employee> multiPredicate = PredicateCollections.multiPredicate(PredicateCollections.isAdultFemale(),
                PredicateCollections.salaryGreaterinParam(5000.00));
       //employeePredicateRunner.findAnyMatch();
        // Distinct Operation
        StreamOperations streamOperations = new StreamOperations();
        streamOperations.printDistinctEmployeeName(EmployeeDataFeeder.getEmployeees());
    }
}
