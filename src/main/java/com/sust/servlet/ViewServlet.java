package com.sust.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/view")
public class ViewServlet extends HttpServlet {

	private void proccess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		System.out.println("VIEW URL");
		ArrayList<String> animals = new ArrayList<String>();
		animals.add("Cat");
		animals.add("Dog");
		animals.add("Horse");
		request.setAttribute("animals", animals);
		request.getRequestDispatcher("/view.jsp").forward(request, response);;
		

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
