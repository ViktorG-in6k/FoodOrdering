<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>

<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>

<%--<spring:url value="/resources/core/css/hello.css" var="coreCss"/>--%>
<%--<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>--%>


<%--<div class="well col-md-9 pull-left">--%>
    <%--<table class="table">--%>
        <%--<thead>--%>
        <%--<tr>--%>
            <%--<th>Item Name</th>--%>
            <%--<th>Price</th>--%>
            <%--<th>Count</th>--%>
            <%--<th>Cost</th>--%>
        <%--</tr>--%>
        <%--</thead>--%>

        <%--<tbody>--%>
        <%--<c:forEach items="${orderList}" var="item">--%>
            <%--<tr>--%>
                <%--<td>${item.getItem.getName()}</td>--%>
                <%--<td>${item.getItem.getPrice()}</td>--%>
                <%--<td>${item.getCount()}</td>--%>
                <%--<td>${item.getCost()}</td>--%>
            <%--</tr>--%>
        <%--</c:forEach>--%>
        <%--</tbody>--%>
    <%--</table>--%>
<%--</div>--%>


<<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:url value="/resources/core/css/hello.css" var="coreCss"/>
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>

<c:forEach items="${orderList}" var="restaurant">
    <div class="well col-md-9 pull-left">
        <form action="/events/${restaurant.getId()}">
            <img src="${restaurant.getImageURL()}" class="img-thumbnail pull-left" width="200" height="100">
            <div class="text-info "><h2> ${restaurant.getName()}</h2></div>
            <div class="col-md-7 text-left">
                    ${restaurant.getDescription()}
            </div>
            <a class="btn btn-primary pull-right" href="/events/event_${eventId}/restaurant_${restaurant.getId()}">Go to menu</a>
        </form>
    </div>
</c:forEach>







