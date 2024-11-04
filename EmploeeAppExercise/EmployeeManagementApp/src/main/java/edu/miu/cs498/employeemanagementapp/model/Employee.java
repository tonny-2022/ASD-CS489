package edu.miu.cs498.employeemanagementapp.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Employee {

    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Id
    private  Integer Id;
    private String FirstName;
    private  String LastName;
    private float Salary;

    public Employee(String firstName, String lastName, float salary) {
        FirstName = firstName;
        LastName = lastName;
        Salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "FirstName='" + FirstName + '\'' +
                ", LastName='" + LastName + '\'' +
                ", Salary=" + Salary +
                '}';
    }
}
