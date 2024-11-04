package edu.miu.cs498.employeemanagementapp.repository;

import edu.miu.cs498.employeemanagementapp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository

public interface EmployeeRepository  extends JpaRepository<Employee, Integer> {
    public List<Employee> findAllByOrderBySalaryAscLastNameDesc();



}
