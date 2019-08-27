<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>3.14 폼 생성</title>
</head>
<body>

<form action = "/00_book/Chaper03/D03_3_p77_Ch3_viewParameter.jsp" method="post" >
	<table border="1"> 
	<tr><td>Name 	</td><td> <input type = "text" name = "name" size = "30"> </td></tr>
	<tr><td>Address </td><td> <input type = "text" name = "address" size = "30"> </td></tr>
	<tr><td colspan="2">Favorite Animal </td></tr>
	<tr><td colspan="2">
		<input type = "Checkbox" name = "pet" value="dog">Dog
		<input type = "Checkbox" name = "pet" value="Cat">Cat
		<input type = "Checkbox" name = "pet" value="tiger">Tiger
		<input type = "Checkbox" name = "pet" value="lion">Lion
		<input type = "Checkbox" name = "pet" value="chicken">Chicken
	</td></tr>
	<tr><td colspan="2" align="center">
	<input type = "Submit" value="submit">
	</td></tr>
	</table>
</form>

</body>
</html>