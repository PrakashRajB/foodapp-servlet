<%@page import="com.ty.foodapp.dto.FoodMenu"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DisplayFoodMenu</title>
</head>
<body>
<h1>FoodMenu</h1>
<%List<FoodMenu> foodMenus=(List<FoodMenu>)request.getAttribute("myFoodMenu"); %>
<table border ="3" >
<tr><th colspan="6">FoodMenu<th></tr>
<tr>
<th>Id</th>
<th>Name</th>
<th>Description</th>
<th>Cost</th>
<th>Edit</th>
<th>Delete</th>
</tr>

<%for(FoodMenu menu : foodMenus){ %>
<tr>
<td><%=menu.getId() %></td>
<td><%=menu.getName() %></td>
<td><%=menu.getDescription() %></td>
<td><%=menu.getCost() %></td>
<td><a href="editfoodmenu.jsp?myId=<%=menu.getId()%>" >Edit</a></td>
<td><a href="deletemenu?myId=<%=menu.getId()%>">Delete</a></td>
</tr>
<%} %>
</table>
<a href="addmenu.jsp"><button>Add New Menu</button></a>
</body>
</html>