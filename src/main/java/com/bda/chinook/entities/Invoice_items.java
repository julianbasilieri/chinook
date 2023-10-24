package com.bda.chinook.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "invoice_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Invoice_items {
    @Id
    @GeneratedValue(generator = "invoice_items")
    @TableGenerator(name = "invoice_items", table = "sqlite_sequence",
    pkColumnName = "name", valueColumnName = "seq", pkColumnValue = "invoice_line_id")
    private int InvoiceLineId;
    @ManyToOne
    @JoinColumn(name = "InvoiceId")
    private Invoice invoice;
    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "TrackId")
    private Track track;
    private float UnitPrice;
    private int Quantity;
}
