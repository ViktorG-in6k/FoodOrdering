<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Maven + Spring MVC + @JavaConfig</title>
    <link href="/resources/core/css/bootstrap.min.css" rel="stylesheet" />
    <script src="/resources/js/angular.min.js"></script>
</head>

<jsp:include page="/WEB-INF/views/jspf/nav.jsp" flush="true" />
<br/>
<div class="container"  ng-app="">
    <jsp:include page="/WEB-INF/views/jspf/creatorOfItemInMenu.jsp" flush="true" />
    <jsp:include page="/WEB-INF/views/jspf/itemsList.jsp" flush="true" />
</div>

<script src="/resources/core/js/jquery-2.1.4.min.js"></script>
<script src="/resources/core/js/bootstrap.min.js"></script>
</html>


