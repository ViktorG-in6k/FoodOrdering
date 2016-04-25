<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <script src="/resources/core/js/jquery-2.1.4.min.js"></script>
    <script src="/resources/js/angular.min.js"></script>
    <script src="/resources/js/angular-route.min.js"></script>
    <script src="/resources/js/app.js"></script>
    <script src="/resources/js/xeditable.min.js"></script>
    <script src="/resources/js/moment.js"></script>
    <script src="/resources/js/datetimepicker.js"></script>
    <script src="/resources/js/datetimepicker.templates.js"></script>
    <script src="/resources/js/bootstrap.js"></script>

    <link href="/resources/css/xeditable.css" rel="stylesheet"/>
    <link href="/resources/core/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="/resources/css/test.css" rel="stylesheet"/>
    <link href="/resources/css/bootstrapTheme.css" rel="stylesheet">
    <link href="/resources/css/bootstrap.css" rel="stylesheet">
    <link href="/resources/css/datetimepicker.css" rel="stylesheet"/>

    <title>FoodOrdering</title>

</head>
<body ng-app="foodOrdering">
    <jsp:include page="/WEB-INF/views/jspf/navWithResponsibleUser.jsp" flush="true" />
    <div ng-app="foodOrdering" class="container">
        <jsp:include page="/WEB-INF/views/jspf/creatorOfEvent.jsp" flush="true" />
        <div ng-view></div>
    </div>


</body>
</html>