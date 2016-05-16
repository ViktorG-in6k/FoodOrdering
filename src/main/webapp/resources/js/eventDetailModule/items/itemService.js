var itemService = angular.module('itemService', []);

itemService.factory("ItemService", function ($http, $rootScope, Restaurant) {
    var itemService = {};

    itemService.addNewItem = function (name, price, restaurantId, eventId) {
        return $http({
            method: 'POST',
            url: '/items',
            params: {
                name: name,
                price: price,
                restaurant_id: restaurantId
            }
        })
    };

    itemService.updateItemsList = function () {
        $rootScope.restaurant = Restaurant.get({
            eventId: $rootScope.eventId,
            restaurantId: $rootScope.currentRestaurant
        });
    };
    return itemService;
});

