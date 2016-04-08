<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html  ng-app="myApp"  lang="en">
<head>
<title>Maven + Spring MVC + @JavaConfig</title>
 
<spring:url value="/resources/core/css/hello.css" var="coreCss" />
<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss" />

<link href="${bootstrapCss}" rel="stylesheet" />
<link href="${coreCss}" rel="stylesheet" />

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular.min.js"></script>
    <script src="/resources/js/app.js"></script>
</head>

<jsp:include page="/WEB-INF/views/jspf/nav.jsp" flush="true" />

<div class="container">
    <jsp:include page="/WEB-INF/views/jspf/creatorOfEvent.jsp" flush="true" />

    <jsp:include page="/WEB-INF/views/jspf/eventList.jsp" flush="true" />



</div>

<spring:url value="/resources/core/js/bootstrap.js" var="coreJs" />
<spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs" />
<spring:url value="/resources/core/js/bootstrap.min.js" var="jQuery"/>

<script src="${jQuery}"></script>
<script src="${coreJs}"></script>
<script src="${bootstrapJs}"></script>

</html>