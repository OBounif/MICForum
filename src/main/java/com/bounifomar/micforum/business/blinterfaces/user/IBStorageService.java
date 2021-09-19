package com.bounifomar.micforum.business.blinterfaces.user;


import org.springframework.web.multipart.MultipartFile;

import com.bounifomar.micforum.business.blexceptions.StorageException;


public interface IBStorageService {	
		
		
	public String storeImage(MultipartFile file,String pref)throws StorageException;

}
