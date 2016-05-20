var controller = angular.module("orderPlacementStatusController", []);

controller.controller("orderPlacementStatus", function (OrderPlacementStatusService, $rootScope, $scope, $location, Order) {
    $scope.currentOrder = $rootScope.orderId;
    $scope.changeOrder = function (id) {
        var path = '/' + $rootScope.eventId + '/' + $rootScope.currentRestaurant + '/' + id;
        $location.url(path);
    };
    OrderPlacementStatusService.getOrders().success(function (data) {
        $scope.orderPlacementStatus = data;
    });

    $scope.createOrder = function () {
        Order.createOrder($rootScope.eventId, $rootScope.currentRestaurant);
    };

});
