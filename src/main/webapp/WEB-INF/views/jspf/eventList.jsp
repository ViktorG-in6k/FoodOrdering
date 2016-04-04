<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:forEach items="${allEvents}" var="events">
    <div class="well col-md-9 pull-left">

        <form action="/events/${events.getId()}">

            <img src="${events.getImageURL()}" class="img-thumbnail col-md-3 pull-left">

            <label class="text-info col-md-7"
                   style="font-size: 19px; color: #000000;"> ${events.getName()}</label>

            <label class="pull-right">
                time
                    ${events.getDate().getHour()}:<c:if test="${events.getDate().getMinute()<10}">0</c:if>${events.getDate().getMinute()}

            </label>
            <div class="col-md-9 ">
                <div class="col-md-10 ">
                        ${events.getDescription()}
                </div>
            </div>
            <a class="btn btn-primary col-md-offset-7 col-md-2 " href="/events/event_${events.getId()}/order_list">Get
                order</a>


            <a class="btn btn-primary col-md-offset-7 col-md-2   "
               href="/events/event_${events.getId()}">Participate</a>

        </form>
    </div>
</c:forEach>