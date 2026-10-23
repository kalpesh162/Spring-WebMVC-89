<%@page import="com.bean.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Student Update Form</title>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/form.css">
<link>
</head>
<body>

	<%  Student student =(Student)request.getAttribute("student"); %>

	<h2>Update Student</h2>

	<%
		if (student != null) {
	%>

	<h2>
		<%= request.getContextPath()+"/student/update" %>
		<br>
		${pageContext.request.contextPath}
	</h2>
	<form action="${pageContext.request.contextPath}/student/update" method="post">

		<label>ID:</label> <input type="text" name="id"
			value="<%= student.getId() %>" readonly> <br> <br>
		<label>Name:</label> <input type="text" name="name"
			value="<%= student.getName() %>"> <br> <br> <label>Marks:</label>
		<input type="text" name="marks" value="<%= student.getMarks() %>">
		<br> <br> <input type="submit" value="UPDATE">

	</form>

	<%
		} else {
	%>

	<h3>Student not found!</h3>

	<%
		}
	%>



</body>
</html>