package com.bda.chinook.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "invoices")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableGenerator(name = "invoices", table = "sqlite_sequence",
    pkColumnName = "name", valueColumnName = "seq", pkColumnValue = "invoice_id")
    private int InvoiceId;
    @ManyToOne
    @JoinColumn(name = "CustomerId")
    @JsonIgnore
    private Customer customer;
    private Date InvoiceDate;
    private String BillingAddress;
    private String BillingCity;
    private String BillingState;
    private String BillingCountry;
    private String BillingPostalCode;
    private float Total;
    @OneToMany(mappedBy = "invoice")
    private List<InvoiceItems> invoiceItems;
}
