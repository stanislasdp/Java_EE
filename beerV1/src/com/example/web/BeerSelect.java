package com.example.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.model.BeerExpert;

/**
 * Servlet implementation class BeerSelect1
 */
@WebServlet(name = "BeerSelect", urlPatterns = { "/BeerSelect" })
public class BeerSelect extends HttpServlet 
{
	private BeerExpert modelBeerExpert;
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BeerSelect() {
        super();
        modelBeerExpert = new BeerExpert();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		response.setContentType("text/html");
		//response.sendRedirect("hhtps://google.com");
		
		//request.setAttribute(getServletConfig().getInitParameter("mainEmail"), "Main");
		PrintWriter out = response.getWriter();
		out.println("Beer Selection Advice<br>");
		out.println("<br>"+getServletConfig().getInitParameter("Main"));
		String color = request.getParameter("color");
		List<String> result = modelBeerExpert.getBrands(color);
		
		RequestDispatcher view = request.getRequestDispatcher("result.jsp");
		//use request dispatcher to send request and response to JSP
	
		//System.out.println(getServletConfig().getInitParameter("adminEmail"));
		view.forward(request, response);
		
	}

}
