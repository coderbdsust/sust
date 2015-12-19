package com.sust.db.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.Part;

public class NameBuilder {

	private static final NameBuilder ownInstance = new NameBuilder();

	public static NameBuilder getInstance() {
		return ownInstance;
	}

	public String getTimestamp() {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMdd_HHmmss");
		return dateFormat.format(new Date()).toString();
	}

	public String getUniqueName(String fileName) {
		fileName = fileName.replace(" ", "");
		String[] words = fileName.split("\\.");
		String name = "";
		for (int i = 0; i < words.length - 1; i++) {
			name += words[i];
		}
		if (words.length > 1)
			name = name + "_" + getTimestamp() + "." + words[words.length - 1];
		else {
			name = getTimestamp() + "_" + name;
		}
		return name;
	}
	
	public String extractFileName(Part part) {
	        // courtesy of BalusC : http://stackoverflow.com/a/2424824/281545
	        for (String cd : part.getHeader("content-disposition").split(";")) {
	            if (cd.trim().startsWith("filename")) {
	                String filename = cd.substring(cd.indexOf('=') + 1).trim()
	                        .replace("\"", "");
	                return filename.substring(filename.lastIndexOf('/') + 1)
	                        .substring(filename.lastIndexOf('\\') + 1); // MSIE fix.
	            }
	        }
	        return null;
	    }
}
