<%@page import="packages.Packages"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="userbean.UserBean"%>
<%@ page import="dao.PackageDao"%>
<%@ page import="java.util.*"%>
<%@ page import="dao.UserDao"%>
<%@ page import="login.Login"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

Hello, User#: <%= session.getAttribute("id")%>
<table border="1">
	<tr>
		<th>Id</th>
		<th>Package Name</th>
		<th>Package Start Date</th>
		<th>Package End Date</th>
		<th>Package Description</th>
		<th>Package Base Price</th>
		<th>Package Booking ID</th>
		<th>Package Booking Date</th>
		<th>Package Traveler Count</th>
	</tr>
	<tr>
			<%
			//int userId = Integer.parseInt(request.getParameter("userId"));
			
			
			PackageDao pkg  = new PackageDao();
			List<Packages> pkgs = pkg.getPackagesForCustomer((String)session.getAttribute("id"));
			for (Packages pk : pkgs) {
		%>
		
		<td><%=pk.getPackageId()%></td>
		<td><%=pk.getPkgName()%></td>
		<td><%=pk.getPkgStartDate()%></td>
		<td><%=pk.getPkgEndDate()%></td>
		<td><%=pk.getPkgDesc()%></td>
		<td><%=pk.getPkgBasePrice()%></td>
		<td><%=pk.getBookingId()%></td>
		<td><%=pk.getBookingDate()%></td>
		<td><%=pk.getTravelerCount()%></td>

	</tr>
	<%
		}
		//}
	%>
</table>

</body>
</html>