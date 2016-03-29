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


<div class="jumbotron well col-md-9 pull-left">


    <div class="col-md-12">
        <c:forEach items="${allEvents}" var="events">
            <div class="col-md-12">
                <img src="${events.getImageURL()}" class="img-thumbnail pull-left">
                <h2>
                    <label class="col-md-3">
                            ${events.getName()}
                    </label>
                </h2>

                <label class="pull-right">
                        ${events.getDate()}
                </label>
                <p>
                    <label class="col-md-6">
                            ${events.getDescription()}
                    </label>
                </p>

                <p>
                    <a class="btn btn-primary btn-large  pull-right" href="/${events.getId()}">Participate</a>
                </p>

            </div>
        </c:forEach>
    </div>


</div>

<form role="form" action="/new_event" class="col-md-3 pull-right">
    <fieldset>
        <legend>NEW EVENT</legend>

        <div class="form-group">
            <label for="name">Event name:</label>
            <input type="text" class="form-control" id="name" name="name">
        </div>

        <div class="form-group">
            <label for="discript">Discription:</label>
            <input type="password" class="form-control" id="discript" name="discript">
        </div>

        <div class="form-group">
            <label for="image">URL-image:</label>
            <input type="password" class="form-control" id="image" name="image">
        </div>

        <div class="form-group">
            <label for="date">Date:</label>
            <input type="date" class="form-control" id="date" name="date">
        </div>

        <button type="submit" class="btn btn-default pull-right">Add</button>
    </fieldset>
</form>


