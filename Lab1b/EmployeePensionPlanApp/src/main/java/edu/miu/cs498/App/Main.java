package edu.miu.cs498.App;

import edu.miu.cs498.model.Employee;
import edu.miu.cs498.service.EmployeeService;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees = EmployeeData.initializeEmployees();
        EmployeeService service = new EmployeeService(employees);

        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\nSelect an option:");
            System.out.println("1. List All Employees");
            System.out.println("2. Monthly Upcoming Enrollees Report");
            System.out.println("3. Exit");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1 -> service.listAllEmployees();
                case 2 -> service.listMonthlyUpcomingEnrollees();
                case 3 -> exit = true;
                default -> System.out.println("Invalid choice. Please try again.");
            }
        }

    }
}