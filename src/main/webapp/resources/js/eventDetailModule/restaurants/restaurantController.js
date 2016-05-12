var restaurantController = angular.module('restaurantController', []);

restaurantController.controller("restaurantController", function ($http, $scope, $routeParams, $rootScope,
                                                                  Restaurants, Restaurant, newRestaurant) {
    $rootScope.currentRestaurant = $routeParams.restaurantId;
    $scope.addNewRestaurant = newRestaurant.createRestaurant;
    $rootScope.eventId = $routeParams.id;
    $rootScope.orderId = $routeParams.orderId;
    $rootScope.restaurant = Restaurant.get({
        eventId: $rootScope.eventId,
        restaurantId: $rootScope.currentRestaurant
    });
});
