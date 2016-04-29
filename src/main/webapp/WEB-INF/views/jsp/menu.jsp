<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Maven + Spring MVC + @JavaConfig</title>
    <link href="/resources/core/css/bootstrap.min.css" rel="stylesheet"/>
    <link href="/resources/css/menu.css" rel="stylesheet"/>
    <link href="/resources/css/xeditable.css" rel="stylesheet"/>
    <script src="/resources/js/angular.min.js"></script>
    <script src="/resources/core/js/jquery-2.1.4.min.js"></script>
    <script src="/resources/core/js/bootstrap.min.js"></script>
    <script src="/resources/js/xeditable.min.js"></script>
    <script src="/resources/js/restaurant.js"></script>
</head>
<body>
<jsp:include page="/WEB-INF/views/jspf/nav.jsp" flush="true"/>
<br/>
<jsp:include page="/WEB-INF/views/jspf/creatorOfItemInMenu.jsp" flush="true"/>
<div class="container" ng-app="restaurant" ng-controller="main">
    <div class="well col-md-8">
        <img src="{{restaurant.imageURL}}" width="100px"
             height="100px;" style="float: left; ">
        <h2 style="padding-left: 120px"><a href="#" editable-text="restaurant.name"
                                           onbeforesave="updateRestaurantName($data, restaurant.id)">{{restaurant.name}}</a>
        </h2>
        <p class="phone">
            <a href="#" href="#" editable-textarea="restaurant.phone"
               onbeforesave="updateRestaurantDescription($data, restaurant.id)"> {{restaurant.phone}}</a>
        </p>
    </div>

    <div class="well col-md-8 pull-left col-sm-8 col-xs-8 col-lg-8" style="padding-right: 10px; padding-right: 17px"
         ng-repeat="item in restaurant.itemList">
        <div class="text-info col-md-7" style="font-size: 19px; color: #000000;">
              <span>
                <a href="#" editable-text="item.name" onbeforesave="updateItemName($data,item.id)"> {{item.name}}  </a>
            </span>
        </div>
        <div class="text-info  pull-right" style="font-size: 19px; color: #000000;">
            <span class="price">
                <a href="#" editable-text="item.price" onbeforesave="updateItemPrice($data,item.id)"> {{'&#8372 '+ item.price}}  </a>
            </span>
        </div>
        <div class="col-md-7 text-left">
            <p>
                <a href="#" editable-text="item.phone" onbeforesave="updateItemDescription($data,item.id)">
                    {{item.phone}}</a>
            </p>
        </div>
    </div>
</div>
</body>
</html>

