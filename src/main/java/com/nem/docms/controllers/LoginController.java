package com.nem.docms.controllers;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class LoginController extends HttpServlet{
		
	private static final long serialVersionUID = 1L;
	
	@PostMapping("")
	public void login(HttpServletRequest request, HttpServletResponse response) 
	           throws ServletException, java.io.IOException {

				try{	  
				String a = request.getParameter("username");
				String b = request.getParameter("password");
				System.out.println("login()");
					    
				if (!b.equals("123") && !a.equals("admin")){
					
				System.out.println("login() if condition");
				response.sendRedirect(request.getContextPath()+"/login"); //logged-in page
				
				}else {
					System.out.println("login() else");
					response.sendRedirect(request.getContextPath()+"/main"); //error page
					
				} 
			}
			
			catch (Throwable theException) 	    
			{
			System.out.println(theException); 
			}
			}
				
}
