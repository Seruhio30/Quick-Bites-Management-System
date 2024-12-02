package com.seruhioCode30.quickbites.repository;

import com.seruhioCode30.quickbites.model.Invoice;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
}

