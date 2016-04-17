var controllers = angular.module('eventApp.controllers', []);

controllers.controller("eventController", function ($http,$scope, $routeParams, $rootScope, orderListService,restaurantService) {
    $rootScope.eventId = $routeParams.id;
    $scope.addToOrder = orderListService.addToOrder;
    $scope.getTotal = orderListService.getTotal;
    $http.get("/restaurants").success(function (data) {
        $scope.restaurants = data;
    })
});

controllers.controller("orderList", function (orderListService) {
   orderListService.updateOrderList();
});

