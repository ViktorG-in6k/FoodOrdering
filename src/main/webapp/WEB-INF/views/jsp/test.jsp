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
    <script src="/resources/js/test.js"></script>

    <spring:url value="/resources/css/test.css" var="coresCss"/>
    <link href="${coresCss}" rel="stylesheet"/>
    <link href="/resources/fonts/css/font-awesome.min.css" rel="stylesheet"/>
    <link href="/resources/fonts/css/font-awesome.css" rel="stylesheet"/>
</head>


<body>
<div class="container">
    <div class="row">
        <div class="col-sm-3 col-md-3">
            <div class="post">
                <div class="post-img-content">
                    <img class="col-md-12" src="http://www.bats.org.uk/data/images/halloween-bat-moon-clipart.jpg" class="img-responsive"/>
                    <span class="post-title">
                        <b>Halloween</b><br/>
                        <b><i class="fa fa-calendar-check-o" aria-hidden="true"></i> Date: 31.10.2016 20:00</b><br/>
                        <b > <i class="fa fa-user" aria-hidden="true"></i> Partycipates: 20people</b>
                    </span>
                </div>
                <br/>
                <div class="content">
                    <div class="author">
                        By <b>Bhaumik</b> |
                        <time datetime="2014-01-20">January 20th, 2014</time>
                    </div>
                    <div>

                        Halloween is a celebration observed in a number of countries on 31 October, the eve of the Western Christian feast of All Hallows' Day. It begins the three-day observance of Allhallowtide, the time in the liturgical year dedicated to remembering the dead, including saints (hallows), martyrs, and all the faithful departed;
                    </div>
                    <div>
                        <a href="http://www.jquery2dotnet.com/2014/01/jquery-highlight-table-row-and-column.html"
                           class="btn btn-warning btn-sm">Read more</a>
                    </div>
                </div>
            </div>
        </div>

    </div>
</div>
</body>
