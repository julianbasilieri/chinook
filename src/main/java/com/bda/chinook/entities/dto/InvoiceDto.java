package com.bda.chinook.entities.dto;

import com.bda.chinook.entities.Customer;
import com.bda.chinook.entities.InvoiceItems;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceDto {
    private int InvoiceId;
    private int CustomerId;
    private Date InvoiceDate;
    private String BillingAddress;
    private String BillingCity;
    private String BillingState;
    private String BillingCountry;
    private String BillingPostalCode;
    private float Total;
    private List<InvoiceItems> invoiceItems;
}
