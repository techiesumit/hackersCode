package com.sumit.lambda.frill.samples.util.Mocks;

import com.sumit.lambda.frill.samples.model.Departments;
import com.sumit.lambda.frill.samples.model.Employee;

import java.util.Arrays;
import java.util.List;

public class EmployeeDataFeeder {
    public static List<Employee> getEmployeees() {
        Employee e13 = new Employee(13, 15, "F", "Neetu", "Singh", 4328.15, Departments.HR);
        Employee e14 = new Employee(14, 45, "O", "Naveen", "Jain", 7533.52, Departments.Marketing);
        Employee e1 = new Employee(1, 23, "M", "Rick", "Beethovan", 6100.00, Departments.HR);
        Employee e2 = new Employee(2, 33, "F", "Martina", "Hengis", 2050.52, Departments.Technology);
        Employee e3 = new Employee(3, 43, "M", "Ricky", "Martin", 14523.23, Departments.Technology);
        Employee e4 = new Employee(4, 26, "M", "Jon", "Lowman", 9709.00, Departments.Operations);
        Employee e5 = new Employee(5, 19, "F", "Cristine", "Maria", 9123.23, Departments.Technology);
        Employee e6 = new Employee(6, 15, "M", "David", "Feezor", 10258.33, Departments.Sales);
        Employee e7 = new Employee(7, 68, "O", "Melissa", "Roy", 7613.25, Departments.Technology);
        Employee e8 = new Employee(8, 79, "M", "Alex", "Gussin", 95321.00, Departments.Sales);
        Employee e9 = new Employee(9, 15, "F", "Neetu", "Singh", 5732.12, Departments.Marketing);
        Employee e10 = new Employee(10, 45, "M", "Naveen", "Jain", 76512.23, Departments.Technology);
        Employee e11 = new Employee(11, 68, "O", "Melissa", "Roy", 5764.99, Departments.Operations);
        Employee e12 = new Employee(12, 79, "O", "Alex", "Gussin", 4322.11, Departments.Technology);

       return (Arrays.asList(new Employee[]{e1, e2,e12, e13, e14, e3, e4, e5, e6, e7, e8, e9, e10, e11}));
    }

}
