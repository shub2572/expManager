<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"  isELIgnored="false"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<style>
.error{
	color: red;
}
</style>
<body>
	<h2>Login</h2>

<s:form method="post" action="authenticate" modelAttribute="user">

Email : <s:input  path="email"/>
<s:errors class="error" path="email"></s:errors>
<br><br>
Password : <s:password path="password"/>
<s:errors class="error" path="password"></s:errors>
<br><br>

<input type="submit" value="Login">
</s:form> 
<a href="signup" style="text-decoration: none">Create New Account ?</a>	
<br><br>
${errorLogin}
${successSignup}	

</body>
</html>