package com.bounifomar.micforum.business.blexceptions;

public class QueryException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public QueryException(String message)
	{
		super(message);
	}

	public QueryException(Throwable cause)
	{
		super(cause);
	}
	
	public QueryException(String message,Throwable cause)
	{
		super(message,cause);
	}
}
