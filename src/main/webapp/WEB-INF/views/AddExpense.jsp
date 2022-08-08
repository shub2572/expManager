<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@page import="com.bean.CategoryBean"%>
<%@page import="java.util.List"%>
<%@page import="com.bean.AccountBean"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Expense</title>
</head>

<body>
<jsp:include page="UserHeader.jsp"></jsp:include>

<%List<AccountBean> accounts = (List<AccountBean>)request.getAttribute("accounts"); %>
<%-- <%List<CategoryBean> categories = (List<CategoryBean>)request.getAttribute("categories"); %> --%>
<h2 style="text-align: center;">Add New Expense</h2>
<div class="container-fluid">
<s:form method="post" action="addexpenses" modelAttribute="expBean">

		<s:input path="expName" placeholder="Expense Name"/>
		<s:errors class="error" path="expName"></s:errors>
		<br>
		<br>
		<s:input path="expLocation" placeholder="Expense Place"/> 
		<s:errors class="error" path="expLocation"></s:errors>
		<br>
		<br>
		<s:select class="form-select mt-3" path="expCat" id="category">
               <option selected disabled value="">Select Category</option>
               
               <c:forEach items="${categories}" var="category">
               
               <option value="${category.catId}">${category.catName}</option>
               
               </c:forEach>
        </s:select>
        <s:errors path="expCat"></s:errors>
        <br>
		<br>
		<s:select class="form-select mt-3" path="expSubCat" id="subcategory">
               <option selected disabled value="">Select SubCategory</option>

        </s:select>
        <s:errors path="expSubCat"></s:errors>
        <br>
		<br>
        <s:select class="form-select mt-3" path="accType" id="accType">
            <option selected disabled value="">Select Account Type</option>
            <%for(AccountBean a : accounts) {%><option value="<%=a.getAcctype()%>"><%=a.getAcctype()%></option><%} %>
        </s:select>
        <s:errors path="accType"></s:errors>
        <br>
		<br>
		
		<s:select class="form-select mt-3" path="accId">
            <option selected disabled value="">Select Account</option>
        </s:select>
        <s:errors path="accId"></s:errors>
        <br>
		<br>
		
		<s:input path="expAmount" placeholder="Expense Amount"/>
		<s:errors class="error" path="expAmount"></s:errors>
		<br>
		<br>
		Date Time:
		<input type="date" id="date" name="date">
		<input type="time" id="time" name="time">
		<br>
		<br>
		
		<input type="submit" value="Add Expense" />
	</s:form>
	</div>
	
<script>

document.getElementById('date').value = new Date().toISOString().substring(0, 10);
/* document.getElementById('date').value = new Date().toLocaleDateString(); */
document.getElementById('time').value = Date().slice(16,21);




$(document).ready(function(){
	$("#category").change(function(){
		var id = document.getElementById("category").value;
				let url = "http://localhost:9889/subcategories?catId="+id;	
				 	 
				$.get(url)
				.done(function(data){
					console.log(data);
					let subcategory = $("#subcategory");
					subcategory.empty();
					for(let i=0;i<data.length;i++){ 
						subcategory.append("<option value="+data[i].subCatId+">"+data[i].subCatName+"</option>");
					}
					
				}).fail(function(){
					console.log(" SMW :: in category AJAX"); 
				});
	})	
})


  $(document).ready(function(){
	$("#accType").change(function(){
		var name = document.getElementById("accType").value;
				let url = "http://localhost:9889/accnames?accType="+name;	
				 	 
				$.get(url)
				.done(function(data){
					console.log(data);
					let accounts = $("#accId");
					accounts.empty();
					for(let i=0;i<data.length;i++){ 
						accounts.append("<option value="+data[i].accId+">"+data[i].accName+" "+data[i].accNumber+" - Balance:"+data[i].accBalance+"</option>");
					}
					
				}).fail(function(){
					console.log("something went wrong in accType AJAX"); 
				});
	})	
})  
</script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js" integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4=" crossorigin="anonymous"></script>

</body>
</html>