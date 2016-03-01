package com.sust.servlet.file;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


import com.sust.db.utils.NameBuilder;

@WebServlet("/fileUploader")
public class FileUploaderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String UPLOAD_DIRECTORY = "uploads\\files";
	private static final String UPLOAD_URL = "/uploads/files/";

	/**
	 * Default constructor.
	 */
	public FileUploaderServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String realPath = request.getServletContext().getRealPath("");
		System.out.println("[REAL PATH]: " + realPath);
		String relativeDirectory = realPath + UPLOAD_DIRECTORY;
		System.out.println("[SAVE DIRECTORY]: " + relativeDirectory);

		/**
		 * If directory not exists create the directory
		 */
		File fileSaveRelativeDirectory = new File(relativeDirectory);
		if (!fileSaveRelativeDirectory.exists()) {
			fileSaveRelativeDirectory.mkdirs();
		}

		System.out.println("[DIRECTORY CREATED]");

		try {
			int index = 1;
			String fileSaveDirectory = "#";
			/**
			 * THIS @Param fileSaveURL 
			 * SHOULD BE SAVED IN DATABSE SYSTEM FOR FUTHER SPECIFIED USER USE;
			 */
			String fileSaveURL = "";
			for (Part part : request.getParts()) {
				System.out.println("FILE PARTING" + (index++));
				String fileName = NameBuilder.getInstance().extractFileName(
						part);
				fileSaveURL = UPLOAD_URL+fileName;
				fileSaveDirectory = relativeDirectory + File.separator
						+ fileName;
				System.out.println("FILE WRITING...");
				part.write(fileSaveDirectory);
			}
			
			System.out.println("[FILE SAVE DIRECTORY]: "+fileSaveDirectory);
			System.out.println("[FILE UPLOADING RIDRECTING TO MESSAGE PAGE]!");
			request.getRequestDispatcher("/downloader?fileUploadStatus=true&fileRelativeURL="+fileSaveURL).forward(request, response);
		} catch (Exception ex) {
			System.out.println("[FILE UPLOAD EXCEPTION]: " + ex.getMessage());
			request.getRequestDispatcher("/downloader?fileUploadStatus=false").forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}