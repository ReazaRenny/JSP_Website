<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="userbean.UserBean"%>
<%@ page import="dao.UserDao"%>
<%@ page import="java.util.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>All User</title>
</head>
<body>
<%
%>
<table border="1">
	<tr>
		<th>Id</th>
		<th>First Name</th>
		<th>Last Name</th>
	</tr>
	<tr>
		<%
			UserDao dao = new UserDao();
			List<UserBean> users = dao.getAllUsers();
			for (UserBean user : users) {
		%>
		<td><%=user.getCustomerId()%></td>
		<td><%=user.getCustFirstName()%></td>
		<td><%=user.getCustLastName()%></td>
		<td><a
			href="UserHandler?action=editform&userId=<%=user.getCustomerId()%>">Update</a></td>
		<td><a
			href="UserHandler?action=delete&userId=<%=user.getCustomerId()%>">Delete</a></td>

	</tr>
	<%
		}
		//}
	%>
</table>
<p><a href="UserHandler?action=insert">Add User</a></p>
</body>
</html>