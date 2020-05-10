package com.sumit.lambda.frill.samples.predicate;

import com.sumit.lambda.frill.samples.model.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.function.Predicate;

import static com.sumit.lambda.frill.samples.predicate.EmployeeConstant.ADULT_FEMALE_AGE;
import static com.sumit.lambda.frill.samples.predicate.EmployeeConstant.ADULT_MALE_AGE;

public class PredicateCollections {
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

    public static <T> Predicate<T> distinctByKey(Function<? super T, Object> keyExtractor)
    {
        Map<Object, Boolean> map = new ConcurrentHashMap<>();
        return t -> map.putIfAbsent(keyExtractor.apply(t), Boolean.TRUE) == null;
    }

    // Need to discuss this approach
    // Create multiple Predicates
    public static <T> Predicate<T> multiPredicate(Predicate<T>... predicates) {
        return Arrays.stream(predicates)
                .reduce(Predicate::or)
                .orElse(x->false);
    }


}
