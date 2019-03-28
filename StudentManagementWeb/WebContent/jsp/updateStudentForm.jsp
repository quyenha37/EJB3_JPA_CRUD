<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>

<%@include file="layout/header.jsp" %>

<body>

	<%@include file="layout/topNav.jsp" %>
	
	<div class="container">
		<h2>Edit Student</h2>

		<form action="update" method="POST">
		  <div class="form-group">
		  	<input type="hidden" name="id" value="<c:out value='${student.id}'/>"/>
		  </div>
		  
		  <div class="form-group">
		    <label for="firstName">First Name:</label>
		    <input type="text" class="form-control" id="firstName" name="firstName" 
		    	   value="<c:out value='${student.firstName}'/>"/>
		  </div>
		  
		  <div class="form-group">
		    <label for="lastName">Last Name:</label>
		    <input type="text" class="form-control" id="lastName" name="lastName"
		    	   value="<c:out value='${student.lastName}'/>"/>
		  </div>
		
		  <div class="form-group">
		    <label for="email">Email address:</label>
		    <input type="text" class="form-control" id="email" name="email"
		    	   value="<c:out value='${student.email}'/>"/>
		  </div>
		  <button type="submit" class="btn btn-primary">Update</button>
		</form>
	</div>
</body>
</html>

	
	
	
