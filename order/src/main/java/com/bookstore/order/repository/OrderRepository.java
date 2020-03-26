package com.bookstore.order.repository;

import com.bookstore.order.model.Order;
import com.bookstore.order.model.OrderInfo;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<OrderInfo> findAllByCustomerIdAndDateBetween(Long customerId, LocalDateTime from, LocalDateTime to);

    List<OrderInfo> findAllByCustomerId(Long customerId, Pageable pageable);
}
