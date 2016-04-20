<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<script src="/resources/js/angular.min.js"></script>
<script src="/resources/js/angular-route.min.js"></script>
<script src="/resources/js/app.js"></script>
<head>
    <title>Maven + Spring MVC + @JavaConfig</title>
    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>
    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="/resources/css/test.css" rel="stylesheet"/>
    <link href="/resources/css/bootstrapTheme.css" rel="stylesheet">
</head>
<body ng-app="foodOrdering">
    <jsp:include page="/WEB-INF/views/jspf/navWithResponsibleUser.jsp" flush="true" />
    <div ng-app="foodOrdering" class="container">
        <jsp:include page="/WEB-INF/views/jspf/creatorOfEvent.jsp" flush="true" />
        <div ng-view></div>
    </div>

    <script src="/resources/core/css/bootstrap.css"></script>
    <script src="/resources/core/js/jquery-2.1.4.min.js"></script>
    <script src="/resources/core/js/bootstrap.js"></script>

</body>
</html>