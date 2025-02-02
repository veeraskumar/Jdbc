<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Welcome to Mobile dashboard</title>
<style>
body {
	font-family: cursive;
	background-color: black;
	color: white;
}

h1 {
	text-align: center;
	text-shadow: 4px 4px red;
	text-transform: uppercase;
	font-size: 40px;
	text-decoration: underline;
}

a {
	color: lime;
	text-decoration: none;
	cursor: pointer;
}

a:hover {
	color: yellow;
}

div {
	height: 300px;
	width: 400px;
	margin: auto;
	margin-top: 100px;
	display: flex;
	flex-direction: column;
	justify-content: center;
	align-items: center;
	background-color: gray;
	border-radius: 25px;
}
</style>
</head>
<body>
	<h1>Welcome to Mobile DashBoard</h1>
	<div>
		<h3>
			<a href="AddMobile.jsp">Add Mobile</a>
		</h3>
		<h3>
			<a href="omg">Display DB</a>
		</h3>

	</div>
</body>
</html>