package com.seruhioCode30.quickbites.service;

import com.seruhioCode30.quickbites.model.Invoice;
import com.seruhioCode30.quickbites.model.Order;
import com.seruhioCode30.quickbites.repository.InvoiceRepository;
import com.seruhioCode30.quickbites.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    @Autowired
    private OrderRepository orderRepository;

    // Generar una factura para un pedido
    public Invoice generateInvoice(Long orderId, Double taxRate) {
        Order order = orderRepository.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        Double totalBeforeTax = order.getTotalPrice();
        Double tax = totalBeforeTax * taxRate;
        Double totalWithTax = totalBeforeTax + tax;

        Invoice invoice = new Invoice();
        invoice.setOrder(order);
        invoice.setIssuedAt(LocalDateTime.now());
        invoice.setTotal(totalWithTax);
        invoice.setTax(tax);

        return invoiceRepository.save(invoice);
    }

    // Obtener todas las facturas
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    // Obtener una factura por ID
    public Optional<Invoice> getInvoiceById(Long id) {
        return invoiceRepository.findById(id);
    }

    // Eliminar una factura
    public void deleteInvoice(Long id) {
        invoiceRepository.deleteById(id);
    }
}
