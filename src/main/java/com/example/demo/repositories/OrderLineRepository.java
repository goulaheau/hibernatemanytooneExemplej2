package com.example.demo.repositories;

import com.example.demo.ecommerce.Order;
import com.example.demo.ecommerce.OrderLine;
import com.example.demo.ecommerce.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderLineRepository extends JpaRepository<OrderLine, Long> {
  Page<OrderLine> findByProductId(Long productId, Pageable pageable);
}
