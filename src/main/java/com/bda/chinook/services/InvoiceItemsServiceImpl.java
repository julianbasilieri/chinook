package com.bda.chinook.services;

import com.bda.chinook.entities.InvoiceItems;
import com.bda.chinook.entities.dto.InvoiceItemsDto;
import com.bda.chinook.repositories.InvoiceItemsRepository;
import com.bda.chinook.repositories.InvoiceRepository;
import com.bda.chinook.repositories.TrackRepository;
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
    private final InvoiceRepository invoiceRepository;
    private final TrackRepository trackRepository;

    public InvoiceItemsServiceImpl(InvoiceItemsRepository invoiceItemsRepository, InvoiceItemsDtoMapper invoiceItemsDtoMapper, InvoiceItemsMapper invoiceItemsMapper, InvoiceRepository invoiceRepository, TrackRepository trackRepository) {
        this.invoiceItemsRepository = invoiceItemsRepository;
        this.invoiceItemsDtoMapper = invoiceItemsDtoMapper;
        this.invoiceItemsMapper = invoiceItemsMapper;
        this.invoiceRepository = invoiceRepository;
        this.trackRepository = trackRepository;
    }

    @Override
    public void add(InvoiceItemsDto entity) {
        InvoiceItems invoiceItems = new InvoiceItems();
        invoiceItems.setInvoice(invoiceRepository.getReferenceById(entity.getInvoiceId()));
        invoiceItems.setTrack(trackRepository.getReferenceById(entity.getTrackId()));
        invoiceItems.setUnitPrice(entity.getUnitPrice());
        invoiceItems.setQuantity(entity.getQuantity());
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
