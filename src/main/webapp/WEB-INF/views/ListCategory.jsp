<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Account List</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.datatables.net/1.12.1/css/jquery.dataTables.min.css">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.2/css/all.css">
</head>
<body>
	<jsp:include page="UserHeader.jsp"></jsp:include>

	<div class="container">
		<div class="row">
			<div class="col-md-1"></div>
			<div class="col-md-10">
				<h2 align="center">Account List</h2>
				<br>


				<table id="users" class="table display">
					<thead class="thead-dark">
						<tr>
			<th>Category Id</th>
			<th>Category Name</th>
			<th>Action</th>
		</tr>
		</thead>
		<tbody>
		<c:forEach items="${category}" var="x">
			<tr>
				<td>${x.catId}</td>
				<td>${x.catName}</td>
		         <td><a href="deleteCategory?catId=">DELETE</a> | <a
					href="editCategory?catId=">EDIT</a></td>
			</tr>
		</c:forEach>


					</tbody>
				</table>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script type="text/javascript"
		src="https://cdn.datatables.net/1.12.1/js/jquery.dataTables.min.js"></script>
	<script>
		$(document).ready(function() {
			$('#users').DataTable();
		});
	</script>

</body>
</html>

