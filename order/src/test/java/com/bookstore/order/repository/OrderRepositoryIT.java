package com.bookstore.order.repository;

import com.bookstore.customer.model.Address;
import com.bookstore.customer.model.CreditCard;
import com.bookstore.customer.model.Customer;
import com.bookstore.customer.repository.CustomerRepository;
import com.bookstore.order.model.BookInfo;
import com.bookstore.order.model.Order;
import com.bookstore.order.model.OrderItem;
import com.bookstore.order.model.OrderStatus;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import static com.bookstore.customer.model.CreditCardType.MASTERCARD;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
class OrderRepositoryIT {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderRepository orderRepository;

    @Test
    @Transactional
    void createCustomerAndSaveOrder() {
        Customer customer = new Customer("Alice", "Smith", "alice@example.org", "alice",
                new Address("123 Maple Street", "Mill Valley", "CA", "90952", "US"),
                new CreditCard(MASTERCARD, "5400000000000000", 1, 2020));

        customer = customerRepository.saveAndFlush(customer);

        assertNotNull(customer.getId());

        Order order = new Order(LocalDateTime.now(), new BigDecimal("94.98"), OrderStatus.ACCEPTED, customer, createOrderItems());
        order = orderRepository.saveAndFlush(order);

        assertNotNull(order.getId());
    }

    private List<OrderItem> createOrderItems() {
        return Arrays.asList(
                new OrderItem(new BookInfo("1617294942", "Spring in Action", "Craig Walls", new BigDecimal("49.99")), 1),
                new OrderItem(new BookInfo("1617292540", "Spring Boot in Action", "Craig Walls", new BigDecimal("44.99")), 1)
        );
    }
}
