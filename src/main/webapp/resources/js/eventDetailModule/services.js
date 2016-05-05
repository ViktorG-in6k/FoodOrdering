var services = angular.module('eventApp.services', []);

services.factory("OrderListService", function ($http, $rootScope) {
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

    orderListService.removeFromOrder = function (eventId, itemId) {
        $http({
            method: 'GET',
            url: "/remote_from_order" + itemId + "_" + eventId
        }).then(function () {
            orderListService.updateOrderList();
        });
    };

    orderListService.removeOneItemFromOrder = function (eventId, itemId) {
        $http({
            method: 'POST',
            url: '/remote_one_item_from_order',
            params: {
                event_id: eventId,
                item_id: itemId
            }
        }).then(function () {
            orderListService.updateOrderList();
        });
    };

    orderListService.updateOrderList = function () {
        $http.get("/MyOrderJson_" + $rootScope.eventId + "/" + $rootScope.currentRestaurant).success(function (data) {
            $rootScope.myOrders = data;
        })
    };

    orderListService.getTotal = function () {
        var total = 0;
        if ($rootScope.myOrders) {
            for (var i = 0; i < $rootScope.myOrders.orderList.length; i++) {
                total += $rootScope.myOrders.orderList[i].count * $rootScope.myOrders.orderList[i].item.price;
            }
        } else return 0;
        return total;
    };

    orderListService.removeNumberItemFromOrder = function (itemId, eventId, number) {
        $http({
            method: 'POST',
            url: '/remote_one_item_from_order',
            params: {
                event_id: eventId,
                item_id: itemId,
            }
        }).finally(function () {
            orderListService.updateOrderList();
        });
    };

    orderListService.addOneItemToOrder = function (itemId, eventId) {
        console.log("lol");
        $http({
            method: 'POST',
            url: '/add_one_item_to_order',
            params: {
                event_id: eventId,
                item_id: itemId
            }
        }).finally(function () {
            orderListService.updateOrderList();
        });
    };

    orderListService.updateNumberItemToOrder = function (itemId, eventId, number) {
        $http({
            method: 'POST',
            url: '/update_number_item_to_order',
            params: {
                event_id: eventId,
                item_id: itemId,
                number: number
            }
        }).finally(function () {
            orderListService.updateOrderList();
        });
    };

    orderListService.changeItemNumber = function (eventId, itemId, count) {
        orderListService.addOneItemToOrder(itemId, eventId);
    };

    return orderListService;
});

services.factory("ItemService", function ($http) {
    var itemService = {};
    itemService.addNewItem = function (dataForRequest) {
        return $http.post('/new_item', dataForRequest)
    };
    return itemService;
});

services.factory("RestaurantService", function ($http) {
    var restaurantService = {};
    restaurantService.getRestaurantById = function (id) {
        return  $http.get("/restaurant_" + id)
    };
    
    return restaurantService;
});

services.factory("EventService", function ($http) {
   var eventService = {};

    eventService.getEventById = function (id) {
       return $http.get("/event_" + id);
    };

    return eventService;
});
