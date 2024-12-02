package com.seruhioCode30.quickbites.repository;

import com.seruhioCode30.quickbites.model.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
