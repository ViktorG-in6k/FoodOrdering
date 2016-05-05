<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" ng-app="eventApp">
<head>
    <title>Restaurants</title>
    <link href="/resources/core/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="/resources/css/eventDetails.css" rel="stylesheet">
    <link href="/resources/css/bootstrapTheme.css" rel="stylesheet">
    <link href="/resources/css/font-awesome-4.6.1/css/font-awesome.min.css" rel="stylesheet"/>
    <link href="/resources/css/hover-min.css" rel="stylesheet"/>
    <link href="/resources/css/commonOrder.css" rel="stylesheet">
    <script src="/resources/core/js/jquery-2.1.4.min.js"></script>
    <script src="/resources/core/js/bootstrap.min.js"></script>
    <script src="/resources/js/angular.min.js"></script>
    <script src="/resources/js/angular-route.min.js"></script>
    <script src="/resources/js/eventDetailModule/controllers.js"></script>
    <script src="/resources/js/eventDetailModule/services.js"></script>
    <script src="/resources/js/eventDetailModule/directives.js"></script>
    <script src="/resources/js/eventsModule/filters.js"></script>
    <script src="/resources/js/eventDetailModule/app.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/jspf/nav.jsp" flush="true"/>
<br/>
<div>
    <div class="row">
        <div ng-view></div>
    </div>
</div>
</body>
</html>

