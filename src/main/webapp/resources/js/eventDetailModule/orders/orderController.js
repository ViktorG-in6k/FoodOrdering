var orderController = angular.module('orderController', []);

orderController.controller("orderList", function (OrderListService, $scope, $routeParams, $rootScope) {
    $rootScope.orderId = $routeParams.orderId;
    $scope.orderService = OrderListService;
    OrderListService.getMyOrder();
});

orderController.controller("commonOrderList", function (ItemService, $scope, EventService, $routeParams,
                                                        $rootScope, OrderListService, RestaurantService, 
                                                        $http, DiscountService) {
    $rootScope.eventId = $routeParams.id;
    $rootScope.currentRestaurant = $routeParams.restaurantId;
    $rootScope.orderId = $routeParams.orderId;

    $scope.addOneItemToOrder = OrderListService.addOneItemToOrder;
    
    $http.get("/events/" + $rootScope.eventId).success(function (data) {
        $scope.event = data;
    });

    RestaurantService.getRestaurantById($rootScope.currentRestaurant).success(function (data) {
        $rootScope.restaurant = data;
    });

    $scope.getTotal = OrderListService.getTotal;
    $scope.changeOrderStatusToFreeze = function (orderId) {
        OrderListService.freezeOrder(orderId).then(function () {
            $scope.order.status = "FREEZE";
        })
    };

    $scope.changeOrderStatusToBill = function (orderId, splitBillId) {
        OrderListService.billOrder(orderId, splitBillId).then(function () {
            $scope.order.status = "SPLIT_BILL";
        })
    };

    OrderListService.getOrder($routeParams.orderId).success(function (data) {
        $scope.order = data;
    });

    $scope.updatePrice = function (itemId, newPrice) {
        ItemService.updateItemPrice(itemId, newPrice);
    };

    $scope.updatePercentageDiscount = function (orderId, percentage) {
        DiscountService.changePercentageDiscount(orderId, percentage).success(function () {
            OrderListService.getCommonOrder()
        })
    };
    
    $scope.updateAmountDiscount = function (orderId, amount) {
        DiscountService.changeAmountDiscount(orderId, amount).success(function () {
            OrderListService.getCommonOrder()
        })
    };
    
    $scope.getPercentageDiscount = OrderListService.getPercentageDiscount;

    OrderListService.getCommonOrder()
});
