package com.bda.chinook.services.transformations.invoiceItems;

import com.bda.chinook.entities.InvoiceItems;
import com.bda.chinook.entities.dto.InvoiceItemsDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;
@Service
public class InvoiceItemsMapper implements Function<InvoiceItemsDto, InvoiceItems> {
    @Override
    public InvoiceItems apply(InvoiceItemsDto invoiceItemsDto) {
        return new InvoiceItems(invoiceItemsDto.getInvoiceLineId(),
                null,
                null,
                invoiceItemsDto.getUnitPrice(),
                invoiceItemsDto.getQuantity());
    }
}
