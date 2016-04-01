<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:forEach items="${allEvents}" var="events">
    <div class="well col-md-9 pull-left">
        <form action="/events/${events.getId()}">
            <img src="${events.getImageURL()}" class="img-thumbnail pull-left" width="200" height="100">
            <div class="text-info "><h2> ${events.getName()}</h2></div>

            <label class=" col-lg-offset-1 pull-right">
                time
                    ${events.getDate().getHour()}:<c:if test="${events.getDate().getMinute()<10}">0</c:if>${events.getDate().getMinute()}

            </label>
            <div class="col-md-7 text-left">
                    ${events.getDescription()}
            </div>
            <div class="col-md-offset-12">
            <a class="btn btn-primary pull-right" href="/events/event_${events.getId()}/order_list">Get order</a>
            </div>
            <div class="col-md-offset-12">
                <a class="btn btn-primary pull-right" href="/events/event_${events.getId()}">Participate</a>
            </div>
        </form>
    </div>
</c:forEach>