<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">

<head>

    <title>Login Page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

</head>

<body>

Success
<form:form action="${pageContext.request.contextPath}/customer-console" method="post">
    <button type="submit" value="customer">customer console</button>
</form:form>
<form:form action="${pageContext.request.contextPath}/employee-console" method="post">
    <button type="submit" value="employee">employee console</button>
</form:form>
</body>
</html>