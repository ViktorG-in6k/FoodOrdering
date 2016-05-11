var orderController = angular.module('orderController', []);

orderController.controller("orderList", function (OrderListService, $scope, $rootScope, $http) {
        $scope.addToOrder = OrderListService.addToOrder;
        $scope.removeFromOrder = OrderListService.removeFromOrder;
        $scope.updateNumberItemToOrder = OrderListService.updateNumberItemToOrder;
        $scope.updateOrderList = OrderListService.updateOrderList();
        $scope.CommonOrder = OrderListService.CommonOrder();
        $scope.changeItemNumber = OrderListService.changeItemNumber;
        $scope.addOneItemToOrder = OrderListService.addOneItemToOrder;
        $scope.removeOneItemFromOrder = OrderListService.removeOneItemFromOrder;
        $scope.myItems = 'active';

        $scope.getMyItems = function () {
            OrderListService.updateOrderList();
        };

        $scope.getAllItems = function ($rootScope) {
            console.log('a');
            $http.get("/orders/"+$rootScope.currentOrderId).success(function (data) {
                $rootScope.myOrders = data;
                $rootScope.commonOrders = data;
            })
        };
        OrderListService.updateOrderList( $rootScope.restaurant);
    }
);


orderController.controller("commonOrderList", function ($scope, EventService, $routeParams, $rootScope, OrderListService, RestaurantService, $http) {
    $rootScope.eventId = $routeParams.id;
    $rootScope.currentRestaurant = $routeParams.restaurantId;
    EventService.getEventById($scope.eventId).success(function (data) {
        $scope.event = data;
    });
    RestaurantService.getRestaurantById($rootScope.currentRestaurant).success(function (data) {
        $rootScope.restaurant = data;
    });
    $rootScope.order = "Order";
    $rootScope.currentRestaurant = $routeParams.restaurantId;

    $scope.getTotal = OrderListService.getTotal;

    $http.get("/CommonOrderJson_" + $rootScope.eventId + "/" + $rootScope.currentRestaurant).success(function (data) {
        $rootScope.myOrders = data;
        $rootScope.commonOrders = data;
    })
});