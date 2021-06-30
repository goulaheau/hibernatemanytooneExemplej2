package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Post;
import com.example.demo.repositories.PostRepository;

@RestController
public class PostController {

	@Autowired
	private PostRepository postRepository;
	@GetMapping("/posts")
	public Page<Post> getAllPosts(Pageable pageable)
	{
		return postRepository.findAll(pageable);
	}
	@PostMapping("/posts")
	public Post createPost(@Valid @RequestBody Post post)
	{
		return postRepository.save(post);
			
	}
	
}
