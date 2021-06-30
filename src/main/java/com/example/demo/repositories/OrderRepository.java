package com.example.demo.repositories;

import com.example.demo.ecommerce.Order;
import com.example.demo.model.Comment;
import com.example.demo.model.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
  Page<Order> findByUserId(Long userId, Pageable pageable);
}
