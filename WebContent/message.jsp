<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c'%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Page</title>
</head>
<body>
<h1><c:out value="${message}" /></h1>
<p>Click <a href='<c:out value="${fileDirectory}"/>'  target="_blank">here</a></p>
</body>
</html>