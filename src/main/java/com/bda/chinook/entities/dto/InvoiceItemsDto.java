package com.bda.chinook.entities.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceItemsDto {
    private int InvoiceLineId;
    private int InvoiceId;
    private int TrackId;
    private float UnitPrice;
    private int Quantity;
}
