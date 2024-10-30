package edu.miu.cs498.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import edu.miu.cs498.model.Employee;



import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {

    private final List<Employee> employees;

    public EmployeeService(List<Employee> employees) {
        this.employees = employees;
    }

    //listing  all employees in JSON format
    public void listAllEmployees() {
        employees.sort(Comparator.comparing(Employee::getLastName)
                .thenComparing(Comparator.comparing(Employee::getYearlySalary).reversed()));


        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());

        try {
            String jsonResult = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(employees);
            System.out.println(jsonResult);
        } catch (Exception e) {
            System.out.println("Error converting to JSON: " + e.getMessage());
        }
    }
    public void listMonthlyUpcomingEnrollees() {
        LocalDate startOfNextMonth = YearMonth.now().plusMonths(1).atDay(1);
        LocalDate endOfNextMonth = YearMonth.now().plusMonths(1).atEndOfMonth();

        List<Employee> upcomingEnrollees = employees.stream()
                .filter(emp -> emp.getPensionPlan() == null &&
                        (emp.getEmploymentDate().plusYears(5).isEqual(startOfNextMonth) ||
                                emp.getEmploymentDate().plusYears(5).isEqual(endOfNextMonth) ||
                                (emp.getEmploymentDate().plusYears(5).isAfter(startOfNextMonth) &&
                                        emp.getEmploymentDate().plusYears(5).isBefore(endOfNextMonth))))
                .sorted(Comparator.comparing(Employee::getEmploymentDate))
                .collect(Collectors.toList());

        // Initializing ObjectMapper and register JavaTimeModule for LocalDate support
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule()); // Registering JavaTimeModule to handle LocalDate

        try {
            String jsonResult = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(upcomingEnrollees);
            System.out.println(jsonResult);
        } catch (Exception e) {
            System.out.println("Error converting to JSON: " + e.getMessage());
        }
    }
}
