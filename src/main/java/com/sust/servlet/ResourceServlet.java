package com.sust.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/resource")
public class ResourceServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private void proccess(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		response.setContentType("application/pdf");
		ServletContext context = getServletContext();
		InputStream inputStream = context.getResourceAsStream("/WEB-INF/resources/Problem Set.pdf");
		
		if(inputStream==null){
			System.out.println("Input Stream Null");
		}
		
		int read=0;
		byte[] bytes = new byte[1024];
		OutputStream os = response.getOutputStream();
		
		while((read=inputStream.read(bytes))!=-1){
			os.write(bytes,0,read);
		}
		

	}

	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		proccess(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		proccess(request, response);
	}
}
