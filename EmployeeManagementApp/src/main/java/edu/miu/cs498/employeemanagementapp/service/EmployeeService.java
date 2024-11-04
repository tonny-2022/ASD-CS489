package edu.miu.cs498.employeemanagementapp.service;

import edu.miu.cs498.employeemanagementapp.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {

    public Optional<Employee> addEmployee(Employee emp);
    public List<Employee> findAllOrderBySalaryAscLastNameDesc();


}
