<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert Data</title>
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

table tr td {
	padding: 30px;
}

table tr {
	text-align: center;
}

input {
	background-color: black;
	border-color: white;
	color: white;
	border-radius: 10px;
	width: 180px;
	height: 23px;
}

input:hover {
	background-color: white;
	color: black;
	border-radius: 10px;
}

button {
	border-radius: 6px;
	border-color: black;
	background: black;
	color: white;
	font-size: 18px;
}
</style>
</head>
<body>
	<h1>To Add In DataBase</h1>
	<form action="Add" method="get">
		<table>
			<tr>
				<td><label>Enter id for Mobile</label></td>
				<td><input type="number" name="mobileId" required="required" /></td>
			</tr>
			<tr>
				<td><label>Enter Mobile Brand</label></td>
				<td><input type="text" name="mobileBrand" required="required" /></td>
			</tr>
			<tr>
				<td><label>Enter the Model</label></td>
				<td><input type="text" name="mobileModel" required="required" /></td>
			</tr>
			<tr>
				<td><label>Enter The Year</label></td>
				<td><input type="number" name="year" required="required" /></td>
			</tr>
			<tr>
				<td><label>Enter the Price of mobile</label></td>
				<td><input type="number" name="mobilePrice" required="required" /></td>
			</tr>
			<tr>
				<td><button type="button" onclick="getHome()">Cancel</button></td>
				<td><button type="submit" onclick="getNote()">Submit</button></td>
			</tr>
		</table>
	</form>
	<script>
		function getHome() {
			window.location.href = "index.jsp";
		}
		function getNote() {
			alert("SuccessFully Added!!");
		}
	</script>
</body>
</html>