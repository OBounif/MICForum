package com.bounifomar.micforum.business.blimplementations.user;



import org.apache.tika.Tika;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.bounifomar.micforum.business.blexceptions.StorageException;
import com.bounifomar.micforum.business.blinterfaces.user.IBStorageService;


@Service
public class IBStorageServiceImp implements IBStorageService{
	
	private static Integer MAX_IMAGE_SIZE = 2097152;

	
	@Value("${upload.path}")
	private static String PATH ;
	
	
	@Override
	public String storeImage(MultipartFile file,String pref) throws StorageException{
			
		
			if(file.getSize() > MAX_IMAGE_SIZE )
				throw new StorageException("La taille de l'image ne doit pas dépasser 2MB.");
			
			try
			{
				/*	-Mimeutil uses BufferedInputStream.
				 * 	-BufferedInputStream doesn't hold any system resources.It simply wraps around InputStream which holds resources.
				 *  -Closing BufferedInputStream involves closure of InputStream . 
				 
					
						BufferedInputStream buffer_in = new BufferedInputStream(file.getInputStream());
						
						MimeUtil.registerMimeDetector("eu.medsea.mimeutil.detector.MagicMimeMimeDetector");
						Collection<?> mimTypes = MimeUtil.getMimeTypes(buffer_in);
						
						String mimeTypes = mimTypes.toString();
						System.out.println(mimeTypes);
		
						if(!mimeTypes.startsWith("image"))
						{
							throw new StorageException("Le type d'image n'est pas supporté.");
						}
				*/
				
				Tika tika = new Tika();
				String mimeType = tika.detect(file.getInputStream());
				System.out.println(tika.detect(file.getBytes()));
				System.out.println(file.getContentType());
				System.out.println(mimeType);
				System.out.println(file.getOriginalFilename());

			/*	File file_c = new File(PATH+"/"+filename);
				file.transferTo(file_c);	
				*/
				return null;
			}
			catch (Exception e) {
				System.out.println(e);
				if( e instanceof StorageException)
					throw new StorageException(e.getMessage());
				else
					throw new StorageException("Une erreur inattendue est survenu réessayer ultérieurement");
			}
			
			
	}
	
	

}
