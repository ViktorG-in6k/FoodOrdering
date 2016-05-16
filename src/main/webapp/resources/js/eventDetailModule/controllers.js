var controllers = angular.module('eventApp.controllers', []);

controllers.controller("eventController", function ($http, $scope, $routeParams, $rootScope,
                                                    ResponsibilityService, RestaurantService, Restaurants) {
        $rootScope.eventId = $routeParams.id;
        $scope.restaurant = {};
        $scope.restaurant.link = '';

        $http.get("/events/" + $rootScope.eventId).success(function (data) {
            $scope.event = data;
            $rootScope.eventName = data.name;
        });


        $scope.updateRestaurantList = function () {
            $http.get("/events/" + $rootScope.eventId + "/restaurants").success(function (data) {
                $scope.restaurants = data;
            });
        };

        $scope.updateRestaurantList();

        $scope.takeResponsibility = function (orderId) {
            ResponsibilityService.takeResponsibility(orderId).success(function () {
                $scope.updateRestaurantList();
            })
        };

        $scope.removeResponsibility = function (orderId) {
            ResponsibilityService.removeResponsibility(orderId).success(function () {
                $scope.updateRestaurantList();
            })
        };

        $scope.createRestaurant = function (restaurant) {
            RestaurantService.createRestaurant(restaurant).success(function () {
                $scope.restaurant = {};
                $scope.restaurant.link = '';
                $scope.updateRestaurantList();
            })
        };

        $scope.updateRestaurantList();
    }
);

controllers.controller("navbarCtrl", function ($http, $scope, $rootScope) {
    $http.get("/getCurrentUser").then(function (data) {
        $rootScope.user = data;
    })
});

