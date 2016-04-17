var controllers = angular.module('eventApp.controllers', []);

controllers.controller("eventController", function ($http,$scope, $routeParams, $rootScope, OrderListService) {
    $rootScope.eventId = $routeParams.id;
    $scope.addToOrder = OrderListService.addToOrder;
    $scope.getTotal = OrderListService.getTotal;
    $http.get("/restaurants").success(function (data) {
        $scope.restaurants = data;
    });
/*    $scope.restaurants = RestaurantService.getRestaurants();*/
});

controllers.controller("orderList", function (OrderListService) {
   OrderListService.updateOrderList();
});

