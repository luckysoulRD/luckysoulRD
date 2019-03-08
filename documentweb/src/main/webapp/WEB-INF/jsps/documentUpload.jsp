<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Document Upload</title>
</head>
<body>
	<form action="/upload" method="post" enctype="multipart/form-data">
		<pre>
		 ID:<input type="text" name="id">
         Documents:<input type="file" name="document">
         <input type="submit" value="Upload" name="submit">
        </pre>
	</form>

	<table>
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Link</th>
		</tr>
		<c:forEach var="documents" items="${documents}">
			<tr>
				<td>${documents.id }</td>
				<td>${documents.name}</td>
				<td><a href="/download?id=${documents.id}">download</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>