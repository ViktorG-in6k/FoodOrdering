<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:url value="/resources/core/css/hello.css" var="coreCss"/>
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>

<c:forEach items="${allRestaurants}" var="restaurant">
    <div class="well col-md-9 pull-left">
        <form action="/app/events/${restaurant.getId()}">
            <img src="${restaurant.getImageURL()}" class="img-thumbnail pull-left" width="200" height="100">
            <label class="text-info col-md-7"
                   style="font-size: 19px; color: #000000;">${restaurant.getName()}</label>

            <div class="col-md-7 text-left">
                    ${restaurant.getDescription()}
            </div>
            <a class="btn btn-primary pull-right" href="/app/events/event_${eventId}/restaurant_${restaurant.getId()}">Go to menu</a>
        </form>
    </div>
</c:forEach>




