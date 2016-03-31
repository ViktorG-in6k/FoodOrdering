<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:url value="/resources/core/css/hello.css" var="coreCss"/>
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>

<c:forEach items="${allRestaurants}" var="restaurant">
    <div class="well col-md-9 pull-left">
        <form action="/events/${restaurant.getId()}">
            <c:if test="${not empty restaurant.getImageURL()}">
                <img src="${restaurant.getImageURL()}" class="img-thumbnail pull-left" width="200" height="100">
                <div class="text-info "><h2> ${restaurant.getName()}</h2></div>
                <div class="col-md-7 text-left">
                        ${restaurant.getDescription()}
                </div>
                <a class="btn btn-primary pull-right" href="/events/event_${eventId}/restaurant_${restaurant.getId()}">Participate</a>

            </c:if>
            <c:if test="${empty restaurant.getImageURL()}">
                <div class="text-info "><h2> ${restaurant.getName()}</h2></div>
                <div class="col-md-10 text-left">
                        ${restaurant.getDescription()}
                </div>
                <a class="btn btn-primary col-md-offset-10 pull-right" href="/events/event_${eventId}/restaurant_${restaurant.getId()}">Participate</a>

            </c:if>
        </form>
    </div>
</c:forEach>




