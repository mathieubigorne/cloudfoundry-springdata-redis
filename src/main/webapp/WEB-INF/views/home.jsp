<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>cloudfoundry-springdata-redis</h1>


<h1>Liste (${fn:length(todos)})</h1>
<ul>
	<c:forEach var="todo" items="${todos}">
		<li>${todo.name}</li>
	</c:forEach>
</ul>
</body>
</html>
	