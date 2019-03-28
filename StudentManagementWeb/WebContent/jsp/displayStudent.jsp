<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<%@include file="layout/header.jsp" %>
<body>
	<%@include file="layout/topNav.jsp" %>
	<div class="container">
		<h1>Display Students</h1>
		
	    <div class="table-responsive">
		  <table class="table table-striped">
	            <thead>
		            <tr>
		                <th>Student ID</th>
		                <th>First Name</th>
		                <th>Last Name</th>
		                <th>Email</th>
		                <th>Edit Action</th>
		                <th>Delete Action</th>
		            </tr>
	            </thead>
	            <tbody>
	            <c:forEach var="student" items="${students}">
	                <tr>
	                    <td><c:out value="${student.id}" /></td>
	                    <td><c:out value="${student.firstName}" /></td>
	                    <td><c:out value="${student.lastName}" /></td>
	                    <td><c:out value="${student.email}" /></td>
	                    <td>
	                    	<a href="edit?id=<c:out value='${student.id}'/>">Edit</a>
	                    </td>
	                    <td>
	                    	<a href="delete?id=<c:out value='${student.id}'/>">Delete</a>
	                    </td>
	                </tr>
	            </c:forEach>
	            </tbody>
		  </table>
		</div>
	</div>
</body>
</html>