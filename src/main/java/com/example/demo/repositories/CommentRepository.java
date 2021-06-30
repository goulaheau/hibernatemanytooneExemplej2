package com.example.demo.repositories;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Comment;

public interface CommentRepository extends JpaRepository<Comment, Long> {
	Page<Comment> findByPostId(Long postId,Pageable pageable);
Optional<Comment> findByIdAndPostId(long id,long postId);
}
