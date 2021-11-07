package com.bounifomar.micforum.business.blexceptions;

public class ActivityException extends RuntimeException {

	
	private static final long serialVersionUID = 1685713090247968857L;
	
	public ActivityException(String message) {
		super(message);
	}
	
	public ActivityException(String message,Throwable cause)
	{
		super(message,cause);
	}
	
	public ActivityException(Throwable cause)
	{
		super(cause);
	}
	
	
}
