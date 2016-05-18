var service = angular.module("orderPlacementStatusService", []);

service.service("OrderPlacementStatusService", function ($rootScope, $http) {
    var orderPlacementStatus = {};

    orderPlacementStatus.getOrders = function () {
        return $http({
            url: "api/orderPlacementStatus/",
            method: "GET",
            params: {
                eventId: $rootScope.eventId,
                restaurantId: $rootScope.currentRestaurant
            }
        });
    };

    return orderPlacementStatus;
});
