<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<!doctype html>
<html lang="en">

<head>

    <title>Deposit</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
</head>

<body>

<form:form action="${pageContext.request.contextPath}/deposit" method="POST" modelAttribute="depositForm">

    <form:label path="username">Username</form:label>
    <form:input path="username" required="required" />
    <form:errors path="username"/>

    <form:label path="amount">Amount</form:label>
    <form:input path="amount" required="required" />
    <form:errors path="amount"/>

    <button type="submit" class="btn btn-success">Deposit</button>

</form:form>

</body>
</html>
