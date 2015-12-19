package com.sust.servlet;

import java.io.IOException;
import java.net.InetAddress;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/message")
public class MessageServlet extends HttpServlet {

	private void proccess(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		String status = request.getParameter("fileUploadStatus");
		InetAddress ip = InetAddress.getLocalHost();

		if (status.equals("false")) {
			System.out.println("[FILE DIRECTORY ATTRIBUTE EMPTY]");
			request.setAttribute("fileDirectory", "#");
			request.setAttribute("message", "URL NOT FOUND!");
		} else {
			String fileRelativeURL = request.getParameter("fileRelativeURL");
			String directory = "http://" + ip.getHostAddress() + ":"
					+ request.getLocalPort() + ""
					+ request.getServletContext().getContextPath()
					+ fileRelativeURL;
			System.out.println("[DIRECTORY URL]:" + directory);
			request.setAttribute("fileDirectory", directory);
			request.setAttribute("message", "FILE UPLOADED!");
		}

		request.getRequestDispatcher("/message.jsp").forward(request, response);
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
