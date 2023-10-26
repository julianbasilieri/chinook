package com.bda.chinook.services;

import com.bda.chinook.entities.Invoice;
import com.bda.chinook.entities.dto.InvoiceDto;
import com.bda.chinook.repositories.CustomerRepository;
import com.bda.chinook.repositories.InvoiceRepository;
import com.bda.chinook.services.transformations.invoice.InvoiceDtoMapper;
import com.bda.chinook.services.transformations.invoice.InvoiceMapper;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Service
public class InvoiceServiceImpl implements InvoiceService {
    private final InvoiceRepository invoiceRepository;
    private final CustomerRepository customerRepository;
    private final InvoiceDtoMapper invoiceDtoMapper;
    private final InvoiceMapper invoiceMapper;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, CustomerRepository customerRepository, InvoiceDtoMapper invoiceDtoMapper, InvoiceMapper invoiceMapper) {
        this.invoiceRepository = invoiceRepository;
        this.customerRepository = customerRepository;
        this.invoiceDtoMapper = invoiceDtoMapper;
        this.invoiceMapper = invoiceMapper;
    }

    @Override
    public void add(InvoiceDto entity) {
        Invoice invoice = new Invoice();
        invoice.setInvoiceDate(entity.getInvoiceDate());
        invoice.setBillingAddress(entity.getBillingAddress());
        invoice.setBillingCity(entity.getBillingCity());
        invoice.setBillingState(entity.getBillingState());
        invoice.setBillingCountry(entity.getBillingCountry());
        invoice.setBillingPostalCode(entity.getBillingPostalCode());
        invoice.setTotal(entity.getTotal());
        invoice.setCustomer(customerRepository.getReferenceById(entity.getCustomerId()));
        invoice.setInvoiceItems(new ArrayList<>());
        invoiceRepository.save(invoice);
    }

    @Override
    public InvoiceDto delete(Integer id) {
        Optional<Invoice> optionalInvoice = invoiceRepository.findById(id);
        optionalInvoice.ifPresent(invoiceRepository::delete);
        return optionalInvoice
                .map(invoiceDtoMapper)
                .orElseThrow();
    }

    @Override
    public void update(InvoiceDto entity) {
        Optional<Invoice> optionalInvoice = Stream.of(entity).map(invoiceMapper).findFirst();
        optionalInvoice.ifPresent(invoiceRepository::save);
    }

    @Override
    public List<InvoiceDto> getAll() {
        List<Invoice> values = invoiceRepository.findAll();
        return values
                .stream()
                .map(invoiceDtoMapper)
                .toList();
    }

    @Override
    public InvoiceDto getById(Integer id) {
        Optional<Invoice> value = invoiceRepository.findById(id);
        return value
                .map(invoiceDtoMapper)
                .orElseThrow();
    }
}
