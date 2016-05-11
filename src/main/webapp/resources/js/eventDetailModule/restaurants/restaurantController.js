var restaurantController = angular.module('restaurantController', []);

restaurantController.controller("restaurantController", function ($http, $scope, $routeParams, $rootScope, OrderListService) {
    $rootScope.currentRestaurant = $routeParams.restaurantId;
    $rootScope.eventId = $routeParams.id;

    $http.get("/CommonOrderJson_" + $rootScope.eventId + "/" + $rootScope.currentRestaurant).success(function (data) {
        $rootScope.responsible = data.userResponsibility;
    });
    $scope.addToOrder = OrderListService.addToOrder;
    $scope.removeFromOrder = OrderListService.removeFromOrder;
    $scope.removeOneItemFromOrder = OrderListService.removeOneItemFromOrder;
    $scope.getTotal = OrderListService.getTotal;

    $http.get("/event_" + $rootScope.eventId + "/restaurants").success(function (data) {
        $scope.restaurants = data;
    });

    $http.get("/event_" + $rootScope.eventId + "/restaurant_" + $rootScope.currentRestaurant).success(function (data) {
        $rootScope.restaurant = data;
        console.log(data.orderPlacementStatus.order.id);
        $rootScope.currentOrderId = data.orderPlacementStatus.order.id;
    });
});