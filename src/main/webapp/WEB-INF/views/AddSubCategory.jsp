<%@page import="java.util.List"%>
<%@page import="com.bean.CategoryBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Sub Category</title>
</head>
<body>
<jsp:include page="UserHeader.jsp"></jsp:include>

<%
List<CategoryBean> categories = (List<CategoryBean>) request.getAttribute("categories");
%>

<h2>Add Sub Category</h2>
<s:form method="post" action="addsubcategory" modelAttribute="catBean">

 Select Category Name : 
<s:select class="form-select mt-3" path="catId">categories
      <option selected disabled value="">Select Category</option>
      <%for(CategoryBean category : categories) {%><option value="<%=category.getCatId()%>"><%=category.getCatName()%></option><%} %>
</s:select>
<s:errors path="catName"></s:errors>

 Select Sub Category Name : <s:input path="subCatName"/>
<s:errors path="subCatName"></s:errors>

<input type="submit">
</s:form>

</body>
</html>