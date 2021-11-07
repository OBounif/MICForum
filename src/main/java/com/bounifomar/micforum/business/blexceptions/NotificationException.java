package com.bounifomar.micforum.business.blexceptions;

public class NotificationException extends RuntimeException {

	private static final long serialVersionUID = 1685713090247968857L;
	
	public NotificationException(String message) {
		super(message);
	}
	
	public NotificationException(String message,Throwable cause)
	{
		super(message,cause);
	}
	
	public NotificationException(Throwable cause)
	{
		super(cause);
	}
	
	
}
