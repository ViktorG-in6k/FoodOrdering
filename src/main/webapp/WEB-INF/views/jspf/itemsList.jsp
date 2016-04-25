<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:forEach items="${Menu}" var="item">
    <div class="well col-md-8 pull-left">
        <form role="form" action="/add_to_order" method="post">
            <label class="text-info col-md-7"
                   style="font-size: 19px; color: #000000;">${item.getName()}</label>
            <label class="text-info  pull-right" style="font-size: 19px; color: #000000;">
                {{${item.getPrice()} | currency :"UAH"}}
            </label>
            <div class="col-md-7 text-left">
                    ${item.getDescription()}
            </div>
            <input type="hidden" value="${eventId}" name="event_id">
            <input type="hidden" value="${item.getId()}" name="item_id">
        </form>
    </div>
</c:forEach>


