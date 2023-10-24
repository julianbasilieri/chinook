package com.bda.chinook.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "customers")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(generator = "customers")
    @TableGenerator(name = "customers", table = "sqlite_sequence",
    pkColumnName = "name", valueColumnName = "seq", pkColumnValue = "customer_id")
    @Column(name = "CustomerId")
    private int CustomerId;
    private String FirstName;
    private String LastName;
    private String Company;
    private String Address;
    private String City;
    private String State;
    private String Country;
    private String PostalCode;
    private String Phone;
    private String Fax;
    private String Email;
    private int SupportRepId;
    @OneToMany(mappedBy = "customer", fetch = FetchType.EAGER)
    private List<Invoice> invoices;
}
