<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>UserRegistration</title>
</head>
<body>
<form action="saveuser">
<fieldset style="width:500px; text-align:center;margin-left:450px;">

<legend><b>User Registration</b></legend>

Name :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="myName"><br><br>
Email :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="email" name="myEmail"><br><br>
Phone :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="tel" name="myPhone"><br><br>
Password :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="password" name="myPassword"><br><br>
Role :&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<input type="text" name="myRole"><br><br>

<input type="submit" value="RegisterUser">
<input type="reset" value="clear">

</fieldset>
</form>
</body>
</html>