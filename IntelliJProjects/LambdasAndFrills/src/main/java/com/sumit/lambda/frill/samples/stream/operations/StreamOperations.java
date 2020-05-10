package com.sumit.lambda.frill.samples.stream.operations;

import com.sumit.lambda.frill.samples.model.Employee;
import com.sumit.lambda.frill.samples.predicate.PredicateCollections;

import java.util.List;
import java.util.stream.Collectors;

public class StreamOperations {
    public void printDistinctEmployeeName(List<Employee> employees){
        // How to pass the dynamic parameter for search As ther are String , double and Interger?? Is there a Generic premetive  type
        List<Employee> list = employees.stream()
                .filter(PredicateCollections.distinctByKey(Employee::getFirstName))
                .collect(Collectors.toList());
        System.out.println("\n  Distinct Employee by name \n");
        list.stream().forEach(System.out::println);
        //Although this is an example from Web and works but need to know the logic behind that.
    }

}


