package com.bda.chinook.services.transformations.invoiceItems;

import com.bda.chinook.entities.InvoiceItems;
import com.bda.chinook.entities.dto.InvoiceItemsDto;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class InvoiceItemsDtoMapper implements Function<InvoiceItems, InvoiceItemsDto> {
    @Override
    public InvoiceItemsDto apply(InvoiceItems invoiceItems) {
        return new InvoiceItemsDto(invoiceItems.getInvoiceLineId(),
                invoiceItems.getUnitPrice(),
                invoiceItems.getQuantity());
    }
}
