<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" ng-app="eventApp">
<head>
    <title>Restaurants</title>
    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
    <link href="${bootstrapCss}" rel="stylesheet" />
    <link href="/resources/css/eventDetails.css" rel="stylesheet">
    <link href="/resources/css/bootstrapTheme.css" rel="stylesheet">
</head>
<body >
<<jsp:include page="/WEB-INF/views/jspf/navWithResponsibleUser.jsp" flush="true" />
<br/>
<div class="container" >
    <div class="row">
        <div ng-view></div>
    </div>
</div>

<spring:url value="/resources/core/js/bootstrap.js" var="coreJs" />
<spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs" />
<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>

<script src="/resources/js/angular.min.js"></script>
<link href="/resources/css/font-awesome-4.6.1/css/font-awesome.min.css" rel="stylesheet"/>
<link href="/resources/css/hover-min.css" rel="stylesheet"/>
<script src="/resources/js/angular-route.min.js"></script>
<script src="/resources/js/eventDetailModule/controllers.js"></script>
<script src="/resources/js/eventDetailModule/services.js"></script>
<script src="/resources/js/eventDetailModule/directives.js"></script>
<script src="/resources/js/eventDetailModule/app.js"></script>
</body>

</html>