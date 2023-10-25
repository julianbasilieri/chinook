package com.bda.chinook.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "invoice_items")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class InvoiceItems {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @TableGenerator(name = "invoice_items", table = "sqlite_sequence",
    pkColumnName = "name", valueColumnName = "seq", pkColumnValue = "invoice_line_id")
    private int InvoiceLineId;
    @ManyToOne
    @JoinColumn(name = "InvoiceId")
    @JsonIgnore
    private Invoice invoice;
    @ManyToOne
    @JoinColumn(name = "TrackId")
    @JsonIgnore
    private Track track;
    private float UnitPrice;
    private int Quantity;
}
