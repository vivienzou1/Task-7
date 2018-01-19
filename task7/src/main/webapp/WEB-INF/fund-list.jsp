<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">

<head>

    <title>Fund List</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

</head>

<body>
<c:if test="${not empty funds}">

    <ul>
        <c:forEach var="fund" items="${funds}">
            <li>${fund}</li>
        </c:forEach>
    </ul>

</c:if>

</body>
</html>