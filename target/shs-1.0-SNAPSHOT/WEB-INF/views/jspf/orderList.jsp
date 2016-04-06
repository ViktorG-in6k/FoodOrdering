<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:url value="/resources/core/css/hello.css" var="coreCss"/>
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>

<c:forEach items="${orderList}" var="item">
    <c:if test="${not empty userMail}">
<div class="well col-md-offset-2 col-md-8 pull-left">
    <table class="table">
        <thead>
            ${item.getRestaurant().getName()}
        <tr>
            <th>Item Name</th>
            <th>Price</th>
            <th>Count</th>
            <th>Cost</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach items="${item.getOrderList()}" var="prod">
            <tr>
                <td>${prod.getItem().getName()}</td>
                <td>${prod.getItem().getPrice()}</td>
                <td>${prod.getCount()}</td>
                <td>${prod.getCost()}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
    </c:if>
</c:forEach>









