<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Category</title>
</head>
<body>
<jsp:include page="UserHeader.jsp"></jsp:include>

<h2>Add Category</h2>
<s:form method="post" action="addcategory" modelAttribute="catBean">

Enter Category Name : <s:input path="catName"/>
<s:errors path="catName"></s:errors><br>
Enter Sub Category Name : <s:input path="subCatName"/>
<s:errors path="subCatName"></s:errors><br>

<input type="submit">
</s:form>

</body>
</html>