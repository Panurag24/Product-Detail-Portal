<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2>Delete Product</h2>
<form action="ProductController" method="post">
	<input type="hidden" name="operation" value="delete">
<label>PId</label>
<input type="number" name="pid"/><br/>
<input type="submit" value="Delete Product"/>
<input type="reset" value="reset"/>
</form>
<br/>
<a href="index.jsp">Back</a>

</body>
</html>