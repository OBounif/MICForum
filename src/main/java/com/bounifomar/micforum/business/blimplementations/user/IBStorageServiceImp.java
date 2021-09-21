package com.bounifomar.micforum.business.blimplementations.user;



import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Collection;

import javax.servlet.http.Part;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bounifomar.micforum.business.blexceptions.StorageException;
import com.bounifomar.micforum.business.blinterfaces.user.IBStorageService;

import eu.medsea.mimeutil.MimeUtil;


@Service
public class IBStorageServiceImp implements IBStorageService{
	
	private final Integer BUFFER_SIZE = 10240;

	
	@Value("${upload.path}")
	private String PATH ;
	
	
	@Override
	public String storeImage(Part in,String pref) throws StorageException{
		
		String filename = null;
		BufferedOutputStream buffer_out = null;
		BufferedInputStream buffer_in = null;
		try
			{
				/*	-Mimeutil uses BufferedInputStream.
				 * 	-BufferedInputStream doesn't hold any system resources.It simply wraps around InputStream which holds resources.
				 *  -Closing BufferedInputStream involves closure of InputStream . 
				 */
					
						buffer_in = new BufferedInputStream(in.getInputStream(),BUFFER_SIZE);
						
						MimeUtil.registerMimeDetector("eu.medsea.mimeutil.detector.MagicMimeMimeDetector");
						Collection<?> mimTypes = MimeUtil.getMimeTypes(buffer_in);
						
						String mimeTypes = mimTypes.toString();
		
						if(!mimeTypes.startsWith("image"))
						{
							throw new StorageException("Format de n'est pas supportée .");
						}
						
						filename = pref + "."+ mimeTypes.substring(mimeTypes.indexOf("/")+1);
						
						buffer_out = new BufferedOutputStream(new FileOutputStream(new File(PATH + filename)),BUFFER_SIZE);
						
						byte buffer[] = new byte[BUFFER_SIZE];
						int size = 0;
						
						 while ( ( size = buffer_in.read( buffer ) ) > 0 ) {
							 buffer_out.write( buffer, 0, size );
					    }
						 
						 /*
						  * 
						  * 
						  */
						 
			}
			catch (Exception e) {
				System.out.println(e);
				if( e instanceof StorageException)
					throw new StorageException(e.getMessage());
				else
					throw new StorageException("Une erreur inattendue est survenu réessayer ultérieurement");
			}
		finally {
			
				try {
					buffer_in.close();
				} catch (Exception e2) {
				}
				
				try {
					buffer_out.close();
				} catch (Exception e2) {
				}
		
		}
			
		 return filename;

	}
	
	

}
