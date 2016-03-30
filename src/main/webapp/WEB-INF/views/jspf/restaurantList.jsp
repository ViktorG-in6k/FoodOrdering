<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:url value="/resources/core/css/hello.css" var="coreCss"/>
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>

<c:forEach items="${allRestaurants}" var="events">
    <div class="well col-md-9 pull-left">
        <form action="/events/${events.getId()}">
            <c:if test="${not empty events.getImageURL()}">
                <img src="${events.getImageURL()}" class="img-thumbnail pull-left" width="200" height="100">
                <div class="text-info "><h2> ${events.getName()}</h2></div>
                <div class="col-md-7 text-left">
                        ${events.getDescription()}
                </div>
            </c:if>
            <c:if test="${empty events.getImageURL()}">
                <div class="text-info "><h2> ${events.getName()}</h2></div>
                <div class="col-md-10 text-left">
                        ${events.getDescription()}
                </div>
            </c:if>
        </form>
    </div>
</c:forEach>




