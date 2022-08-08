<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Account</title>
</head>

<style>
.error{
	color:red;
}

</style>
<body>
<jsp:include page="UserHeader.jsp"></jsp:include>



                        <h3>Add Account Details</h3>
                        <p>Fill in the data below.</p>
                        <s:form class="requires-validation" action="addaccount" method="post" modelAttribute="account">
						
                            <div class="col-md-12">
                               <s:input class="form-control" path="accname" placeholder="Account Name"/>
                               <s:errors class="error" path="accname"></s:errors>
                            </div>

                            <div class="col-md-12">
                                <s:input class="form-control" path="accnumber" placeholder="Account Number"/>
                                <s:errors class="error" path="accnumber"></s:errors>
                            </div>
                            
                           <div class="col-md-12">
	                           <s:input class="form-control" path="acctype" placeholder="Account Type"/>
                                <s:errors class="error" path="acctype"></s:errors>
                               <%--  <s:select class="form-select mt-3" path="accType">
                                      <option selected disabled value="">Account Type</option>
                                      <option value="Cash">Cash</option>
                                      <option value="Paytm">Paytm</option>
                                      <option value="Credit Card">Credit Card</option>
                                      <option value="Debit Card">Debit Card</option>
                               </s:select>
                               <s:errors path="accType"></s:errors> --%>
                           </div>

						   <div class="col-md-12">
                               <s:input class="form-control" path="accbalance" placeholder="Account Balance"/>
                               <s:errors class="error" path="accbalance"></s:errors> <!--  <div class="invalid-feedback"></div> -->
                           </div>
                           
                            <div class="form-button mt-3">
                                <input type="submit" class="btn btn-primary" value="Add">
                            </div>
                        </s:form>
                   
</body>
</html>