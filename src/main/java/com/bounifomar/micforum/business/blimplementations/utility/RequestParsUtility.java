package com.bounifomar.micforum.business.blimplementations.utility;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

public class RequestParsUtility {
		
	
	public static String getFieldValue(HttpServletRequest request,String field)
	{
		String fieldValue = request.getParameter(field);
		
		if(fieldValue == null || fieldValue.trim().length() == 0 )
				return null;
		else
				return fieldValue.trim();
	}
	
	public static String getPartStream_name(HttpServletRequest request,String PART_FIELD,Map<String,String> errors)
	{
		try
		{
			Part cover_pic = request.getPart(PART_FIELD);
			
			
			String filename = getFileName(cover_pic);
			
			if(filename !=null && !filename.isEmpty())
			{
				/*
				 *  -ANTIBUG for Internet explorer which sends the absolute path of the file in the client FS.
				 * */
				String filename_ie = filename.substring( filename.lastIndexOf( '/' ) + 1 )
                        .substring( filename.lastIndexOf( '\\' ) + 1 );
				
		
				return filename_ie;
			}
			
		}
		catch ( IllegalStateException e) {
			errors.put(PART_FIELD, "La taille de l'image ne doit pas dépasser 2MB.");
			e.printStackTrace();

		}
		catch (IOException e) {
			errors.put(PART_FIELD, "Une erreur inattendue est survenu réessayer ultérieurement");
			e.printStackTrace();


		}
		catch (ServletException e) {
			errors.put(PART_FIELD, "Ce type de requête n'est pas supporté.");
			e.printStackTrace();
		}
		
		
		return null;
	}
	
	
	private static String getFileName(Part part)
	{
		if(part == null)
			return null;
		
		for(String contentD : part.getHeader("content-disposition").split(";"))
		{
			if(contentD.trim().startsWith("filename"))
				return contentD.substring(contentD.indexOf("=")+1).trim().replace("\"", "");
		}
		
		return null;
	}
 }
