var services = angular.module('eventApp.services', []);

services.factory("orderListService", function ($http, $rootScope) {
    var orderListService = {};

    orderListService.addToOrder = function (eventId, ItemId) {
        $http({
            method: 'POST',
            url: '/add_to_order',
            params: {
                event_id: eventId,
                item_id: ItemId
            }
        }).then(function () {
            orderListService.updateOrderList();
        });
    };

    orderListService.updateOrderList = function () {
        $http.get("/MyOrderJson_" + $rootScope.eventId).success(function (data) {
            $rootScope.myOrders = data;
        })
    };

    orderListService.getTotal = function () {
        var total =0;
        for(var i =0 ;i<$rootScope.myOrders.myOrderList.length;i++){
            total +=$rootScope.myOrders.myOrderList[i].count * $rootScope.myOrders.myOrderList[i].item.price;
        }
        return total;
    };

    return orderListService;
});

services.factory("restaurantService", function ($http) {
    var restaurantService = {};
    return restaurantService;
});