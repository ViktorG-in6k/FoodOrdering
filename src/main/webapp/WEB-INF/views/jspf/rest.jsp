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

<c:forEach items="${allRestaurants}" var="events">
    <%--<div class="jumbotron well col-md-9 pull-left">--%>
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




