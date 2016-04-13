<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%--<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>--%>
<%--<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>--%>
<%--<!DOCTYPE html>--%>
<%--<html lang="en">--%>
<%--<head>--%>
<%--<title>Maven + Spring MVC + @JavaConfig</title>--%>

<%--<spring:url value="/resources/core/css/test.css" var="coreCss"/>--%>
<%--<spring:url value="/resources/core/css/bootstrap.min.css" var="bootstrapCss"/>--%>

<%--<link href="${bootstrapCss}" rel="stylesheet"/>--%>
<%--<link href="${coreCss}" rel="stylesheet"/>--%>


<%--</head>--%>
<%--<jsp:include page="/WEB-INF/views/jspf/nav.jsp" flush="true"/>--%>
<%--&lt;%&ndash;<div class='bold-line'></div>&ndash;%&gt;--%>
<%--<div class='container'>--%>
<%--<div class='window'>--%>
<%--<div class='overlay'></div>--%>
<%--<div class='content'>--%>
<%--<div class='welcome'>Hello There!</div>--%>
<%--<div class='subtitle'>We're almost done. Before using our services you need to create an account.</div>--%>
<%--<form action="/events" method="post">--%>
<%--&lt;%&ndash;<div class='input-fields'>&ndash;%&gt;--%>
<%--<div class="input-group">--%>
<%--<input type="text" placeholder="Username" class="input-line full-width"  required>--%>
<%--<input type='email' placeholder='Email' class='input-line full-width'  required>--%>
<%--<input type='password' placeholder='Password' class='input-line full-width'  required>--%>

<%--</div>--%>

<%--<div class='spacing'>or continue with <span class='highlight'>Facebook</span></div>--%>
<%--<div><button class='ghost-round full-width' type="submit">Create Account</button></div>--%>
<%--</form>--%>
<%--</div>--%>
<%--</div>--%>
<%--</div>--%>

<%--<spring:url value="/resources/core/js/bootstrap;l.js" var="coreJs"/>--%>
<%--<spring:url value="/resources/core/js/bootstrap.min.js" var="bootstrapJs"/>--%>
<%--<spring:url value="/resources/core/js/bootstrap.min.js" var="jQuery"/>--%>

<%--<script src="${jQuery}"></script>--%>
<%--<script src="${coreJs}"></script>--%>
<%--<script src="${bootstrapJs}"></script>--%>

<%--</html>--%>
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
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.5.3/angular-route.min.js"></script>


    <spring:url value="/resources/css/test.css" var="coresCss"/>
    <link href="${coresCss}" rel="stylesheet"/>
    <link href="/resources/fonts/css/font-awesome.min.css" rel="stylesheet"/>
    <link href="/resources/fonts/css/font-awesome.css" rel="stylesheet"/>
</head>


<body>
<div class="container">

</div>
</body>
