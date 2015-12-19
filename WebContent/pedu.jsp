<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Upload File</title>
</head>
<body>
	<h1>
		<form action="fileUploader" method="post" enctype="multipart/form-data">
			<input type="text" name="description" /> <input type="file"
				name="file" /> <input type="submit" />
		</form>
	</h1>
</body>
</html>