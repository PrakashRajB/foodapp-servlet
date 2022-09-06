package com.ty.foodapp.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ty.foodapp.dao.FoodMenuDao;
import com.ty.foodapp.dto.FoodMenu;

@WebServlet(value = "/addfoodmenu")
public class AddFoodMenu extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		if (req.getSession().getAttribute("myPhone") != null) {
			FoodMenu foodMenu = new FoodMenu();
			foodMenu.setName(req.getParameter("myName"));
			foodMenu.setDescription(req.getParameter("myDesc"));
			foodMenu.setCost(Double.parseDouble(req.getParameter("myCost")));

			FoodMenu foodMenu2 = new FoodMenuDao().addFoodMenu(foodMenu);

			if (foodMenu2 != null) {
				RequestDispatcher dispatcher = req.getRequestDispatcher("displaymenu");
				dispatcher.include(req, resp);
			}
		} else {
			resp.getWriter().write("<html><body><h1>Please Do Login</h1></body></html>");
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.include(req, resp);
		}

	}

}
