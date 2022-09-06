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

@WebServlet(value = "/saveuser")
public class SaveUser extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		User user=new User();
		user.setName(req.getParameter("myName"));
		user.setEmail(req.getParameter("myEmail"));
		user.setPhone(Long.parseLong(req.getParameter("myPhone")));
		user.setPassword(req.getParameter("myPassword"));
		user.setRole(req.getParameter("myRole"));
		
		User user2=new UserDao().saveUser(user);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("login.jsp");
		dispatcher.forward(req, resp);

	}

}
