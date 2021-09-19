package com.bounifomar.micforum.business.blexceptions;

public class StorageException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1685713090247968857L;
	
	public StorageException(String message) {
		super(message);
	}
	
	public StorageException(String message,Throwable cause)
	{
		super(message,cause);
	}
	
	public StorageException(Throwable cause)
	{
		super(cause);
	}
	
	
}
