<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:url value="/resources/core/css/hello.css" var="coreCss"/>
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>
<div>
    <jsp:include page="/WEB-INF/views/jspf/eventDetails.jsp"/>
</div>
<div class="col-md-8 col-sm-8">
    <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
        <div ng-repeat="restaurant in restaurants" class="panel panel-default" >

            <div style="border:2px black solid; height: 100px; background-color: white">

                <div class="col-md-offset-1 col-md-5">

                        <h3>
                            <a href="/events/event_{{restaurant.id}}">
                            {{restaurant.name}}
                        </a>
                        </h3>

                </div>

                <div class="col-md-offset-5">
                        Participants:
                </div>
            </div>

        </div>
    </div>
</div>

