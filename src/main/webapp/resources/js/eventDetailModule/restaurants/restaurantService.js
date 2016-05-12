var restaurantService = angular.module('restaurantService', []);

restaurantService.factory("Restaurants", ['$resource', function ($resource) {
    return $resource('/event_:eventId/restaurants');
}]);

restaurantService.factory("RestaurantService", function ($http, $rootScope) {
    var restaurantService = {};
    restaurantService.getRestaurantById = function (id) {
        return $http.get("/event_" + $rootScope.eventId + "/restaurant_" + id)
    };

    return restaurantService;
});

restaurantService.factory("Restaurant", ['$resource', function ($resource) {
    return $resource('/events/:eventId/restaurants/:restaurantId');
}]);
