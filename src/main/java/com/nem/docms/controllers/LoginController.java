package com.nem.docms.controllers;

import com.nem.docms.entities.User;
import com.nem.docms.servies.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
@RequestMapping("/login")
public class LoginController extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private final UserService userService;

	public LoginController(UserService userService) {
		this.userService = userService;
	}

	@PostMapping("")
	public void login(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
//		System.out.println("User List Controller called");
		List<User> listUser = userService.getAll();
		try {
			String a = request.getParameter("username");
			String b = request.getParameter("password");
//			System.out.println("login()");
			int i = 0;
			do {
				if (a.equals(listUser.get(i).getUsername()) && b.equals(listUser.get(i).getPassword())) {
					response.sendRedirect(request.getContextPath() + "/main");// logged-in page
//					System.out.println("login() if condition");

				}
				i++;
			} while (i < listUser.size());
//			System.out.println("login() else");
			response.sendRedirect(request.getContextPath() + "/login");// error page
		} catch (Throwable theException) {
			System.out.println(theException);
		}
	}
}
