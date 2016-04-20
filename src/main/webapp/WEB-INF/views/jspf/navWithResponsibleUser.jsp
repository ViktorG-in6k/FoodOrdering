<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<nav class="navbar navbar-default navbar-fixed-top" ng-controller="navbarCtrl">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/events">Food ordering</a>
        </div>
        <div class="navbar-header pull-right" style=" right: 10px;">

            <ul class="nav navbar-nav" >
                <li class="dropdown">
                    <a  class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">You responsible for orders <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li ng-repeat="event in events"><a ng-if="event.user.email == event.sessionUser.email" href="/events/event_{{event.id}}#/{{event.id}}">{{event.name|limitTo:24}}</a></li>
                    </ul>
                </li>
            </ul>

            <label class="navbar-brand">
                Welcome!
            </label>
        </div>
    </div>
</nav>
<br/><br/><br/>

