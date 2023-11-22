<%@page import="java.time.LocalDateTime"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h4 align="center">Hii its Ak</h4>
<h4 align="center"><%=request.getSession() %></h4>
<h4 align="center"><%=request.getSession().getId()%></h4>
<h4 align="center"><%= LocalDateTime.now()%></h4>
<button align="center"><a href="login.jsp">Login</a></button>

</body>
</html>