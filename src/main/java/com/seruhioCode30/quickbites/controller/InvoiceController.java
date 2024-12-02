package com.seruhioCode30.quickbites.controller;

import com.seruhioCode30.quickbites.model.Invoice;
import com.seruhioCode30.quickbites.service.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/admin/invoices")
public class InvoiceController {

    @Autowired
    private InvoiceService invoiceService;

    // Generar una factura para un pedido
    @PostMapping("/{orderId}")
    public Invoice generateInvoice(@PathVariable Long orderId, @RequestParam Double taxRate) {
        return invoiceService.generateInvoice(orderId, taxRate);
    }

    // Obtener todas las facturas
    @GetMapping
    public List<Invoice> getAllInvoices() {
        return invoiceService.getAllInvoices();
    }

    // Obtener una factura por ID
    @GetMapping("/{id}")
    public ResponseEntity<Invoice> getInvoiceById(@PathVariable Long id) {
        return invoiceService.getInvoiceById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    // Eliminar una factura por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteInvoice(@PathVariable Long id) {
        invoiceService.deleteInvoice(id);
        return ResponseEntity.noContent().build();
    }
}
