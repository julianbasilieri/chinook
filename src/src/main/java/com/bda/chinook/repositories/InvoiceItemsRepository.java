package com.bda.chinook.repositories;

import com.bda.chinook.entities.InvoiceItems;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceItemsRepository extends JpaRepository<InvoiceItems, Integer> {
}
