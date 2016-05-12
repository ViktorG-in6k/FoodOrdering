var restaurantController = angular.module('restaurantController', []);

restaurantController.controller("restaurantController", function ($http, $scope, $routeParams, $rootScope,
                                                                  Restaurants, Restaurant) {
    $rootScope.currentRestaurant = $routeParams.restaurantId;
    $rootScope.eventId = $routeParams.id;
    $rootScope.orderId = $routeParams.orderId;
    
    $scope.restaurants = Restaurants.query();

    $rootScope.restaurant = Restaurant.get({
        eventId: $rootScope.eventId,
        restaurantId: $rootScope.currentRestaurant
    });
});
