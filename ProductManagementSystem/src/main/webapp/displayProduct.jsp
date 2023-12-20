<%@page import="java.util.Iterator"%>
<%@page import="com.pms.entity.Products"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<table border="1">
	<tr>
		<th>PId</th>
		<th>PName</th>
		<th>Price</th>
		<th>URL</th>
	</tr>
	<%
		Object obj = session.getAttribute("product");
		List<Products> listOfProduct = (List<Products>)obj;
		Iterator<Products> li = listOfProduct.iterator();
		while(li.hasNext()){
			Products p = li.next();
			%>
			<tr>
				<td><%=p.getPid()%> </td>
				<td><%=p.getPname()%> </td>
				<td><%=p.getPrice()%> </td>
				<td><img src=<%=p.getUrl()%> width="50px" height="50px"/> </td>
			</tr>
			<%
		}
	%>
</table>
<br/>
<a href="index.jsp">Back</a>

</body>
</html>