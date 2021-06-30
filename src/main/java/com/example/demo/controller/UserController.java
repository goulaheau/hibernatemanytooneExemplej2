package com.example.demo.controller;

import com.example.demo.ecommerce.Order;
import com.example.demo.model.Post;
import com.example.demo.repositories.OrderRepository;
import com.example.demo.repositories.PostRepository;
import com.example.demo.repositories.UserRepository;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@Autowired
	private OrderRepository orderRepository;

	@GetMapping("/user/{id}/orders")
	public Page<Order> getAllOrders(@PathVariable(value = "id") Long id, Pageable pageable)
	{
		return orderRepository.findByUserId(id, pageable);
	}
}
