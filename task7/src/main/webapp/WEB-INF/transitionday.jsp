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

<form:form action="${pageContext.request.contextPath}/transitionday" method="POST" modelAttribute="transitionDayForm">
    <ul>
        <c:forEach var="i" begin="0" end="1">
            <li>${transitionDayForm.getFunds()[i]}</li>

            <form:label path="funds[${i}].fundSymbol">Symbol</form:label>
            <form:input readonly="readonly" path="funds[${i}].fundSymbol" required="required" />
            <form:errors path="funds[${i}].fundSymbol"/>

            <form:label path="funds[${i}].price">Price</form:label>
            <form:input path="funds[${i}].price" required="required" />
            <form:errors path="funds[${i}].price"/>
        </c:forEach>
            <br>

        <form:label path="date">Date</form:label>
        <form:input path="date" required="required" />
        <form:errors path="date"/>
    </ul>

    <button type="submit" class="btn btn-success">Submit</button>

</form:form>

</body>
</html>