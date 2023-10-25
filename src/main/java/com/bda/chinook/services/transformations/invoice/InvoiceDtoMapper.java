package com.bda.chinook.services.transformations.invoice;

import com.bda.chinook.entities.Invoice;
import com.bda.chinook.entities.dto.InvoiceDto;
import com.bda.chinook.repositories.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class InvoiceDtoMapper implements Function<Invoice, InvoiceDto> {
    @Override
    public InvoiceDto apply(Invoice invoice) {
        return new InvoiceDto(invoice.getInvoiceId(),
                invoice.getCustomer().getCustomerId(),
                invoice.getInvoiceDate(),
                invoice.getBillingAddress(),
                invoice.getBillingCity(),
                invoice.getBillingState(),
                invoice.getBillingCountry(),
                invoice.getBillingPostalCode(),
                invoice.getTotal(),
                invoice.getInvoiceItems());
    }
}
