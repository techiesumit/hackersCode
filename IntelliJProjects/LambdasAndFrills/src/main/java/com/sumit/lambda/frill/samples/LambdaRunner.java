package com.sumit.lambda.frill.samples;

import com.sumit.lambda.frill.samples.predicate.EmployeePredicates;
import com.sumit.lambda.frill.samples.util.Mocks.EmployeeDataFeeder;

public class LambdaRunner {
    public static void main(String[] args) {
        EmployeePredicateRunner employeePredicateRunner = new EmployeePredicateRunner(EmployeeDataFeeder.getEmployeees());
        employeePredicateRunner.filterEmployees(EmployeePredicates.isAdultFemale());
        System.out.println("\n");
        employeePredicateRunner.filterEmployeesMultipleConditions(EmployeePredicates.isAdultFemale(),
                EmployeePredicates.salaryGreaterinParam(5000.00));

    }
}
