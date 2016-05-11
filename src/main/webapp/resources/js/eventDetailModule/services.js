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
        $http.delete()
        $http.put("/orders/"+orderId+"/items/"+itemId).finally(function () {
            orderListService.updateOrderList(orderId);
        });
        $http({
            method: 'PUT',
            url: '/remote_one_item_from_order',
            params: {
                event_id: eventId,
                item_id: itemId
            }
        }).then(function () {
            orderListService.updateOrderList();
        });
    };

    orderListService.CommonOrder = function () {
        $http.get("/orders/"+$rootScope.currentOrderId).success(function (data) {
            $rootScope.myOrders = data;
            $rootScope.commonOrders = data;
        })
    };

    orderListService.updateOrderList = function () {
        $http.get("/orders/"+$rootScope.currentOrderId).success(function (data) {
            $rootScope.myOrders = data;
            $rootScope.commonOrders = data;
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

    orderListService.removeNumberItemFromOrder = function (itemId, eventId) {
        $http({
            method: 'POST',
            url: '/remote_one_item_from_order',
            params: {
                event_id: eventId,
                item_id: itemId
            }
        }).finally(function () {
            orderListService.updateOrderList();
        });
    };

    orderListService.addOneItemToOrder = function (itemId, orderId) {
        console.log(itemId);
        $http.put("/orders/"+orderId+"/items/"+itemId).finally(function () {
            orderListService.updateOrderList(orderId);
        });       
    };

    orderListService.updateNumberItemToOrder = function (itemId, eventId, number) {
        $http({
            method: 'POST',
            url: '/update_number_item_to_order',
            params: {
                order_id: eventId,
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

services.factory("ItemService", function ($http, $rootScope) {
    var itemService = {};

    itemService.addNewItem = function (name, price, restaurantId, eventId) {
        return $http({
            method: 'POST',
            url: '/new_item',
            params: {
                name: name,
                price: price,
                event_id: eventId,
                restaurant_id: restaurantId
            }
        });
    };
    return itemService;
});

services.factory("RestaurantService", function ($http, $rootScope) {
    var restaurantService = {};
    restaurantService.getRestaurantById = function (id) {
        return $http.get("/event_" + $rootScope.eventId + "/restaurant_" + id)
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

services.factory("DateTimePicker", function () {
    var dateTimePicker = {};
    dateTimePicker.getConfig = function () {
        return {
            format: "dd-MM-yyyy HH:mm",
            timeFormat: "HH:mm",
            animation: {
                close: {
                    effects: "fadeOut zoom:out",
                    duration: 300
                },
                open: {
                    effects: "fadeIn zoom:in",
                    duration: 300
                }
            },
            disableDates: function (date) {
                var today = new Date();
                var tommorow = today.setDate(today.getDate() - 1);
                return date <= tommorow;
            }
        };
    };
    return dateTimePicker;
});


