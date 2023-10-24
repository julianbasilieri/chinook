package com.bda.chinook.services.transformations.invoice;

import com.bda.chinook.entities.Invoice;
import com.bda.chinook.entities.dto.InvoiceDto;
import com.bda.chinook.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.function.Function;
@Service
public class InvoiceMapper implements Function<InvoiceDto, Invoice> {
    private final CustomerRepository customerRepository;

    public InvoiceMapper(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Invoice apply(InvoiceDto invoiceDto) {
        return new Invoice(invoiceDto.getInvoiceId(),
                customerRepository.getReferenceById(invoiceDto.getCustomerId()),
                invoiceDto.getInvoiceDate(),
                invoiceDto.getBillingAddress(),
                invoiceDto.getBillingCity(),
                invoiceDto.getBillingState(),
                invoiceDto.getBillingCountry(),
                invoiceDto.getBillingPostalCode(),
                invoiceDto.getTotal(),
                new ArrayList<>());
    }
}
