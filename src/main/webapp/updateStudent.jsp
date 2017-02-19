<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<html>
	<head>
		<title>My JSP 'updateStudent.jsp' starting page</title>
	</head>

	<body>
		<form action="<%=path %>/studentController/updateStudent.do" method="POST">
<!--			<input type="hidden" name="id" value="${student.id }"> -->
			<table>
				<tr>
					<td>
						id: 
					</td>
					<td>
						<input type="text" name="id" value="${student.id }">
					</td>
				</tr>
				<tr>
					<td>
						name:
					</td>
					<td>
						<input type="text" name="name" value="${student.name }">
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" value="Update">
					</td>
					<td>
						<input type="reset" value="Reset">
					</td>
				</tr>
			</table>
		</form>
	</body>
</html>
