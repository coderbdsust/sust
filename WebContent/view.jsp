<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Page</title>
</head>
<body>
<h1>Animal Lists!</h1>
<c:forEach var="animal" items="${animals}">
<p>${animal}</p><br/>
</c:forEach>
</body>
</html>