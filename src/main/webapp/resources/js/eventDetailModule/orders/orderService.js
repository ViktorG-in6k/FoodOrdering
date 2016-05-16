var orderService = angular.module('orderService', []);

orderService.factory("OrderListService", function ($http, $rootScope, RestaurantService) {
    var orderListService = {};

    orderListService.addOneItemToOrder = function (itemId, orderId) {
        $http.post("/orders/" + orderId + "/items/" + itemId).finally(function () {
            orderListService.updateOrderList(orderId);
        });
    };

    orderListService.removeOneItemFromOrder = function (itemId, orderId) {
        $http.delete("/orders/" + orderId + "/items/" + itemId).finally(function () {
            orderListService.updateOrderList(orderId);
        });
    };

    orderListService.updateNumberItemToOrder = function (itemId, orderId, number) {
        $http.put("/orders/" + orderId + "/items/" + itemId + '/' + number).finally(function () {
            orderListService.updateOrderList(orderId);
        });
    };

    orderListService.removeFromOrder = function (orderId, itemId) {
        $http.delete("/orders/" + orderId + "/items/" + itemId + "/all").finally(function () {
            orderListService.updateOrderList(orderId);
        });
    };

    orderListService.CommonOrder = function () {
        $http.get("/orders/" + $rootScope.orderId).success(function (data) {
            $rootScope.myOrders = data;
            $rootScope.commonOrders = data;
        })
    };

    orderListService.updateOrderList = function () {
        $http.get("/orders/" + $rootScope.orderId).success(function (data) {
            $rootScope.myOrders = data;
            $rootScope.commonOrders = data;
        })
    };

    orderListService.getOrder = function (orderId) {
        return $http.get("/api/orders/" + orderId);
    };

    orderListService.getTotal = function () {
        var total = 0;

        if ($rootScope.myOrders) {
            for (var i = 0; i < $rootScope.myOrders.length; i++) {
                total += $rootScope.myOrders[i].itemAmount * $rootScope.myOrders[i].item.price;
            }
        } else return 0;
        return total;
    };

    orderListService.freezeOrder = function (orderId) {
        return $http({
            url: "orders/" + orderId + "/status",
            method: "PUT",
            params: {status: "FREEZE", splitBillId: 3}
        })
    };

    orderListService.billOrder = function (orderId, splitBillId) {
        return $http({
            url: "orders/" + orderId + "/status",
            method: "PUT",
            params: {status: "SPLIT_BILL", splitBillId: splitBillId}
        })
    };

    return orderListService;
});

orderService.factory('Order', function ($http, $location) {
    var order = {};
    order.createOrder = function (eventId, restaurantId) {
        $http({
            url: "api/orders",
            method: "POST",
            params: {
                eventId: eventId,
                restaurantId: restaurantId
            }
        }).success(function (order) {
            var path = '/' + eventId + '/' + restaurantId + '/' + order.id;
            $location.url(path);
        })
    };
    return order;
});
