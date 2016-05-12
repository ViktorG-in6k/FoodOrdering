var orderController = angular.module('orderController', []);

orderController.controller("orderList", function (OrderListService, Order, $scope, $routeParams, $rootScope, $http) {
    $rootScope.orderId = $routeParams.orderId;
    $scope.orderService = OrderListService;
    OrderListService.updateOrderList();
});

