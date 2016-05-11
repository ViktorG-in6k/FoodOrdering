var orderController = angular.module('orderController', []);

orderController.controller("orderList", function (OrderListService, $scope, $rootScope, $http) {
        $scope.removeFromOrder = OrderListService.removeFromOrder;
        $scope.updateNumberItemToOrder = OrderListService.updateNumberItemToOrder;
        $scope.updateOrderList = OrderListService.updateOrderList();
        $scope.CommonOrder = OrderListService.CommonOrder();
        $scope.changeItemNumber = OrderListService.changeItemNumber;
        $scope.addOneItemToOrder = OrderListService.addOneItemToOrder;
        $scope.removeOneItemFromOrder = OrderListService.removeOneItemFromOrder;
        $scope.getTotal = OrderListService.getTotal;

        $scope.getMyItems = function () {
            OrderListService.updateOrderList();
        };

        $scope.getAllItems = function ($rootScope) {
            $http.get("/orders/"+$rootScope.currentOrderId).success(function (data) {
                $rootScope.myOrders = data;
                $rootScope.commonOrders = data;
            })
        };
        OrderListService.updateOrderList( $rootScope.restaurant);
    }
);


orderController.controller("commonOrderList", function ($scope, EventService, $routeParams, $rootScope, OrderListService, RestaurantService,Restaurant, $http) {
    $rootScope.eventId = $routeParams.id;
    $rootScope.currentRestaurant = $routeParams.restaurantId;

    EventService.getEventById($scope.eventId).success(function (data) {
        $scope.event = data;
    });
    $rootScope.restaurant = Restaurant.query();


    $rootScope.currentRestaurant = $routeParams.restaurantId;
    $scope.getTotal = OrderListService.getTotal;
});