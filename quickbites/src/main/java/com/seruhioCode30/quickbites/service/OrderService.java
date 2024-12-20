package com.seruhioCode30.quickbites.service;

import com.seruhioCode30.quickbites.model.Order;
import com.seruhioCode30.quickbites.model.OrderItem;
import com.seruhioCode30.quickbites.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    // Obtener todos los pedidos
    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Obtener un pedido por ID
    public Optional<Order> getOrderById(Long id) {
        return orderRepository.findById(id);
    }

    public Order saveOrder(Order order) {
        try {
            // Depurando el nombre del cliente
            System.out.println("Creando pedido para el cliente: " + order.getCustomerName());

            // Depurando los productos en el pedido
            for (OrderItem item : order.getItems()) {
                System.out.println("Producto ID: " + item.getProduct().getId());
                System.out.println("Cantidad: " + item.getQuantity());
                System.out.println("Precio: " + item.getPrice());
            }

            return orderRepository.save(order);
        } catch (Exception e) {
            e.printStackTrace();  // Imprime la traza completa del error para tener más información
            throw new RuntimeException("Error al crear el pedido", e);
        }
    }


    // Actualizar un pedido
    public Order updateOrder(Long id, Order order) {
        return orderRepository.findById(id)
                .map(existingOrder -> {
                    existingOrder.setCustomerName(order.getCustomerName());
                    existingOrder.setItems(order.getItems());
                    existingOrder.setTotalPrice(order.getTotalPrice());
                    existingOrder.setStatus(order.getStatus());
                    return orderRepository.save(existingOrder);
                }).orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
    }

    // Eliminar un pedido
    public void deleteOrder(Long id) {
        orderRepository.deleteById(id);
    }
}

