<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!doctype html>
<html lang="en">

<head>

    <title>customer</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

</head>

<body>
<h1>buy fund</h1>
<%@ include file="buy-fund.jsp" %>
<h1>sell fund</h1>
<%@ include file="sell-fund.jsp" %>
<h1>request check</h1>
<%@ include file="withdraw.jsp" %>
<h1>fund list</h1>
<%@ include file="fund-list.jsp" %>
</body>
</html>