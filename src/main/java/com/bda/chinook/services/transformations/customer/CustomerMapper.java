package com.bda.chinook.services.transformations.customer;

import com.bda.chinook.entities.Customer;
import com.bda.chinook.entities.dto.CustomerDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
@Service
public class CustomerMapper implements Function<CustomerDto, Customer> {
    @Override
    public Customer apply(CustomerDto customerDto) {
        return new Customer(customerDto.getCustomerId(),
                customerDto.getFirstName(),
                customerDto.getLastName(),
                customerDto.getCompany(),
                customerDto.getAddress(),
                customerDto.getCity(),
                customerDto.getState(),
                customerDto.getCountry(),
                customerDto.getPostalCode(),
                customerDto.getPhone(),
                customerDto.getFax(),
                customerDto.getEmail(),
                customerDto.getSupportRepId(),
                new ArrayList<>());
    }
}
