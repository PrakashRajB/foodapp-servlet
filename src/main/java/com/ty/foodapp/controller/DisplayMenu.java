package com.ty.foodapp.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.foodapp.dao.FoodMenuDao;
import com.ty.foodapp.dto.FoodMenu;

@WebServlet(value = "/displaymenu")
public class DisplayMenu extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		if (req.getSession().getAttribute("myPhone") != null) {
			List<FoodMenu> foodMenus = new FoodMenuDao().getAllFoodMenu();

			req.setAttribute("myFoodMenu", foodMenus);

			RequestDispatcher dispatcher = req.getRequestDispatcher("displayfoodmenu.jsp");
			dispatcher.forward(req, resp);
		} else {
			resp.getWriter().write("<html><body><h1>Please Do Login</h1></body></html>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		}

	}

}
