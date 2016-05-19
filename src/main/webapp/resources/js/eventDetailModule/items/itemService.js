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

    itemService.updateItemPrice = function(itemId, price){
        return $http({
            method: 'PUT',
            url: 'api/items/'+itemId+'/price',
            params: {
                price: price
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

