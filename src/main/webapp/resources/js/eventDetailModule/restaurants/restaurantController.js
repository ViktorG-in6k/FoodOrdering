var restaurantController = angular.module('restaurantController', []);

restaurantController.controller("restaurantController", function ($http, $scope, $routeParams, $rootScope, Restaurant) {
    $rootScope.currentRestaurant = $routeParams.restaurantId;
    $rootScope.eventId = $routeParams.id;
    $rootScope.orderId = $routeParams.orderId;
    $rootScope.restaurant = Restaurant.get({
        eventId: $rootScope.eventId,
        restaurantId: $rootScope.currentRestaurant
    });
});


restaurantController.controller("restaurantMenu", function ($rootScope, Restaurant, $routeParams, $scope, Order) {
    $rootScope.eventId = $routeParams.id;
    $rootScope.currentRestaurant = $routeParams.restaurantId;
    $rootScope.restaurant = Restaurant.get({
        eventId: $rootScope.eventId,
        restaurantId: $rootScope.currentRestaurant
    });
    $scope.createOrder = function () {
        Order.createOrder($rootScope.eventId, $rootScope.currentRestaurant);
    }
});
