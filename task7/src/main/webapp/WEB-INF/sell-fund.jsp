<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!doctype html>
<html lang="en">

<head>

    <title>sell fund</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>

<body>

<form:form action="${pageContext.request.contextPath}/sellfund" method="POST" modelAttribute="sellForm">

    <form:label path="fundSymbol">Fund Symbol</form:label>
    <form:input path="fundSymbol" required="required" />
    <form:errors path="fundSymbol"/>

    <form:label path="share">Share</form:label>
    <form:input path="share" required="required" />
    <form:errors path="share"/>

    <button type="submit" class="btn btn-success">Sell</button>

</form:form>

</body>
</html>
