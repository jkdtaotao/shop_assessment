<!DOCTYPE html>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html lang="en">
<head>
    <script src="webjars/jquery/3.1.1/jquery.min.js"></script>
    <script src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" type="text/css"
          href="webjars/bootstrap/3.3.7/css/bootstrap.min.css"/>
    <!--
	<spring:url value="/css/main.css" var="springCss" />
	<link href="${springCss}" rel="stylesheet" />
	 -->
    <c:url value="../css/main.css" var="jstlCss"/>
    <link href="${jstlCss}" rel="stylesheet"/>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Demo</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
            <ul class="nav navbar-nav">
                <li class="active"><a href="#">Home</a></li>
            </ul>
        </div>
    </div>
</nav>

<div class="container">
    <div class="starter-template">
        <h2>Currently available in our shop:</h2>
        <table class="table">
            <thead class="thead-dark">
            <tr>
                <th>Name</th>
                <th>Stock</th>
            </tr>
            <c:forEach items="${stock.orders}" var="order">
                <tr>
                    <td>Item ${order.name}:</td>
                    <td>${order.quantity} left</td>
                </tr>
            </c:forEach>
        </table>
    </div>
    <div class="starter-template">
        <h2>Your shopping:</h2>
        <%--@elvariable id="orderForm" type="orderForm"--%>
        <form:form method="post" action="order" modelAttribute="orderForm">
            <table class="table">
                <thead class="thead-dark">
                <tr>
                    <th>No</th>
                    <th>Name</th>
                    <th>Quantity</th>
                </tr>
                <c:forEach items="${stock.orders}" var="order" varStatus="status">
                    <tr>
                        <td align="center">${status.count}</td>
                        <td><input name="orders[${status.index}].name" value="${order.name}" readonly/></td>
                        <td><input name="orders[${status.index}].quantity" value="1"/></td>
                    </tr>
                </c:forEach>
            </table>
            <br/>
            <input type="submit" value="Buy"/>
        </form:form>
    </div>
</div>

<script type="text/javascript"
        src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>
