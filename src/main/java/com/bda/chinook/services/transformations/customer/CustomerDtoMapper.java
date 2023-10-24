package com.bda.chinook.services.transformations.customer;

import com.bda.chinook.entities.Customer;
import com.bda.chinook.entities.dto.CustomerDto;
import com.bda.chinook.entities.dto.InvoiceDto;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;
import java.util.function.Function;
@Service
public class CustomerDtoMapper implements Function<Customer, CustomerDto> {
    @Override
    public CustomerDto apply(Customer customer) {
        return new CustomerDto(customer.getCustomerId(),
                customer.getFirstName(),
                customer.getLastName(),
                customer.getCompany(),
                customer.getAddress(),
                customer.getCity(),
                customer.getState(),
                customer.getCountry(),
                customer.getPostalCode(),
                customer.getPhone(),
                customer.getFax(),
                customer.getEmail(),
                customer.getSupportRepId());

    }
}
