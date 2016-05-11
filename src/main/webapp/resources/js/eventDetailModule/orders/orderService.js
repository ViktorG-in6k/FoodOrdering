var orderService = angular.module('orderService', []);

orderService.factory("OrderListService", function ($http, $rootScope) {
    var orderListService = {};

    orderListService.addOneItemToOrder = function (itemId, orderId) {
        console.log(itemId);
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
        $http({
            method: 'POST',
            url: "/orders/" + orderId + "/items/" + itemId + '/' + number,
            params: {
                number: number
            }
        }).finally(function () {
            orderListService.updateOrderList();
        });
    };

    orderListService.takeResponsibility = function (orderId) {
        $http.post("/orders/" + orderId + "/responsibility").success(function () {
            orderListService.updateOrderList();
        })
    };

    orderListService.removeFromOrder = function (eventId, itemId) {
        $http({
            method: 'GET',
            url: "/remote_from_order" + itemId + "_" + eventId
        }).then(function () {
            orderListService.updateOrderList();
        });
    };    

    orderListService.CommonOrder = function () {
        $http.get("/orders/" + $rootScope.currentOrderId).success(function (data) {
            $rootScope.myOrders = data;
            $rootScope.commonOrders = data;
        })
    };

    orderListService.updateOrderList = function () {
        $http.get("/orders/" + $rootScope.currentOrderId).success(function (data) {
            $rootScope.myOrders = data;
            $rootScope.commonOrders = data;
        })
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

    return orderListService;
});

orderService.factory('Order', ['$resource', function ($resource) {
    return $resource('/order/:id');
}]);