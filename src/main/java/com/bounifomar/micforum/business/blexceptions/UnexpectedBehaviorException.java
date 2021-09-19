package com.bounifomar.micforum.business.blexceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR,reason = "test")
public class UnexpectedBehaviorException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1685713090247968857L;
	
	public UnexpectedBehaviorException(String message) {
		super(message);
	}
	
	public UnexpectedBehaviorException(String message,Throwable cause)
	{
		super(message,cause);
	}
	
	public UnexpectedBehaviorException(Throwable cause)
	{
		super(cause);
	}
	
	
}
