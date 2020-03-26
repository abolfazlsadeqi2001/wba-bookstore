package com.bookstore.order.repository;

import com.bookstore.order.model.OrderInfo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.data.domain.PageRequest;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class OrderRepositoryTest {

    @Autowired
    private OrderRepository repository;

    @Test
    void findAllByCustomerIdAndDateBetween() {
        List<OrderInfo> orders = repository.findAllByCustomerIdAndDateBetween(1001L,
                LocalDateTime.now().minusMonths(10), LocalDateTime.now());
        assertEquals(1, orders.size());
    }

    @Test
    void findAllByCustomerId() {
        repository.findAllByCustomerId(1001L, PageRequest.of(0, 10));
    }
}
