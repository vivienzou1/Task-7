<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!doctype html>
<html lang="en">

<head>

    <title>Register</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>

<body>
<!-- Register Form -->
<form:form action="${pageContext.request.contextPath}/newfund" method="POST" modelAttribute="fundCreateForm">

    <form:errors/>
    <form:label path="fundName">Fund Name</form:label>
    <form:input path="fundName" required="required" />
    <form:errors path="fundName"/>

    <form:label path="fundSymbol">Fund Symbol</form:label>
    <form:input path="fundSymbol" required="required" />
    <form:errors path="fundSymbol"/>

    <form:label path="price">Price</form:label>
    <form:input path="price" required="required" />
    <form:errors path="price"/>

    <button type="submit" class="btn btn-success">Create</button>

</form:form>

</body>
</html>
