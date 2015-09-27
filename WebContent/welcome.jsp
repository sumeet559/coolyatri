<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body background="5.jpg" style="background-repeat:no-repeat;background-size:cover">
<p class="header"><strong>REGISTRATION SUCCESSFUL!!<br></strong></p>
<div class="welcome"> welcome <%=session.getAttribute("user") %></div>
<a href='location.jsp' class="header">LOCATE ME NOW!!!</a>
</body>
</html>
<style>
.header {
color: blue;
cursor: pointer;
height: 100px;
text-transform: uppercase;
width: 400px;}
.welcome{
color:white;
font-size:50px;
}
</style>
