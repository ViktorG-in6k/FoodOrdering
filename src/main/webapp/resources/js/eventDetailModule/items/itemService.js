var itemService = angular.module('itemService', []);

itemService.factory("ItemService", function ($http, $rootScope) {
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