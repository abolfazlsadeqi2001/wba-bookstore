package com.bookstore.order.model;

import java.math.BigDecimal;
import java.util.Date;

public interface OrderInfo {

	Long getId();

	Date getDate();

	BigDecimal getAmount();

	OrderStatus getStatus();
}
