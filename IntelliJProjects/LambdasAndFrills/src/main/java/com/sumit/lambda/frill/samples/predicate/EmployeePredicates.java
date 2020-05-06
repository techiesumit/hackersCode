package com.sumit.lambda.frill.samples.predicate;

import com.sumit.lambda.frill.samples.model.Employee;

import java.util.function.Predicate;

import static com.sumit.lambda.frill.samples.predicate.EmployeeConstant.ADULT_FEMALE_AGE;
import static com.sumit.lambda.frill.samples.predicate.EmployeeConstant.ADULT_MALE_AGE;

public class EmployeePredicates {


    public static Predicate<Employee> isAdultMale() {
        return p -> p.getAge() > ADULT_MALE_AGE && p.getGender().equalsIgnoreCase("M");
    }

    public static Predicate<Employee> isAdultFemale() {
        return p -> p.getAge() > ADULT_FEMALE_AGE && p.getGender().equalsIgnoreCase("F");
    }

    public static Predicate<Employee> isAgeMoreThan(Integer age) {
        return p -> p.getAge() > age;
    }

    public static Predicate<Employee> salaryGreaterinParam(double salary) {
        return p -> p.getSalary() > salary;
    }


}
