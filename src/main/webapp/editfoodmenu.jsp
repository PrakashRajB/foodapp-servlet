<%@page import="com.ty.foodapp.dto.FoodMenu"%>
<%@page import="com.ty.foodapp.dao.FoodMenuDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>edit</title>
</head>
<body>
<%int id = Integer.parseInt(request.getParameter("myId"));
FoodMenu menu =new FoodMenuDao().getFoodMenuById(id);
%>
<form action="editmenu">
<h1>Edit the Menu Details</h1>
 <input type="text" name="myId" value=<%=id %> hidden="true"> 
Name:<input type="text" name="myName" value="<%=menu.getName()%>">
Description:<input type="text" name="myDesc" value=<%=menu.getDescription() %>>
Cost:<input type="tel" name="myCost" value=<%=menu.getCost() %>>

<input type="submit" value="Submit">
<input type="reset" value="clear">
</form>
</body>
</html>