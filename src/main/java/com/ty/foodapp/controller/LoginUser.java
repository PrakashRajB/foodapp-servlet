package com.ty.foodapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.foodapp.dao.UserDao;
import com.ty.foodapp.dto.User;

@WebServlet(value = "/login")
public class LoginUser extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		User user = new UserDao().validateUser(req.getParameter("myEmail"), req.getParameter("myPassword"));

		if (user != null) {
                req.getSession().setAttribute("myPhone", user.getPhone());
                
                RequestDispatcher dispatcher=req.getRequestDispatcher("displaymenu");
                dispatcher.forward(req, resp);
		}
		else {
			    resp.getWriter().write("<html><body><h1>Invalid Email or Password</h1></body></html>");
			    RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
                dispatcher.include(req, resp);
		}
	}

}
