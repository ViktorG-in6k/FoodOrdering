<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en" ng-app="restaurantApp">
<head>
    <title>Restaurants</title>

    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />
    <link href="${bootstrapCss}" rel="stylesheet" />
    <link href="${coreCss}" rel="stylesheet" />
    <script src="/resources/js/angular.min.js"></script>
</head>

<jsp:include page="/WEB-INF/views/jspf/nav.jsp" flush="true" />
<br/>
<div class="container">

    <jsp:include page="/WEB-INF/views/jspf/creatorOfRestaurant.jsp" flush="true" />
    <jsp:include page="/WEB-INF/views/jspf/restaurantList.jsp" flush="true" />

</div>

<spring:url value="/resources/core/js/bootstrap.js" var="coreJs" />
<spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs" />
<spring:url value="/resources/core/js/bootstrap.min.js" var="jQuery"/>

<script src="${jQuery}"></script>
<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>
<script src="/resources/js/restaurantApp.js"></script>
</html>