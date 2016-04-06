<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<c:forEach items="${Menu}" var="item">

    <div class="well col-md-9 pull-left">
        <form role="form" action="/app/add_to_order" method="post">
            <div class=" col-md-3 ">
                <img src="${item.getImageURL()}" class="img-thumbnail" width="200" height="100">
            </div>
            <label class="text-info col-md-7"
                   style="font-size: 19px; color: #000000;">${item.getName()}</label>


            <div class="col-md-7 text-left">

                    ${item.getDescription()}
            </div>
            <div class="pull-right">
                    ${item.getPrice()}
            </div>
            <input type="hidden" value="${eventId}" name="event_id">
            <input type="hidden" value="${item.getId()}" name="item_id">
            <button type="submit" class="btn btn-success pull-right">Add</button>
        </form>
    </div>
</c:forEach>
