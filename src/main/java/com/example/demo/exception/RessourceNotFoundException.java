package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class RessourceNotFoundException extends RuntimeException {
public RessourceNotFoundException()
{
super();	
}
public RessourceNotFoundException(String message)
{
	
super(message);	
}
public RessourceNotFoundException(String message,Throwable cause)
{
	
super(message,cause);	
}
}
