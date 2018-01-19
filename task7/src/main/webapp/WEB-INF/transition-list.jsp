<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">

<head>

    <title>Transition List</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

</head>

<body>
<c:if test="${not empty transitions}">

    <ul>
        <c:forEach var="transition" items="${transitions}">
            <li>${transition}</li>
        </c:forEach>
    </ul>

</c:if>

</body>
</html>