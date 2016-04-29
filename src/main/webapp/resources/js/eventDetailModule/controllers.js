var controllers = angular.module('eventApp.controllers', []);

controllers.controller("eventController", function ($http,$scope, $routeParams, $rootScope, OrderListService) {
    $rootScope.eventId = $routeParams.id;
    $scope.addToOrder = OrderListService.addToOrder;
    $scope.removeFromOrder  = OrderListService.removeFromOrder;
    $scope.removeOneItemFromOrder = OrderListService.removeOneItemFromOrder;
    
    $scope.getTotal = OrderListService.getTotal;

    $http.get("/restaurants").success(function (data) {
        $scope.restaurants = data;
    });

    $http.get("/event_"+ $rootScope.eventId).success(function (data) {
        $scope.event = data;
    });
});

controllers.controller("restaurantController", function ($http,$scope, $routeParams, $rootScope, OrderListService) {
    $rootScope.currentRestaurant = $routeParams.restaurantId;
    $scope.addToOrder = OrderListService.addToOrder;
    $scope.removeFromOrder  = OrderListService.removeFromOrder;
    $scope.removeOneItemFromOrder = OrderListService.removeOneItemFromOrder;
    $scope.getTotal = OrderListService.getTotal;


    $http.get("/restaurants").success(function (data) {
        $scope.restaurants = data;
    });

    $http.get("/restaurant_"+ $rootScope.currentRestaurant).success(function (data) {
        $scope.restaurant = data;
    });
});


controllers.controller("orderList", function (OrderListService, $scope) {
    $scope.addToOrder = OrderListService.addToOrder;
    $scope.removeFromOrder  = OrderListService.removeFromOrder;
    $scope.removeOneItemFromOrder = OrderListService.removeOneItemFromOrder;
   OrderListService.updateOrderList();
});


controllers.controller("navbarCtrl",function ($http, $scope) {
    $http.get('/eventsJson/').success(function (data) {
        $scope.events = data;
    });
});
