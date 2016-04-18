var controllers = angular.module('eventApp.controllers', []);

controllers.controller("eventController", function ($http,$scope, $routeParams, $rootScope, OrderListService) {
    $rootScope.eventId = $routeParams.id;
    $scope.addToOrder = OrderListService.addToOrder;
    $scope.getTotal = OrderListService.getTotal;

    $http.get("/restaurants").success(function (data) {
        $scope.restaurants = data;
    });
    
        $scope.event = {"id":"2","name":"super event"};

/*    $http.get().success(function (data) {
        $scope.event = data;
    })*/
});

controllers.controller("orderList", function (OrderListService, $scope) {
    $scope.addToOrder = OrderListService.addToOrder;
   OrderListService.updateOrderList();
});

