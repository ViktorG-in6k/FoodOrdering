var controllers = angular.module('eventApp.controllers', []);

controllers.controller("eventController", function ($http, $scope, $routeParams, $rootScope) {
        $rootScope.eventId = $routeParams.id;

        $http.get("/events/" + $rootScope.eventId).success(function (data) {
            $scope.event = data;
        });
    
        $http.get("/events/" + $rootScope.eventId + "/restaurants").success(function (data) {
            $scope.restaurants = data;
        });

        $scope.restaurant = {};
        $scope.restaurant.link = '';

        $scope.createRestaurant = function (restaurant, eventId) {
            $http({
                url: "/restaurants",
                method: "POST",
                params: {
                    name: restaurant.title,
                    link: restaurant.link,
                    phone: restaurant.phone,
                    eventId: eventId
                }
            }).success(function () {
                $scope.restaurant = {};
                $scope.restaurant.link = '';
                $http.get("/events/" + $rootScope.eventId + "/restaurants").success(function (data) {
                    $scope.restaurants = data;
                });
            })
        }
    }
);

controllers.controller("navbarCtrl", function ($http, $scope, $rootScope) {
    $http.get("/getCurrentUser").then(function (data) {
        $rootScope.user = data;
    })
});

