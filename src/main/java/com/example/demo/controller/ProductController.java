package com.example.demo.controller;

import com.example.demo.ecommerce.Order;
import com.example.demo.ecommerce.OrderLine;
import com.example.demo.repositories.OrderLineRepository;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	private OrderLineRepository orderLineRepository;

	@GetMapping("/product/{id}/order-lines")
	public Page<OrderLine> getAllOrders(@PathVariable(value = "id") Long id, Pageable pageable)
	{
		return orderLineRepository.findByProductId(id, pageable);
	}
}
