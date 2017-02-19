<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student list</title>
</head>
<body>
  	<h3>StudentList</h3>
  	<a href="<%=path %>/addStudent.jsp">Add Student</a><br/>
	<table border="1" width="70%">
   		<tr>
   			<td>Id</td>
   			<td>Name</td>
   		</tr>
   		<c:forEach items="${studentlist}" var="student">
   		<tr>
   			<td>${student.id }</td>
   			<td>${student.name }</td>
   			<td><a href="<%=path %>/studentController/deleteStudent.do?id=${student.id }">Delete</a></td>
   			<td><a href="<%=path %>/studentController/updateStudentUI.do?id=${student.id }">Update</a></td>
   		</tr>
   		</c:forEach>
   </table>
   
</body>
</html>