<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>

	<title>List Customers</title>

	<link type="text/css"
			rel="stylesheet"
			href="${pageContext.request.contextPath}/resources/css/style.css">
</head>
<body>
	<div id="wrapper">
		<div id="heder">
			<h2>CRM - Customer Relationship Manager</h2>
		</div>
		<div id="container">
			<div id="content">
				<table>
					<tr>
						<th>First name</th>
						<th>Last name</th>
						<th>E-mail</th>
					</tr>
					<c:forEach var="tempCustomer" items="${customers}">
					
						<tr>
							<td>${tempCustomer.firstName}</td>
							<td>${tempCustomer.lastName}</td>
							<td>${tempCustomer.email}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>