<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: employee
  Date: 3/28/16
  Time: 12:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<div class="container">--%>
<%--<div class="row">--%>

<spring:url value="/resources/core/css/hello.css" var="coreCss"/>
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>

<form role="form" action="/new_event" method="post" class="col-md-3 pull-right">
    <fieldset>
        <legend>NEW EVENT</legend>

        <div class="form-group">
            <label for="name">Event name:</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>

        <div class="form-group">
            <label for="discript">Discription:</label>
            <input type="text" class="form-control" id="discript" name="discript">
        </div>

        <div class="form-group">
            <label for="image">URL-image:</label>
            <input type="url" class="form-control" id="image" name="image">
        </div>

        <div class="form-group">
            <label for="date">Date:</label>
            <input type="datetime-local" class="form-control" id="date" name="date">
        </div>

        <button type="submit" class="btn btn-success pull-right">Add</button>
    </fieldset>
</form>

<c:forEach items="${allEvents}" var="events">
    <%--<div class="jumbotron well col-md-9 pull-left">--%>
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

                    <a class="btn btn-primary pull-right" href="/events/${events.getId()}">Participate</a>

                </c:if>
                <c:if test="${empty events.getImageURL()}">
                    <div class="text-info "><h2> ${events.getName()}</h2></div>

                    <label class="pull-right">
                            ${events.getDate()}
                    </label>
                    <div class="col-md-10 text-left">
                            ${events.getDescription()}
                    </div>

                    <a class="btn btn-primary col-md-offset-10 pull-right" href="/events/${events.getId()}">Participate</a>

                </c:if>


            </form>
        </div>

        <%--<c:if test="${not empty events.getImageURL()}">--%>
            <%--<img src="${events.getImageURL()}" class="img-thumbnail pull-left" width="200" height="100">--%>
            <%--<div class="text-info  col-md-4"> ${events.getName()}</div>--%>

            <%--<label class="col-sm-offset-6">--%>
                    <%--${events.getDate()}--%>
            <%--</label>--%>
            <%--<p class="col-md-6 text-left">--%>
                    <%--${events.getDescription()}--%>
            <%--</p>--%>

                <%--<a class="btn btn-primary col-sm-offset-6" href="/${events.getId()}">Participate</a>--%>

        <%--</c:if>--%>
        <%--<c:if test="${empty events.getImageURL()}">--%>
            <%--<div class="text-info  col-md-4"> ${events.getName()}</div>--%>

            <%--<label class="pull-right col-sm-offset-10">--%>
                    <%--${events.getDate()}--%>
            <%--</label>--%>
            <%--<p class="col-md-6 pull-left text-left">--%>
                    <%--${events.getDescription()}--%>
            <%--</p>--%>
            <%--<p>--%>
                <%--<a class="btn btn-primary col-sm-offset-11" href="/${events.getId()}">Participate</a>--%>
            <%--</p>--%>
        <%--</c:if>--%>


    <%--</div>--%>
</c:forEach>




