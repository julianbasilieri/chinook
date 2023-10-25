package com.bda.chinook.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "employees")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableGenerator(name = "employees", table = "sqlite_sequence",
            pkColumnName = "name", valueColumnName = "seq", pkColumnValue = "employees_id")
    private int EmployeeId;
    private String LastName;
    private String FirstName;
    private String Title;
    @ManyToOne
    @JoinColumn(name = "ReportsTo")
    private Employee employee;
    private Date BirthDate;
    private Date HireDate;
    private String Address;
    private String City;
    private String State;
    private String Country;
    private String PostalCode;
    private String Phone;
    private String Fax;
    private String Email;
    @OneToMany(mappedBy = "employee")
    private List<Customer> customers;
}
