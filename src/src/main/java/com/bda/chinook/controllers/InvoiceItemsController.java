package com.bda.chinook.controllers;

import com.bda.chinook.entities.dto.InvoiceItemsDto;
import com.bda.chinook.services.InvoiceItemsService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/invoiceItems")
public class InvoiceItemsController {
    private final InvoiceItemsService invoiceItemsService;

    public InvoiceItemsController(InvoiceItemsService invoiceItemsService) {
        this.invoiceItemsService = invoiceItemsService;
    }

    @GetMapping
    public ResponseEntity<List<InvoiceItemsDto>> getAll() {
        List<InvoiceItemsDto> values = invoiceItemsService.getAll();
        return ResponseEntity.ok(values);
    }

    @GetMapping("/{id}")
    public ResponseEntity<InvoiceItemsDto> getById(@PathVariable("id") int id) {
        InvoiceItemsDto value = invoiceItemsService.getById(id);
        return ResponseEntity.ok(value);
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody InvoiceItemsDto entity) {
        invoiceItemsService.add(entity);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody InvoiceItemsDto entity) {
        invoiceItemsService.update(entity);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable("id") int id) {
        invoiceItemsService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).build();
    }
}
