package edu.miu.cs498.employeemanagementapp.service;

import edu.miu.cs498.employeemanagementapp.model.Employee;
import edu.miu.cs498.employeemanagementapp.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService{

    public final EmployeeRepository employeeRepository;
    @Override
    public Optional<Employee> addEmployee(Employee emp) {
        return Optional.of(employeeRepository.save(emp));
    }

    @Override
    public List<Employee> findAllOrderBySalaryAscLastNameDesc() {
        return employeeRepository.findAllByOrderBySalaryAscLastNameDesc();
    }


}
