<%@page import="com.stackoverme.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>StackOverMe! User Dashboard</title>
<link rel="stylesheet" href="styles.css" />
</head>
<body>
	<% User obj = (User) request.getAttribute("userObj"); %>
	<div class="center">
	<div class="locationForm">
      <h1>StackOverMe!</h1>
      <div class="loading">
      <div class="dot dot1"></div>
      <div class="dot dot2"></div>
      <div class="dot dot3"></div>
    </div>
    
      <h1>User Details</h1>
    	
    	<h4>Name of the user - <%= obj.getName() %></h4>
    	<h4>Mobile of the user -<%= obj.getMobileNumber() %></h4>
    	<h4>Email of the user -<%= obj.getEmail() %></h4>
    	<a href="/MiniProject">Logout</a>
  </div>
	</div>
<script src="index.js" type="text/javascript" defer></script>
</body>
</html>