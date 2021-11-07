package com.bounifomar.micforum.business.blexceptions;

public class FormVException extends RuntimeException {

	/**s
	 * 
	 */
	private static final long serialVersionUID = 1685713090247968857L;
	
	public FormVException(String message) {
		super(message);
	}
	
	public FormVException(String message,Throwable cause)
	{
		super(message,cause);
	}
	
	public FormVException(Throwable cause)
	{
		super(cause);
	}
}
