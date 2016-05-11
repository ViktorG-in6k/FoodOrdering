var controllers = angular.module('eventApp.controllers', []);

controllers.controller("eventController", function ($http, $scope, $routeParams, $rootScope, OrderListService) {
        $rootScope.eventId = $routeParams.id;
        $rootScope.restaurant = null;
        $scope.addToOrder = OrderListService.addToOrder;
        $scope.removeFromOrder = OrderListService.removeFromOrder;
        $scope.removeOneItemFromOrder = OrderListService.removeOneItemFromOrder;
        $scope.getTotal = OrderListService.getTotal;
        $http.get("/event_" + $rootScope.eventId + "/restaurants").success(function (data) {
            $scope.restaurants = data;
        });

        $http.get("/event_" + $rootScope.eventId).success(function (data) {
            $scope.event = data;
        });
        $scope.takeResponsibility = OrderListService.takeResponsibility;
        $scope.restaurant = {};
        $scope.restaurant.link = '';

        $scope.createRestaurant = function (restaurant, eventId) {
            $http({
                url: "/new_restaurant",
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
                $http.get("/event_" + $rootScope.eventId + "/restaurants").success(function (data) {
                    $scope.restaurants = data;
                });
            })
        }
    }
);

controllers.controller("navbarCtrl", function ($http, $scope, $rootScope) {
    $http.get('/eventsJson/').success(function (data){
        $scope.events = data;
    });

    $http.get("/getCurrentUser").then(function (data) {
        $rootScope.user = data;
    })
});

