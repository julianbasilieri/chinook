package com.bda.chinook.services;

import com.bda.chinook.entities.InvoiceItems;
import com.bda.chinook.entities.dto.InvoiceItemsDto;
import com.bda.chinook.repositories.InvoiceItemsRepository;
import com.bda.chinook.services.transformations.invoiceItems.InvoiceItemsDtoMapper;
import com.bda.chinook.services.transformations.invoiceItems.InvoiceItemsMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;
@Service
public class InvoiceItemsServiceImpl implements InvoiceItemsService {
    private final InvoiceItemsRepository invoiceItemsRepository;
    private final InvoiceItemsDtoMapper invoiceItemsDtoMapper;
    private final InvoiceItemsMapper invoiceItemsMapper;

    public InvoiceItemsServiceImpl(InvoiceItemsRepository invoiceItemsRepository, InvoiceItemsDtoMapper invoiceItemsDtoMapper, InvoiceItemsMapper invoiceItemsMapper) {
        this.invoiceItemsRepository = invoiceItemsRepository;
        this.invoiceItemsDtoMapper = invoiceItemsDtoMapper;
        this.invoiceItemsMapper = invoiceItemsMapper;
    }

    @Override
    public void add(InvoiceItemsDto entity) {
        InvoiceItems invoiceItems = Optional.of(entity).map(invoiceItemsMapper).orElseThrow();
        invoiceItemsRepository.save(invoiceItems);
    }

    @Override
    public InvoiceItemsDto delete(Integer id) {
        Optional<InvoiceItems> optionalInvoiceItems = invoiceItemsRepository.findById(id);
        optionalInvoiceItems.ifPresent(invoiceItemsRepository::delete);
        return optionalInvoiceItems
                .map(invoiceItemsDtoMapper)
                .orElseThrow();
    }

    @Override
    public void update(InvoiceItemsDto entity) {
        Optional<InvoiceItems> optionalInvoiceItems = Stream.of(entity).map(invoiceItemsMapper).findFirst();
        optionalInvoiceItems.ifPresent(invoiceItemsRepository::save);
    }

    @Override
    public List<InvoiceItemsDto> getAll() {
        List<InvoiceItems> values = invoiceItemsRepository.findAll();
        return values
                .stream()
                .map(invoiceItemsDtoMapper)
                .toList();
    }

    @Override
    public InvoiceItemsDto getById(Integer id) {
        Optional<InvoiceItems> value = invoiceItemsRepository.findById(id);
        return value
                .map(invoiceItemsDtoMapper)
                .orElseThrow();
    }
}
