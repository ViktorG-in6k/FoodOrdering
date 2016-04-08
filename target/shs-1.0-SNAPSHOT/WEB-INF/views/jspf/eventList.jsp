<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<c:forEach items="${allEvents}" var="events">
    <div class="well col-md-9 pull-left">

        <form action="/events/${events.getId()}">
            <div class="col-md-3">
                <img src="${events.getImageURL()}" class="img-thumbnail  pull-left">
            </div>
            <label class="text-info col-md-7"
                   style="font-size: 19px; color: #000000;"> ${events.getName()}</label>

            <label class="pull-right">
                time
                    ${events.getDate().getHour()}:<c:if test="${events.getDate().getMinute()<10}">0</c:if>${events.getDate().getMinute()}

            </label>
            <div class="col-md-7">

                        ${events.getDescription()}

            </div>
            <div class="col-md-offset-10 row">
                <div class="col-md-12 pull-right">
                    <a class="btn btn-primary col-md-offset-4 col-md-2" style=" background-image: linear-gradient(to bottom,#28B7FF,#3573D0)" href="/events/event_${events.getId()}/order_list">Get
                        my order</a>

                    <a class="btn btn-primary col-md-offset-1 col-md-2" style=" background-image: linear-gradient(to bottom,#28B7FF,#3573D0)" href="/events/event_${events.getId()}/order_list">Get
                order</a>


                    <a class="btn btn-primary pull-right col-md-2 " style=" background-image: linear-gradient(to bottom,#28B7FF,#3573D0)"
                       href="/events/event_${events.getId()}">Participate</a>
                </div>
            </div>


        </form>
    </div>
</c:forEach>