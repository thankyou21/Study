package com.cg.demo;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class OrderStatusServlet
 */
@WebServlet("/OrderStatusServlet")
public class OrderStatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrderStatusServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] carr = request.getCookies();
		PrintWriter out = response.getWriter();
		boolean flag = false;
		if(carr!=null)
		{
			for(Cookie c : carr)
			{
				if(c.getName().equals("userName"))
				{
					out.println("<html><body>");
					out.println("<h2>Hello.."+c.getValue());
					out.println("below are the order Details ..");
					out.println("</body></html>");
					flag=true;
				}
			}
			if(!flag)
			{
				response.sendRedirect("Welcome.html");
			}
			
			else
				response.sendRedirect("Welcome.html");
		}
	}

}
