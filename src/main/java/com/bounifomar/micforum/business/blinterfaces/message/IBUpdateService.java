package com.bounifomar.micforum.business.blinterfaces.message;


public interface IBUpdateService<T> {

	
	public void updateViewNumber(T object);
	
	public void updateCommentsNumber(T object);

	
}
