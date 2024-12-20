package com.seruhioCode30.quickbites.repository;

import com.seruhioCode30.quickbites.model.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {
}
