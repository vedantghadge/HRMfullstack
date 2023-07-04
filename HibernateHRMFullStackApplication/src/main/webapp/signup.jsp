<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HRM SIGNUP</title>
</head>
<body style="background-color: pink;">

<form action="EmployeeController" method="get">

<input type="hidden" name="action" value="signup">

Name<input type="text" name="empname"><br> 
Address<input type="text" name="empaddress"><br>             
Contact Number<input type="text" name="empcontactnumber"><br>               
Salary<input type="text" name="empsalary"><br> 
Gender<br>
Male<input type="radio" name="empgender" value="Male"><br> 
Female<input type="radio" name="empgender" value="Female"><br> 

Age<input type="text" name="empage"><br> 
UID<input type="text" name="empuid"><br> 
PAN<input type="text" name="emppancardnumber"><br> 
DOB<input type="text" name="empdob"><br> 
Email<input type="email" name="empemailid"><br> 
Password<input type="password" name="emppassword"><br> 

<input type="submit" value="SignUp"><br> 

</form>

</body>
</html>