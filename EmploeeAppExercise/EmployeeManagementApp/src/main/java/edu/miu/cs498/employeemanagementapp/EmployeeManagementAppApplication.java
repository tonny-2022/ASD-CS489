package edu.miu.cs498.employeemanagementapp;

import edu.miu.cs498.employeemanagementapp.model.Employee;
import edu.miu.cs498.employeemanagementapp.service.EmployeeService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@RequiredArgsConstructor
public class EmployeeManagementAppApplication  implements CommandLineRunner {

    final EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(EmployeeManagementAppApplication.class, args);


    }

    @Override
    public void run(String... args) throws Exception {


        Employee emp1=new Employee("John","Doe",50000);
        Employee emp2=new Employee("Jane","Dona",50000);
        Employee emp3=new Employee("Alice","Smith",60000);
        Employee emp4=new Employee("Bob","Brown",450000);
        employeeService.addEmployee(emp1);
        employeeService.addEmployee(emp2);
        employeeService.addEmployee(emp3);
        employeeService.addEmployee(emp4);

        //Get employees by or

        List<Employee> employees= employeeService.findAllOrderBySalaryAscLastNameDesc();
        for(Employee emp :employees){

            System.out.println("FirstName:"+emp.getFirstName()+" Last Name: "+emp.getLastName()+" Salary: "+emp.getSalary());

        }


    }
}
