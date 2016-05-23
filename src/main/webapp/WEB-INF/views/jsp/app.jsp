<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en" ng-app="eventApp">
<head>
    <meta content='text/html; charset=UTF-8' http-equiv='Content-Type'/>
    <title>Restaurants</title>
    <link href="/resources/css/lib/xeditable.min.css" rel="stylesheet">
    <link href="/resources/css/lib/bootstrap.min.css" rel="stylesheet"/>
    <link href="/resources/css/eventDetails.css" rel="stylesheet">
    <link href="/resources/css/lib/bootstrapTheme.css" rel="stylesheet">
    <link href="/resources/css/lib/font-awesome-4.6.1/css/font-awesome.min.css" rel="stylesheet"/>
    <link href="/resources/css/commonOrder.css" rel="stylesheet">

    <link rel="stylesheet" href="/resources/css/lib/kendoLib/kendo.rtl.css"/>
    <link rel="stylesheet" href="/resources/css/lib/kendoLib/kendo.silver.css"/>
    <link rel="stylesheet" href="/resources/css/lib/kendoLib/kengo.modile.css"/>

    <link href="/resources/css/eventsStyle.css" rel="stylesheet"/>

    <link href="/resources/css/restaurantDetails.css" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/lib/kendoLib/kendo.common.min.css"/>
    <script src="/resources/js/lib/jquery-2.1.4.min.js"></script>
    <script src="/resources/js/lib/angular.min.js"></script>
    <script src="/resources/js/lib/angular-route.min.js"></script>
    <script src="/resources/js/eventDetailModule/controllers.js"></script>
    <script src="/resources/js/eventDetailModule/services.js"></script>
    <script src="/resources/js/eventDetailModule/directives.js"></script>
    <script src="/resources/js/eventsModule/filters.js"></script>


    <script src="/resources/js/lib/kendo.js"></script>
    <script src="/resources/js/lib/angular-resource.js"></script>
    <script src="/resources/js/eventDetailModule/events/eventsController.js"></script>
    <script src="/resources/js/eventDetailModule/events/eventsService.js"></script>

    <script src="/resources/js/eventDetailModule/items/itemController.js"></script>
    <script src="/resources/js/eventDetailModule/items/itemService.js"></script>

    <script src="/resources/js/eventDetailModule/orders/orderController.js"></script>
    <script src="/resources/js/eventDetailModule/orders/orderService.js"></script>
    <script src="/resources/js/eventDetailModule/orders/changeItemAmountDirective.js"></script>
    <script src="/resources/js/eventDetailModule/orderPlacementStatus/orderPlacementStatusController.js"></script>
    <script src="/resources/js/eventDetailModule/orderPlacementStatus/orderPlacementStatusServce.js"></script>
    <script src="/resources/js/eventDetailModule/orders/commonOrderService.js"></script>

    <script src="/resources/js/eventDetailModule/restaurants/restaurantController.js"></script>
    <script src="/resources/js/eventDetailModule/restaurants/restaurantService.js"></script>

    <script src="/resources/js/eventDetailModule/responsible/responsibleService.js"></script>

    <script src="/resources/js/lib/ui-bootstrap-tpls-1.3.2.min.js"></script>
    <script src="/resources/js/lib/angular-touch.js"></script>
    <script src="/resources/js/lib/angular-animate.js"></script>
    <script src="/resources/js/eventDetailModule/app.js"></script>
    <script src="/resources/js/lib/x-editable.js"></script>
    <script src="/resources/js/eventDetailModule/orders/percentageDiscountFilter.js"></script>
    <script src="/resources/js/eventDetailModule/orders/discountService.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/jspf/nav.jsp" flush="true"/>
<br/>
<div>
    <div class="container-fluid">
    <div class="row app">
        <div ng-view></div>
    </div>
    </div>
</div>
</body>
</html>

