<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<%@include file="layout/header.jsp" %>

<body>

	<%@include file="layout/topNav.jsp" %>
	
	<div class="container">
		<h2>Add Student</h2>

		<form action="add" method="POST">
		  <div class="form-group">
		    <label for="fName">First Name:</label>
		    <input type="text" class="form-control" id="firstName" name="firstName">
		  </div>
		  
		  <div class="form-group">
		    <label for="lName">Last Name:</label>
		    <input type="text" class="form-control" id="lastName" name="lastName">
		  </div>
		
		  <div class="form-group">
		    <label for="email">Email address:</label>
		    <input type="email" class="form-control" id="email" name="email">
		  </div>
		  <button type="submit" class="btn btn-primary">Submit</button>
		</form>
	</div>
</body>
</html>

	
	
	
