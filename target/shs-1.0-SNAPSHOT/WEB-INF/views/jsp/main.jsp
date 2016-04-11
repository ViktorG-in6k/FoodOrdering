<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Maven + Spring MVC + @JavaConfig</title>

    <spring:url value="/resources/core/css/hello.css" var="coreCss"/>
    <spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>

    <link href="${bootstrapCss}" rel="stylesheet"/>
    <link href="${coreCss}" rel="stylesheet"/>

    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular.min.js"></script>
</head>
<body>
    <jsp:include page="/WEB-INF/views/jspf/nav.jsp" flush="true"/>

    <jsp:include page="/WEB-INF/views/jspf/singin.jsp" flush="true"/>

    <spring:url value="/resources/core/js/bootstrap;l.js" var="coreJs"/>
    <spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs"/>
    <spring:url value="/resources/core/js/bootstrap.min.js" var="jQuery"/>

    <script src="${jQuery}"></script>
    <script src="${coreJs}"></script>
    <script src="${bootstrapJs}"></script>
</body>
>
</html>