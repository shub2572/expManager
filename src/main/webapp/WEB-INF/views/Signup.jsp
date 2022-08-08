<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>SignUp</title>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/css/bootstrap.min.css"
	integrity="sha384-TX8t27EcRE3e/ihU7zmQxVncDAy5uIKz4rEkgIXeMed4M0jlfIDPvg6uqKI2xXr2"
	crossorigin="anonymous">
</head>
<style>
.error {
	color: red;
}
</style>
<body>
	<h2 style="text-align: center;">Sign Up</h2>
	<div class="container">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-6"> 
				<s:form method="post" action="signup" modelAttribute="user">
		First Name : <s:input path="firstName" />
					<s:errors class="error" path="firstName"></s:errors>
					<br>
					<br>
		Last Name : <s:input path="lastName" />
					<s:errors class="error" path="lastName"></s:errors>
					<br>
					<br>
		Email : <s:input path="email" />
					<s:errors class="error" path="email"></s:errors>
					<br>
					<br>
		Password : <s:password path="password" />
					<s:errors class="error" path="password"></s:errors>
					<br>
					<br>
		Gender : Male <s:radiobutton path="gender" value="male" />
				 Female <s:radiobutton path="gender" value="female" />
					<s:errors class="error" path="gender"></s:errors>
					<br>
					<br>
					<input type="submit" value="Sign Up" />
				</s:form>

				<a href="login" style="text-decoration: none">Already have an
					Account ?</a> <br> ${errorSignup}
			</div>
		</div>
	</div>
</body>
</html>