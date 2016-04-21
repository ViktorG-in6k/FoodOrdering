<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<spring:url value="/resources/core/css/hello.css" var="coreCss"/>
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>

<div class="col-md-8 col-sm-8">
    <jsp:include page="/WEB-INF/views/jspf/eventDetails.jsp"/>

    <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
        <div ng-repeat="restaurant in restaurants" class="panel panel-default">
            <div class="panel-heading" style="padding: 0px" role="tab" id="headingOne">
                <h4 class="panel-title">
                    <div data-toggle="collapse" data-parent="#accordion" href="{{'#' + restaurant.id}}"
                         aria-expanded="true"
                         aria-controls="collapseOne">
                        <div class="panel-body">
                            <a role="button">
                                <img src="{{restaurant.imageURL}}" width="100px"
                                     height="100px;" style="float: left; ">
                                <h1 style="padding-top: 10px;padding-left: 110px;">{{restaurant.name}}</h1>
                                <p style="padding-left: 110px; color: black">{{restaurant.description}}</p>
                            </a>

                        </div>
                    </div>
                </h4>
            </div>
            <div id="{{restaurant.id}}" class="panel-collapse collapse" role="tabpanel" aria-labelledby="headingOne">
                <div class="panel-body" style="padding: 9px;">
                    <div ng-repeat="item in restaurant.itemList" class="well .well-sm hvr-float-shadow ho hoverWell"
                         style="width: 100%;padding: 0px">
                        <a href="" ng-click="addToOrder(eventId,item.id)">
                            <div class="row">
                                <div class="col-lg-1"><h3></h3></div>
                                <div class="col-lg-8"><h2>{{item.name}}</h2>
                                    <p style="color: black">{{item.description}} </p>
                                </div>
                                <div class="col-lg-2"><h3>{{item.price|currency:"UAH"}}</h3></div>
                                <div class="col-lg-1">
                                    <h3 class="plus"><i class="fa fa-plus"></i></h3>
                                </div>
                            </div>
                        </a>
                    </div>
                    <button class="btn pull-right"><a href="/events/event_{{eventId}}/restaurant_{{restaurant.id}}">Add
                        item</a></button>
                </div>
            </div>
        </div>
    </div>
</div>

