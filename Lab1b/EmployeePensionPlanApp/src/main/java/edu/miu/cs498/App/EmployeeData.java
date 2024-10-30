package edu.miu.cs498.App;

import edu.miu.cs498.model.Employee;
import edu.miu.cs498.model.PensionPlan;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EmployeeData {

    public static List<Employee> initializeEmployees() {
        List<Employee> employees = new ArrayList<>();

        employees.add(new Employee(
                1,
                "Daniel",
                "Agar",
                LocalDate.parse("2018-01-17"),
                105945.50,
                new PensionPlan("EX1089", LocalDate.parse("2023-01-17"), 100.00)
        ));

        employees.add(new Employee(
                2,
                "Benard",
                "Shaw",
                //LocalDate.parse("2019-04-03"),
                LocalDate.parse("2019-11-01"),
                197750.00,
                null
        ));

        employees.add(new Employee(
                3,
                "Carly",
                "Agar",
                LocalDate.parse("2014-05-16"),
                842000.75,
                new PensionPlan("SM2307", LocalDate.parse("2019-11-04"), 1555.50)
        ));

        employees.add(new Employee(
                4,
                "Wesley",
                "Schneider",
                LocalDate.parse("2019-09-02"),
                74500.00,
                null
        ));



        return employees;
    }

}
