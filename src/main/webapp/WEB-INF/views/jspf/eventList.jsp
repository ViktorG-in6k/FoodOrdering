<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:forEach items="${allEvents}" var="events">
    <div class="well col-md-9 pull-left">
        <form action="/events/${events.getId()}">
            <c:if test="${not empty events.getImageURL()}">
                <img src="${events.getImageURL()}" class="img-thumbnail pull-left" width="200" height="100">
                <div class="text-info "><h2> ${events.getName()}</h2></div>

                <label class=" col-lg-offset-1 pull-right">
                        ${events.getDate()}
                </label>
                <div class="col-md-7 text-left">
                        ${events.getDescription()}
                </div>
                <a class="btn btn-primary pull-right" href="/events/event_${events.getId()}">Participate</a>

            </c:if>
            <c:if test="${empty events.getImageURL()}">
                <div class="text-info "><h2> ${events.getName()}</h2></div>
                <label class="pull-right">
                        ${events.getDate()}
                </label>
                <div class="col-md-10 text-left">
                        ${events.getDescription()}
                </div>
                <a class="btn btn-primary col-md-offset-10 pull-right" href="/events/event_${events.getId()}">Participate</a>
            </c:if>
        </form>
    </div>
</c:forEach>