package com.bounifomar.micforum.business.blinterfaces.user;



import javax.servlet.http.Part;

import com.bounifomar.micforum.business.blexceptions.StorageException;


public interface IBStorageService {	
		
		
	public String storeImage(Part in,String pref)throws StorageException;
	
}
