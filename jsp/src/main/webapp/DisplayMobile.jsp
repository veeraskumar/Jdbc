<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Display table from DB</title>
<style>
body {
	background-color: black;
	color: white;
	font-family: cursive;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
}

h1 {
	font-size: 36px;
	text-shadow: 3px 3px red;
}

table {
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	height: fit-content;
	width: fit-content;
	font-size: 18px;
	border-color: white;
	border-radius: 20px;
	background-color: gray;
}

table tr td, th {
	padding: 25px;
}

table tr {
	text-align: center;
}

a {
	color: lime;
	text-decoration: none;
	cursor: pointer;
}

a:hover {
	color: yellow;
}
</style>
</head>
<body>
	<%
		ResultSet rs = (ResultSet) request.getAttribute("MobileList");
	%>
	<h1>Mobile DataBase</h1>
	<table>
		<tr>
			<th>Mobile Id</th>
			<th>Mobile Brand</th>
			<th>Mobile Model</th>
			<th>Year</th>
			<th>Price</th>
			<th>Update</th>
			<th>Delete</th>
		</tr>
		<%
			while (rs.next()) {
		%>
		<tr>
			<td><%=rs.getInt(1)%></td>
			<td><%=rs.getString(2)%></td>
			<td><%=rs.getString(3)%></td>
			<td><%=rs.getInt(4)%></td>
			<td><%=rs.getInt(5)%></td>
			<td><a href="Update-Mob?mobileId=<%=rs.getInt(1)%>">Update</a></td>
			<td><a href="Delete-Mob?mobileId=<%=rs.getInt(1)%>">Delete</a></td>
		</tr>
		<%
			}
		%>
	</table>
	<a href="index.jsp">Home</a>
</body>
</html>