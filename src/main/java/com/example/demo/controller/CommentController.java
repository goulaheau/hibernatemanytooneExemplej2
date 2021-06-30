package com.example.demo.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.exception.RessourceNotFoundException;
import com.example.demo.model.Comment;
import com.example.demo.repositories.CommentRepository;
import com.example.demo.repositories.PostRepository;

@RestController
public class CommentController {
@Autowired
private CommentRepository commentRepository;
@Autowired
private PostRepository postRepository;
@GetMapping("/post/{postId}/comments")
public Page<Comment> getAllcommentsBypostId(@PathVariable(value = "postId")Long postId,Pageable pageable)
{
	return  commentRepository.findByPostId(postId, pageable);
}
@PostMapping("/post/{postId}/comments")
public Comment createComment(@PathVariable(value = "postId")Long postId,@Valid @RequestBody Comment comment)
{
return postRepository.findById(postId).map(post->{
	comment.setPost(post);
	return commentRepository.save(comment);
}).orElseThrow(()->new RessourceNotFoundException("PostId"+postId+"not found"));	
}

}
