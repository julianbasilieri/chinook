package com.bda.chinook.services.transformations.invoiceItems;

import com.bda.chinook.entities.InvoiceItems;
import com.bda.chinook.entities.dto.InvoiceItemsDto;
import com.bda.chinook.repositories.InvoiceRepository;
import com.bda.chinook.repositories.TrackRepository;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class InvoiceItemsMapper implements Function<InvoiceItemsDto, InvoiceItems> {
    private final InvoiceRepository invoiceRepository;
    private final TrackRepository trackRepository;

    public InvoiceItemsMapper(InvoiceRepository invoiceRepository, TrackRepository trackRepository) {
        this.invoiceRepository = invoiceRepository;
        this.trackRepository = trackRepository;
    }

    @Override
    public InvoiceItems apply(InvoiceItemsDto invoiceItemsDto) {
        return new InvoiceItems(invoiceItemsDto.getInvoiceLineId(),
                invoiceRepository.getReferenceById(invoiceItemsDto.getInvoiceId()),
                trackRepository.getReferenceById(invoiceItemsDto.getTrackId()),
                invoiceItemsDto.getUnitPrice(),
                invoiceItemsDto.getQuantity());
    }
}
