var orderController = angular.module('orderController', []);

orderController.controller("orderList", function (OrderListService, $scope, $routeParams, $rootScope) {
    $rootScope.orderId = $routeParams.orderId;
    $scope.orderService = OrderListService;
    OrderListService.updateOrderList();
});

orderController.controller("commonOrderList", function ($scope, EventService, $routeParams, $rootScope, OrderListService, RestaurantService, $http) {
    $rootScope.eventId = $routeParams.id;
    $rootScope.currentRestaurant = $routeParams.restaurantId;
    $rootScope.orderId = $routeParams.orderId;

    $http.get("/events/" + $rootScope.eventId).success(function (data) {
        $scope.event = data;
    });

    RestaurantService.getRestaurantById($rootScope.currentRestaurant).success(function (data) {
        $rootScope.restaurant = data;
    });

    $scope.getTotal = OrderListService.getTotal;
    $scope.changeOrderStatusToFreeze = function (orderId) {
        OrderListService.freezeOrder(orderId).then(function(){
            $scope.order.status = "FREEZE";
        })
    };

    $scope.changeOrderStatusToBill = function (orderId, splitBillId) {
        OrderListService.billOrder(orderId, splitBillId).then(function(){
            $scope.order.status = "SPLIT_BILL";
        })
    };

    OrderListService.getOrder($routeParams.orderId).success(function(data){
        $scope.order = data;
    });

    $http.get("api/orders/"+ $rootScope.orderId +"/list").success(function(data){
        $scope.myOrders = data;
    });

    OrderListService.CommonOrder()
});