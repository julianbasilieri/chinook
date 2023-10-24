package com.bda.chinook.services;

import com.bda.chinook.entities.Customer;
import com.bda.chinook.entities.dto.CustomerDto;
import com.bda.chinook.repositories.CustomerRepository;
import com.bda.chinook.services.transformations.customer.CustomerDtoMapper;
import com.bda.chinook.services.transformations.customer.CustomerMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class CustomerServiceImpl implements CustomerService {
    public final CustomerRepository customerRepository;
    public final CustomerDtoMapper customerDtoMapper;
    public final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerDtoMapper customerDtoMapper, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerDtoMapper = customerDtoMapper;
        this.customerMapper = customerMapper;
    }

    @Override
    public void add(CustomerDto entity) {
        Customer customer = Optional.of(entity).map(customerMapper).orElseThrow();
        customerRepository.save(customer);
    }

    @Override
    public CustomerDto delete(Integer id) {
        Optional<Customer> optionalCustomer = customerRepository.findById(id);
        optionalCustomer.ifPresent(customerRepository::delete);
        return optionalCustomer
                .map(customerDtoMapper)
                .orElseThrow();
    }

    @Override
    public void update(CustomerDto entity) {
        Optional<Customer> optionalCustomer = Stream.of(entity).map(customerMapper).findFirst();
        optionalCustomer.ifPresent(customerRepository::save);
    }

    @Override
    public List<CustomerDto> getAll() {
        List<Customer> values = customerRepository.findAll();
        return values
                .stream()
                .map(customerDtoMapper)
                .toList();
    }

    @Override
    public CustomerDto getById(Integer id) {
        Optional<Customer> value = customerRepository.findById(id);
        return value
                .map(customerDtoMapper)
                .orElseThrow();
    }
}
