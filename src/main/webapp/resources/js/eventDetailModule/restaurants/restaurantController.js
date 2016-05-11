var restaurantController = angular.module('restaurantController', []);

restaurantController.controller("restaurantController", function ($http, $scope, $routeParams, $rootScope, Restaurants) {
    $rootScope.currentRestaurant = $routeParams.restaurantId;
    $rootScope.eventId = $routeParams.id;

    $scope.restaurants = Restaurants.query();
    
    $http.get("/events/" + $rootScope.eventId + "/restaurants/" + $rootScope.currentRestaurant).success(function (data) {
        $rootScope.restaurant = data;
        $rootScope.currentOrderId = data.orderPlacementStatus.order.id;
    });
                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                              });